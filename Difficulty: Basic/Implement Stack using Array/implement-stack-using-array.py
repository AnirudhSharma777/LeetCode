class myStack:
  
    def __init__(self, n):
        # Define Data Structures
        self.stack = []
        self.size = n
        
        

    def isEmpty(self):
        # Check if stack is empty
        return len(self.stack) == 0

    
    def isFull(self):
        # Check if stack is full
        if len(self.stack) == self.size:
            return True
        
        return False

    
    def push(self, x):
        # Insert x at the top of the stack
        if len(self.stack) < self.size:
            self.stack.append(x)
    
    def pop(self):
        # Removes an element from the top of the stack
        if self.stack:
            self.stack.pop()
        
        return -1
    
    def peek(self):
        # Returns the top element of the stack
        if self.stack:
            return self.stack[-1]
        
        return -1
            