class myQueue:
    
    def __init__(self, n):
        # Define Data Structures
        self.arr = [None] * n
        self.capacity = n
        self.front = 0
        self.rear = -1
        self.size = 0

    
    def isEmpty(self):
        # Check if queue is empty
        return True if self.size == 0 else False

    
    def isFull(self):
        # Check if queue is full
        return True if self.size == self.capacity else False

    
    def enqueue(self, x):
        # Enqueue
        if self.isFull():
            return;
        
        self.rear = (self.rear + 1) % self.capacity
        self.arr[self.rear] = x
        self.size += 1

    
    def dequeue(self):
        # Dequeue
        if self.isEmpty():
            return;
        
        self.front = (self.front + 1) % self.capacity
        self.size -= 1

    
    def getFront(self):
        # Get front element
        if self.isEmpty():
            return -1
        
        return self.arr[self.front]
       
    
    def getRear(self):
        # Get rear element 
        if self.isEmpty():
            return -1
        
        return self.arr[self.rear]
        
        