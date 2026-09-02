package dp

func maxProfit(prices []int, fee int) int {
	hold := make([]int, len(prices))
	free := make([]int, len(prices))

	free[0] = 0
	hold[0] = -prices[0]

	for i := 1; i < len(prices); i++ {
		free[i] = max(free[i-1], hold[i-1]+prices[i]-fee)
		hold[i] = max(hold[i-1], free[i-1]-prices[i])
	}
	return free[len(prices)-1]
}
