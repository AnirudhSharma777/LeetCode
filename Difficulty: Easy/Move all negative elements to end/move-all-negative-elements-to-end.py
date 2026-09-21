class Solution:
    def segregateElements(self, arr):
        # code here
        neg = []
        k = 0
        for i in arr:
            if i < 0:
                neg.append(i)
            else:
                arr[k] = i
                k += 1
        
        i = 0
        while k < len(arr):
            arr[k] = neg[i];
            i += 1
            k += 1
        
        
        return arr
            