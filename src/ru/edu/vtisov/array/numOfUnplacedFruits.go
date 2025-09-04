// https://leetcode.com/problems/fruits-into-baskets-ii/

func numOfUnplacedFruits(fruits []int, baskets []int) int {
    result := 0
    for i := range fruits {
        result++
        for j := range baskets {
            if fruits[i] <= baskets[j] {
                baskets[j] = 0
                result--
                break;
            }
        }
    }
    return result
}
