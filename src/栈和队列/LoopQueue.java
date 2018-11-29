package 栈和队列;

/**
 * @author Limbo
 */
public class LoopQueue<E> implements Queue<E> {
    
    private E[] data;
    private int front, tail;
    
    private int size;
    //todo:LoopQueue中不声明size，如何完成所有的逻辑？
    
    
    
    public LoopQueue(int capacity) {
        
        //LoopQueue有意识的浪费一个容量
        //当    front ==  (tail+1)%容量     时, LoopQueue 满了
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    
    public LoopQueue() {
        
        this(10);
    }
    
    public int getCapacity() {
        //LoopQueue有意识的浪费一个容量
        return data.length - 1;
    }
    
    @Override
    public int getSize() {
        
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        
        return front == tail;
    }
    
    @Override
    public void enqueue(E e) {
        
        //判断LoopQueue是否满了
        if (front == (tail + 1) % data.length) {
            //满了就进行扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }
    
    @Override
    public E dequeue() {
        
        if (isEmpty()) {
            throw new IllegalArgumentException("LoopQueue is empty");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }
    
    @Override
    public E getFront() {
        
        if (isEmpty()) {
            throw new IllegalArgumentException("LoopQueue is empty");
        }
        return data[front];
    }
    
    private void resize(int newCapacity) {
        
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0 ; i < size ; i++) {
            newData[i] = data[(front + i) % data.length];
            
        }
        data = newData;
        front = 0;
        tail = size;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("LoopQueue: size = %d ; capacity = %d " , size , getCapacity()));
        builder.append(" front   [ ");
        
        for (int i = 0 ; i < size ; i++) {
            builder.append(data[(front + i) % data.length]);
            if (i < size - 1) {
                builder.append(" , ");
            }
        }
        builder.append(" ]  tail ");
        return builder.toString();
        
    }
}
