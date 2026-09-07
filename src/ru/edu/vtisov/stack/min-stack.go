package stack

//https://leetcode.com/problems/min-stack/description/

type MinStack struct {
	stack [][]int
}

func Constructor() MinStack {
	return MinStack{stack: make([][]int, 0)}
}

func (this *MinStack) Push(value int) {
	if len(this.stack) == 0 {
		this.stack = append(this.stack, []int{value, value})
		return
	}
	currentMin := min(this.stack[len(this.stack)-1][1], value)
	this.stack = append(this.stack, []int{value, currentMin})
}

func (this *MinStack) Pop() {
	this.stack = this.stack[:len(this.stack)-1]
}

func (this *MinStack) Top() int {
	return this.stack[len(this.stack)-1][0]
}

func (this *MinStack) GetMin() int {
	return this.stack[len(this.stack)-1][1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(value);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
