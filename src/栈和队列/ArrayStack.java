package 栈和队列;

import 数组.Array;

/**
 * @author Limbo
 */
public class ArrayStack<E> implements Stack<E> {
    
    private Array<E> array;
    
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    
    public ArrayStack() {
        array = new Array<>();
    }
    
    @Override
    public int getSize() {
        return array.getSize();
    }
    
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    
    public int getCapacity() {
        return array.getCapacity();
    }
    
    /** 添加 */
    @Override
    public void push(E e) {
        array.addLast(e);
    }
    
    /** 删除 */
    @Override
    public E pop() {
        return array.removeLast();
    }
    
    /** 获得栈顶 */
    @Override
    public E peek() {
        return array.getLast();
    }
    
    @Override
    public String toString() {
        int size = array.getSize();
        StringBuilder result = new StringBuilder();
        result.append("Stack:  [ ");
        for (int i = 0 ; i < size ; i++) {
            result.append(array.get(i));
            if (i != size - 1) {
                result.append(",");
            }
        }
        result.append(" ]  top");
        return result.toString();
    }
}
