# Задачи на `map` в Go: практический гайд

Шпаргалка по типичным алгоритмическим задачам, где ключевой инструмент — хеш-таблица. Примеры на Go, в стиле LeetCode.

---

## 0. Основы `map`, которые важны в задачах

```go
m := make(map[int]int)        // пустая мапа
m := map[string]int{"a": 1}   // с литералом

v := m[k]           // чтение: если ключа нет — zero value (0, "", false, nil)
v, ok := m[k]       // ok == false, если ключа нет
m[k] = v            // запись
delete(m, k)        // удаление (безопасно, даже если ключа нет)
len(m)              // количество ключей
```

Что нужно помнить:

- **Чтение отсутствующего ключа не паникует** — возвращает zero value. Это и удобно (`m[k]++` работает сразу), и опасно: `seen[n] == 0` не отличает «не встречали» от «встречали, значение 0».
- **Запись в `nil`-мапу паникует.** `var m map[int]int; m[1] = 1` → panic. Всегда `make` или литерал.
- **Порядок итерации случайный.** Если нужен детерминированный порядок — собирайте ключи в слайс и сортируйте.
- **Ключом может быть только сравнимый тип**: числа, строки, bool, указатели, структуры и массивы из сравнимых типов. Слайсы, мапы, функции — нельзя. Слайс `[]int` как ключ надо превратить в строку или массив.
- **Средняя сложность операций — O(1)**, в худшем случае O(n). Для интервью считаем O(1).

### Мапа как множество (set)

В Go нет `set`, его роль играет `map`. Два идиоматичных варианта:

```go
// 1. map[T]bool — короче в проверках
seen := make(map[int]bool)
seen[x] = true
if seen[x] { ... }       // отсутствующий ключ → false, что и нужно

// 2. map[T]struct{} — нулевой размер значения, подчёркивает «только ключи»
seen := make(map[int]struct{})
seen[x] = struct{}{}
if _, ok := seen[x]; ok { ... }
```

Не смешивайте: с `struct{}` нельзя писать `!seen[x]` или `seen[x] = 1`. Для интервью и небольших задач `map[T]bool` читается проще; `struct{}` уместен в проде на больших объёмах.

---

## 1. Паттерн «seen / visited»: обнаружение повторов и циклов

Идея: запоминаем всё, что встречали; повтор — сигнал.

### Contains Duplicate

```go
func containsDuplicate(nums []int) bool {
    seen := make(map[int]bool)
    for _, x := range nums {
        if seen[x] {
            return true
        }
        seen[x] = true
    }
    return false
}
```

### Happy Number (обнаружение цикла)

Последовательность либо приходит к 1, либо зацикливается. Мапа ловит повтор.

```go
func isHappy(n int) bool {
    seen := make(map[int]bool)
    for n != 1 && !seen[n] {
        seen[n] = true
        n = next(n)
    }
    return n == 1
}

func next(n int) int {
    sum := 0
    for n > 0 {
        d := n % 10
        sum += d * d
        n /= 10
    }
    return sum
}
```

Классическая ошибка — `||` вместо `&&` в условии цикла: для несчастливого числа цикл никогда не завершится. Условие читается как «продолжаем, пока не 1 **и** ещё не видели».

> Альтернатива без памяти — алгоритм Флойда (быстрый и медленный указатель), O(1) по памяти. Мапа проще и достаточна, если про память не спрашивают.

### Longest Substring Without Repeating Characters (seen + скользящее окно)

Здесь в мапе хранится не факт, а **последняя позиция** символа — это позволяет двигать левую границу окна прыжком.

```go
func lengthOfLongestSubstring(s string) int {
    last := make(map[byte]int) // символ → индекс последнего вхождения
    best, left := 0, 0
    for right := 0; right < len(s); right++ {
        if idx, ok := last[s[right]]; ok && idx >= left {
            left = idx + 1
        }
        last[s[right]] = right
        best = max(best, right-left+1)
    }
    return best
}
```

Обратите внимание на `idx >= left`: старое вхождение слева от окна уже не мешает.

---

## 2. Паттерн «дополнение» (complement lookup)

Идея: вместо поиска пары за O(n²) спрашиваем у мапы «а есть ли то, чего мне не хватает?».

### Two Sum

```go
func twoSum(nums []int, target int) []int {
    idx := make(map[int]int) // значение → индекс
    for i, x := range nums {
        if j, ok := idx[target-x]; ok {
            return []int{j, i}
        }
        idx[x] = i
    }
    return nil
}
```

