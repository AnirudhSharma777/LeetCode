class Solution {
    
    class Pair{
        int first;
        int second;
        
        Pair(int _first,int _second){
            this.first = _first;
            this.second = _second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int it : nums){
            hm.put(it,hm.getOrDefault(it,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a ,b)-> (a.first==b.first) ? (a.second-b.second) : (a.first- b.first));
        
        for(Map.Entry<Integer,Integer> e : hm.entrySet()){
            pq.offer(new Pair(e.getValue(),e.getKey()));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[] result = new int[k];
        while(k > 0){
            result[--k] = pq.poll().second;
        }
        
        return result;
        
    }
}