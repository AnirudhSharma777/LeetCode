## 01. N-Queen Problem

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/n-queen-problem0315/1)

### Problem Description

**Task:** The N-Queens puzzle is the problem of placing N queens on an N * N chessboard such that no two queens attack each other. Two queens attack each other if they are placed in the same row, the same column, or the same diagonal.
Given an integer n representing the number of queens, find all distinct solutions to this puzzle. Each solution should be represented as an array of size n, where the ith element (1-based indexing) denotes the column position of the queen placed in the ith row.

> **Note:** You may return the solutions in any order.

#### Examples

##### Example 1

- **Input:**
```text
n = 1
```
- **Output:**
```text
[1]
```
- **Explanation:** Only one queen can be placed in the single cell available.

##### Example 2

- **Input:**
```text
n = 4
```
- **Output:**
```text
[[2, 4, 1, 3], [3, 1, 4, 2]]
```
- **Explanation:** There are 2 possible solutions for n = 4.

##### Example 3

- **Input:**
```text
n = 3
```
- **Output:**
```text
[]
```
- **Explanation:** There are no possible solutions for n = 3.

#### Constraints

- **1.** `1 ≤ n ≤ 10`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n!)
- **Expected Auxiliary Space Complexity:** O(n^2)

### Accepted Solutions (1)

#### Solution 1 (Python)

- **Submitted:** 2026-09-25 12:06:05
- **Status:** Correct
- **Marks:** 8

```python
class Solution:
    def nQueen(self, n: int) -> list[list[int]]:
        # code here
        matrix: list[list[int]] = []
        board = [[0] * n for _ in range(n)]
        
        self.helper(board,n,0,matrix)
        return matrix
    
    def helper(self,board,n,row,matrix) -> None:
        if row == n:
            ans = []
            for i in range(n):
                for j in range(n):
                    if board[i][j] == 1:
                        ans.append(j+1)
            
            matrix.append(ans)
            return
        
        for i in range(n):
            if self.isSafe(board,row,i,n):
                board[row][i] = 1
                self.helper(board,n,row+1,matrix)
                board[row][i] = 0
        
    
    def isSafe(self,board,row,col,n):
        
        # checking for row
        for i in range(n):
            if board[i][col] == 1:
                return False
        
        # checking for col
        for j in range(n):
            if board[row][j] == 1:
                return False
        
        #check upper diagonal on left side
        i = row - 1
        j = col - 1

        while i >= 0 and j >= 0:
            # inspect board[i][j]
            if board[i][j] == 1:
                return False
            i -= 1
            j -= 1
        
        # check upper diagonal on right side
        i,j = row-1,col+1
        while i>=0 and j < n:
            if board[i][j] == 1:
                return False
            
            i -= 1
            j += 1
        
        
        return True
```

*Generated on: 9/25/2026, 12:11:59 PM*