Важно: проверяем **до** записи текущего элемента — иначе при `target == 2*x` элемент найдёт сам себя.

### Subarray Sum Equals K (префиксные суммы)

То же самое, но «дополнение» — это префиксная сумма. Если `prefix[j] - prefix[i] == k`, то подмассив `(i, j]` подходит.

```go
func subarraySum(nums []int, k int) int {
    count := make(map[int]int) // префиксная сумма → сколько раз встречалась
    count[0] = 1               // пустой префикс
    sum, res := 0, 0
    for _, x := range nums {
        sum += x
        res += count[sum-k]
        count[sum]++
    }
    return res
}
```

`count[0] = 1` — самая частая забытая деталь: без неё не считаются подмассивы, начинающиеся с индекса 0.

---

## 3. Паттерн «частоты» (frequency counting)

Идея: посчитать, сколько раз что встречается, а потом рассуждать о счётчиках.

### Valid Anagram

```go
func isAnagram(s, t string) bool {
    if len(s) != len(t) {
        return false
    }
    freq := make(map[rune]int)
    for _, r := range s {
        freq[r]++
    }
    for _, r := range t {
        freq[r]--
        if freq[r] < 0 {
            return false
        }
    }
    return true
}
```

> Если алфавит известен и мал (например, `a–z`), массив `[26]int` быстрее мапы и не аллоцирует. На интервью стоит упомянуть оба варианта.

### First Unique Character

Два прохода: первый считает, второй ищет первый символ со счётчиком 1.

```go
func firstUniqChar(s string) int {
    freq := make(map[rune]int)
    for _, r := range s {
        freq[r]++
    }
    for i, r := range s {
        if freq[r] == 1 {
            return i
        }
    }
    return -1
}
```

### Top K Frequent Elements

Мапа считает, дальше — сортировка или bucket sort по частоте.

```go
func topKFrequent(nums []int, k int) []int {
    freq := make(map[int]int)
    for _, x := range nums {
        freq[x]++
    }
    // bucket[i] — все числа с частотой i
    buckets := make([][]int, len(nums)+1)
    for x, c := range freq {
        buckets[c] = append(buckets[c], x)
    }
    res := make([]int, 0, k)
    for c := len(buckets) - 1; c >= 0 && len(res) < k; c-- {
        res = append(res, buckets[c]...)
    }
    return res[:k]
}
```

---

## 4. Паттерн «группировка» (grouping by key)

Идея: придумать **канонический ключ**, одинаковый для всех элементов одной группы.

### Group Anagrams

Ключ — отсортированная строка или счётчик букв. Второй вариант лучше: массив `[26]int` сравним и может быть ключом мапы без сортировки.

```go
func groupAnagrams(strs []string) [][]string {
    groups := make(map[[26]int][]string)
    for _, s := range strs {
        var key [26]int
        for i := 0; i < len(s); i++ {
            key[s[i]-'a']++
        }
        groups[key] = append(groups[key], s)
    }
    res := make([][]string, 0, len(groups))
    for _, g := range groups {
        res = append(res, g)
    }
    return res
}
```

Здесь важно: `[26]int` — **массив**, а не слайс, поэтому он может быть ключом. `[]int` — не может.

### Isomorphic Strings / Word Pattern (двусторонний маппинг)

Одной мапы мало: нужно проверять, что соответствие взаимно однозначное.

```go
func isIsomorphic(s, t string) bool {
    if len(s) != len(t) {
        return false
    }
    st := make(map[byte]byte)
    ts := make(map[byte]byte)
    for i := 0; i < len(s); i++ {
        a, b := s[i], t[i]
        if x, ok := st[a]; ok && x != b {
            return false
        }
        if y, ok := ts[b]; ok && y != a {
            return false
        }
        st[a], ts[b] = b, a
    }
    return true
}
```

---

## 5. Паттерн «мемоизация» (кэш вычислений)

Идея: результат функции от аргумента кладём в мапу, чтобы не считать дважды. Превращает экспоненциальную рекурсию в линейную/полиномиальную.

### Climbing Stairs / Fibonacci

```go
func climbStairs(n int) int {
    memo := make(map[int]int)
    var f func(int) int
    f = func(k int) int {
        if k <= 2 {
            return k
        }
        if v, ok := memo[k]; ok {
            return v
        }
        memo[k] = f(k-1) + f(k-2)
        return memo[k]
    }
    return f(n)
}
```

