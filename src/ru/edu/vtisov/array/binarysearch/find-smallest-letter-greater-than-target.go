package binarysearch

func nextGreatestLetter(letters []byte, target byte) byte {
	i, j := 0, len(letters) // j за пределами массива
	for i < j {
		mid := i + (j-i)/2
		if letters[mid] <= target {
			i = mid + 1
		} else {
			j = mid
		}
	}
	return letters[i%len(letters)]
}

// func nextGreatestLetter(letters []byte, target byte) byte {
//     i, j := 0, len(letters)-1

//     for i < j {
//         mid := i+(j-i)/2
//         if letters[mid] <= target {
//             i = mid+1
//         } else {
//             j = mid
//         }
//     }
//     if letters[i] <= target {
//         return letters[0]
//     }
//     return letters[i]
// }
