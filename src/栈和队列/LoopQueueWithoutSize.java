package 栈和队列;

public class LoopQueueWithoutSize<E> implements Queue<E> {
    
    private E[] data;
    private int front;
    private int tail;
    //LoopQueue有意识的浪费一个容量
    //当    front ==  (tail+1)%capacity      时, LoopQueue  满了
    //当    front == tail                           时, LoopQueue  为空
    
    public LoopQueueWithoutSize(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }
    
    public LoopQueueWithoutSize() {
        this(10);
    }
    
    @Override
    public int getSize() {
        if (tail > front) {
            return tail - front;
        }
        if (tail < front) {
            return tail - front + data.length;
        }
        return 0;
    }
    
    @Override
    public boolean isEmpty() {
        return front == tail;
    }
    
    public int getCapacity() {
        //LoopQueue 故意浪费一个容量
        return data.length - 1;
    }
    
    @Override
    public void enqueue(E e) {
        if (front == (tail + 1) % data.length) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }
    
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        int capacity = getCapacity();
        int size = getSize();
        if (size == capacity / 4 && capacity % 2 != 0) {
            resize(capacity /2);
        }
        return e;
    }
    
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        return data[front];
    }
    
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0 ; i < getSize() ; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        front = 0;
        tail = getSize();
        data = newData;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String res = String.format("LoopQueue: size = %d ; capacity = %d " , getSize() , getCapacity());
        builder.append(res);
        builder.append(" front   [ ");
        for (int i = 0 ; i < getSize() ; i++) {
            builder.append(data[(front + i) % data.length]);
            if (i < getSize() - 1) {
                builder.append(" , ");
            }
        }
        builder.append(" ]  tail ");
        return builder.toString();
    }
}
