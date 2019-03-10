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
        //当    front ==  (tail+1)%capacity      时, LoopQueue  满了
        //当    front == tail                           时, LoopQueue  为空
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    
    public LoopQueue() {
        this(10);
    }
    
    public int getCapacity() {
        //LoopQueue 故意浪费一个容量
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
    
    //入队
    @Override
    public void enqueue(E e) {
        if (front == (tail + 1) % data.length) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }
    
    //出队
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The LoopQueue is empty");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        int capacity = getCapacity();
        if (size == capacity / 4 && capacity % 2 != 0) {
            resize(capacity / 2);
        }
        return e;
    }
    
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The LoopQueue is empty");
        }
        return data[front];
    }
    
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0 ; i < size ; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String res = String.format("LoopQueue: size = %d ; capacity = %d " , size , getCapacity());
        builder.append(res);
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
