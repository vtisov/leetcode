import "fmt"

func maxDistToClosest(seats []int) int {
    if len(seats) == 2 { return 1 }
    result := 0
    count := 0
    i := 0
    for i := 0; i < len(seats); i++ {
        count++
        if seats[i] == 1 {
            result = count - 1
            count = 0
            break
        }
    }
    for ; i < len(seats); i++ {
        count++
        if seats[i] == 1 {
            result = max(result, count/2)
            count = 0
        }
    }
    result = max(result, count)
    return result
}
