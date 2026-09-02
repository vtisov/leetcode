package twopointers

func maxProfit(prices []int) int {
	result := 0
	curMin := 0
	for i := 0; i < len(prices); i++ {
		if prices[i] < prices[curMin] {
			curMin = i
		} else if prices[i]-prices[curMin] > result {
			result = prices[i] - prices[curMin]
		}
	}
	return result
}
