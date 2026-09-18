class myQueue {
    
    int[] arr;
    int capacity;
    int front;
    int rear;
    int size;
    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        this.arr = new int[n];
        this.capacity = n;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return size == 0;
    }

    public boolean isFull() {
        // Check if queue is full
        return size == capacity;
    }

    public void enqueue(int x) {
        // Enqueue
        if(isFull()){
            return;
        }
        rear = (rear+1) % capacity;
        arr[rear] = x;
        size++;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty()){
            return;
        }
        front = (front+1) % capacity;
        size--;
    }

    public int getFront() {
        // Get front element
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        // Get last element
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }
}
