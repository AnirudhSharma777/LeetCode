## 01. Minimum distance in an Array

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/minimum-distance-between-two-numbers/1)

### Problem Description

**Task:** You are given an array, arr[]. Find the minimum index based distance between two different elements of the array, x and y. Return -1, if either x or y does not exist in the array.

#### Examples

##### Example 1

- **Input:**
```text
arr[] = [1, 2, 3, 2], x = 1, y = 2
```
- **Output:**
```text
1
```
- **Explanation:** x = 1 and y = 2. There are two distances between x and y, which are 1 and 3 out of which the least is 1.

##### Example 2

- **Input:**
```text
arr[] = [86, 39, 90, 67, 84, 66, 62], x = 42, y = 12
```
- **Output:**
```text
-1
```
- **Explanation:** x = 42 and y = 12. We return -1 as x and y don't exist in the array.

##### Example 3

- **Input:**
```text
arr[] = [10, 20, 30, 40, 50], x = 10, y = 50
```
- **Output:**
```text
4
```
- **Explanation:** The distance between x = 10 (index 0) and y = 50 (index 4) is 4, which is the only distance between them.

#### Constraints

- **1.** `1 <= arr.size() <= 10⁵`
- **2.** `0 <= arr[i], x, y <= 10⁵x ! = y`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Python)

- **Submitted:** 2026-09-25 18:35:45
- **Status:** Correct
- **Marks:** 2

```python
class Solution:
    def minDist(self, arr, x, y):
        idx1 = -1
        idx2 = -1
        mini = float('inf')

        
        for i in range(len(arr)):
            if arr[i] == x:
                idx1 = i
            if arr[i] == y:
                idx2 = i
            
            if idx1 != -1 and idx2 != -1:
                mini = min(mini,abs(idx1-idx2))
        
        
        if mini == float('inf'):
            return -1
        
        return mini
```

*Generated on: 9/25/2026, 6:36:29 PM*