### Min Heap
A binary tree with the following properties:
- Its a complete Binary tree [all levels are completely filled except possibly the last level and the last level has keys
 as left as possible].
 - The parent key is smaller than the the children and right child > left child.
 - Typically represented as an Array
 - The Root Element = A[0]
 - A[(i - 1)/2] - returns parent node
 - A[(2*i) + 1] - returns left child node
 - A[(2*i) + 2] - returns right child node
 
 **Implementation**
 
 ````
 public class MinHeap {
    
    private int capacity = 10;
    private int size = 0;
    
    // heap uses array
    int[] arr = new int [capacity];
    
    private int getLeftChildIndex(int parentIndex) 
        return 2 * parentIndex + 1; 
        
    private int getRightChildIndex(int parentIndex) 
        return 2  parentIndex + 2; 
        
    private int getParentIndex(int childIndex) 
        return (childindex - 1)/2; 
    
    private boolean hasLeftChild(int index) 
        return getLeftChildIndex(index) < size; 
        
    private boolean hasRightChild(int index) 
        return getRightChildIndex(index) < size; 
        
    private boolean hasParent(int index) 
        return getParentIndex(index) >= size; 
    
    private int getLeftChild(int index) 
        return arr[getLeftChildIndex(index)];
        
    private int getRightChild(int index) 
        return arr[getRightChildIndex(index)];}
    
    private int parent(int index) 
        return arr[getParentIndex(index)]
    
    private void swap(int indexOne,int indexTwo){
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
    
    private void ensureCapacity() {
        if(size == capacity) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
    }
    
    // peek
    int peek() {
        if(size == 0)
            throw new IllegalStateException
        return arr[0];
    }
    
    // poll ->returns root element
    int poll() {
        if(size == 0)
          throw new IllegalStateException
        int item = arr[0]; // return root element
        arr[0] = arr[size - 1]; // bring last element to root position
        size--;
        heapifyDown(); // normalize the order
        
        return item          
    }
    
    // insert item
    public void add(int item) {
        ensureCapcity();
        
        arr[size] = item;
        size++;
        heapifyUp();
    }
    
    // heapify up util
    public void heapifyUp(){
        // start at the very last element
        int index = size - 1; 
        
        // check whether heap property is violated for Minheap
        while(hasParent(index) && parent(index) > arr[index]){
            
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    
    // heapify down util
    public void heapifyDown() {
        int index = 0;
        
        // only need to check left child, if not there then definitely no right child
        while(hasLeftChild(index)) {
            
            // take the smaller of the two children
            int smallerChildIndex = getLeftChildIndex;
            
            if(hasRightChild(index) && getRightChild(index)  <  getLeftChild(index))
                smallerChildIndex = getRightChild(index);
            
            if(arr[index] < arr[smallerChildIndex]){
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
 }
 ````
 