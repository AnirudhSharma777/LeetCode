class kQueues {
    
    ArrayList<Integer>[] Q;
    int n;
    int currSize;

    kQueues(int n, int k) {
        // Initialize your data members
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] temp = new ArrayList[k];
        Q = temp;
        
        this.n = n;
        currSize = 0;
        for(int i = 0; i<k; i++){
            Q[i] = new ArrayList<>();
        }
    }

    void enqueue(int x, int i) {
        // enqueue element x into queue number i
        
        if(currSize == n){
            return;
        }
        Q[i].add(x);
        currSize++;
    }

    int dequeue(int i) {
        // dequeue element from queue number i
        if(Q[i].isEmpty()){
            return -1;
        }
        
        currSize--;
        return Q[i].remove(0);
        
    }

    boolean isEmpty(int i) {
        // check if queue i is empty
        return Q[i].size() == 0;
    }

    boolean isFull() {
        // check if array is full
        return n==currSize;
        
    }
}
