class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> maxheap = new PriorityQueue<>(new Comparator<int[]>(){
            
            public int compare(int[] p1,int[] p2){
                return getDistance(p2) - getDistance(p1);
            }
        });
        
        for(int[] point : points){
            
            maxheap.offer(point);
            
            if(maxheap.size() > k){
                maxheap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        
        while(k > 0){
            result[--k] = maxheap.poll();
        }
        
        return result;
    }
    
    
    public int getDistance(int[] points){
        return (int)  Math.pow(points[0] , 2) + (int)Math.pow(points[1] , 2);
    }
}