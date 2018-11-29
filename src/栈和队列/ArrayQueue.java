package 栈和队列;

import 数组.Array;

public class ArrayQueue<E> implements Queue<E> {
    
    private Array<E> array;
    
    public ArrayQueue() {
        
        array = new Array<>();
    }
    
    public ArrayQueue(int capacity) {
        
        array = new Array<>(capacity);
    }
    
    public int getCapacity() {
        
        return array.getCapacity();
    }
    
    @Override
    public int getSize() {
        
        return array.getSize();
    }
    
    @Override
    public boolean isEmpty() {
        
        return array.isEmpty();
    }
    
    @Override
    public void enqueue(E e) {
        
        array.addLast(e);
    }
    
    @Override
    public E dequeue() {
        
        return array.removeFirst();
    }
    
    @Override
    public E getFront() {
        
        return array.getFirst();
    }
    
    @Override
    public String toString() {
        
        
        return "front " + array + "tail";
    }
}
