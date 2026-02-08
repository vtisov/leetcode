package iteration_in_the_recurrence_relation

import (
	"math"
)

type IterationInTheRecurrenceRelation struct {
	n                   int
	d                   int
	jobDifficulty       []int
	hardestJobRemaining []int
	memo                [][]int
}

func (rec *IterationInTheRecurrenceRelation) dp(i, day int) int {
	if day == rec.d {
		return rec.hardestJobRemaining[i]
	}

	if rec.memo[i][day] == -1 {
		best := math.MaxInt
		hardest := 0
		for j := i; j < rec.n-(rec.d-day); j++ {
			hardest = max(hardest, rec.jobDifficulty[j])
			best = min(best, hardest+rec.dp(j+1, day+1))
		}
		rec.memo[i][day] = best
	}

	return rec.memo[i][day]
}

func minDifficulty(jobDifficulty []int, d int) int {
	n := len(jobDifficulty)

	if n < d {
		return -1
	}

	hardestJobRemaining := make([]int, n)

	hardestJob := 0
	for i := n - 1; i >= 0; i-- {
		hardestJob = max(hardestJob, jobDifficulty[i])
		hardestJobRemaining[i] = hardestJob
	}

	memo := make([][]int, n)
	for i := range memo {
		memo[i] = make([]int, d+1)
		for j := range memo[i] {
			memo[i][j] = -1
		}
	}

	relation := IterationInTheRecurrenceRelation{
		n:                   n,
		d:                   d,
		jobDifficulty:       jobDifficulty,
		hardestJobRemaining: hardestJobRemaining,
		memo:                memo,
	}

	return relation.dp(0, 1)
}