Если аргументов несколько — ключом будет структура: `map[[2]int]int` или `map[struct{i, j int}]int`.

---

## 6. Паттерн «мапа + другая структура»

### LRU Cache (map + двусвязный список)

Мапа даёт O(1) доступ к узлу по ключу, список — O(1) перемещение узла в начало и удаление хвоста.

```go
import "container/list"

type entry struct{ key, val int }

type LRUCache struct {
    cap   int
    ll    *list.List
    items map[int]*list.Element
}

func Constructor(capacity int) LRUCache {
    return LRUCache{cap: capacity, ll: list.New(), items: make(map[int]*list.Element)}
}

func (c *LRUCache) Get(key int) int {
    if el, ok := c.items[key]; ok {
        c.ll.MoveToFront(el)
        return el.Value.(*entry).val
    }
    return -1
}

func (c *LRUCache) Put(key, value int) {
    if el, ok := c.items[key]; ok {
        el.Value.(*entry).val = value
        c.ll.MoveToFront(el)
        return
    }
    if c.ll.Len() == c.cap {
        last := c.ll.Back()
        c.ll.Remove(last)
        delete(c.items, last.Value.(*entry).key)
    }
    c.items[key] = c.ll.PushFront(&entry{key, value})
}
```

### Longest Consecutive Sequence (map как set + «старт цепочки»)

Кладём всё в set, затем от каждого числа, у которого нет `x-1` (то есть оно — начало цепочки), идём вправо.

```go
func longestConsecutive(nums []int) int {
    set := make(map[int]bool, len(nums))
    for _, x := range nums {
        set[x] = true
    }
    best := 0
    for x := range set {
        if set[x-1] {
            continue // не начало цепочки
        }
        n := 1
        for set[x+n] {
            n++
        }
        best = max(best, n)
    }
    return best
}
```

Проверка `set[x-1]` — то, что делает алгоритм O(n), а не O(n²): каждая цепочка обходится ровно один раз.

---

## 7. Типичные ошибки

| Ошибка | Что происходит | Как правильно |
|---|---|---|
| `var m map[K]V` без `make`, потом `m[k] = v` | panic: assignment to entry in nil map | `m := make(map[K]V)` |
| `seen[n] == 0` как «не видели» | Не отличает отсутствие от значения 0 | `map[K]bool` или `_, ok := m[k]` |
| `map[T]struct{}` + `!seen[x]` / `seen[x] = 1` | Не компилируется | `_, ok := seen[x]` и `seen[x] = struct{}{}` |
| `\|\|` вместо `&&` в условии цикла с seen | Бесконечный цикл при повторе | «пока не цель **и** не видели» |
| Two Sum: запись в мапу до проверки | Элемент находит сам себя при `target == 2x` | Сначала проверка, потом запись |
| Prefix sum без `count[0] = 1` | Теряются подмассивы с индекса 0 | Инициализировать пустой префикс |
| Полагаться на порядок `range` по мапе | Результат меняется от запуска к запуску | Собрать ключи в слайс и отсортировать |
| Слайс как ключ мапы | Не компилируется | Массив фиксированного размера или строка |
| Изменение значения-структуры через `m[k].field = x` | Не компилируется (unaddressable) | Хранить указатель или перезаписать целиком |
| Удаление из мапы во время `range` | Допустимо в Go — это **не** ошибка | Но добавление во время `range` даёт непредсказуемый обход |

---

## 8. Как выбрать структуру

| Вопрос | Ответ |
|---|---|
| Нужно только «есть / нет»? | `map[T]bool` (или `struct{}`) |
| Нужно считать вхождения? | `map[T]int` |
| Ключ — маленький известный алфавит (`a–z`, цифры)? | Массив `[26]int` / `[10]int` — быстрее и без аллокаций |
| Нужна позиция последнего вхождения? | `map[T]int` с индексом (скользящее окно) |
| Нужен порядок вставки / LRU? | `map` + `container/list` |
| Нужна сортировка по ключу? | `map` + слайс ключей + `sort.Ints` / `slices.Sort` |
| Составной ключ? | Структура или массив из сравнимых полей |
| Ключ — слайс? | Конвертировать в строку (`string(bytes)`) или массив |

Общая эвристика: если задача звучит как «найти пару / повтор / частоту / группу», или в лоб решается за O(n²) с вложенным циклом, — почти всегда внутренний цикл заменяется мапой, и получается O(n).