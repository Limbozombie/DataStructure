package 数组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 自定义数组
 */
public class Array<E> {
    
    private E[] data;
    private int size;
    
    /**
     * 构造函数，传入数组的容量capacity构造Array
     */
    public Array(int capacity) {
        
        data = (E[]) new Object[capacity];
        size = 0;
    }
    
    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        
        this(10);
    }
    
    /** 获取数组的容量 */
    public int getCapacity() {
        
        return data.length;
    }
    
    /** 获取数组中的元素个数 */
    public int getSize() {
        
        return size;
    }
    
    /** 返回数组是否为空 */
    public boolean isEmpty() {
        
        return size == 0;
    }
    
    /** 在所有元素前添加一个新元素 */
    public void addFirst(E e) {
        
        add(0 , e);
    }
    
    /** 向数组末尾添加元素 */
    public void addLast(E e) {
        
        add(size , e);
        
        //        //size可以当指针/游标 用,因为size与 [ 末尾的索引值 ] 相等
        //        data[size] = e;
        //        size++;
        
    }
    
    /** 向指定位置添加元素 */
    public void add(int index , E e) {
        
        //限制index值大小在  [0,size] 区间
        // 上限为size时为了确保元素紧密相连
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Require index >= 0 and index <= " + size + ".   you inputted: " + index);
        }
        
        //防止Array的容量溢出
        if (size == data.length) {
            //            throw new IllegalArgumentException("Array is full");
            //对数组进行扩容
            resize(2 * data.length);
        }
        
        //将index之后的元素全部向后移动一个位置
        for (int i = size ; i > index ; i--) {
            data[i] = data[i - 1];
        }
        //       将e元素插入到腾出来的index位置上
        data[index] = e;
        //插入一个元素后size增1
        size++;
        
    }
    
    /** 获取index索引位置的元素 */
    public E get(int index) {
        //就算大于size的索引上有值,也get不到
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }
    
    /** 修改index索引位置的元素为e */
    public void set(int index , E e) {
        
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }
    
    /** 查看数组中是否存在某个元素e */
    public boolean contains(E e) {
        
        for (E i : data) {
            if (e.equals(i)) {
                return true;
            }
        }
        return false;
    }
    
    /** 查看元素e在数组中的索引 ,不存在则返回 -1 */
    public int find(E e) {
        
        for (int i = 0 ; i < data.length ; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return - 1;
    }
    
    /** 根据索引进行删除,返回值时被删除的元素 */
    public E remove(int index) {
        
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        E removed = data[index];
        for (int i = index ; i <= size ; i++) {
            data[i] = data[i + 1];
        }
        size--;
        //  lazy 缩容   防止 复杂度震荡的影响
        if (size == (data.length / 4) && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return removed;
    }
    
    /** 从数组中删除第一个元素, 返回删除的元素 */
    public E removeFirst() {
        
        return remove(0);
    }
    
    /** 从数组中删除最后一个元素, 返回删除的元素 */
    public E removeLast() {
        
        return remove(size - 1);
    }
    
    /** 删除某个存在的元素 */
    public void removeElement(E e) {
        
        int index = find(e);
        if (index != - 1) {
            remove(index);
        }
    }
    
    @Override
    public String toString() {
        
        return "Array: size =" + size + " ;capacity = " + data.length + "\n" + Arrays.toString(data);
    }
    
    private void resize(int newCapacity) {
        
        E[] newData = (E[]) new Object[newCapacity];
        //      size肯定是小于等于data.length的
        //        i < size  比 i< data.length  更有快结束循环
        for (int i = 0 ; i < size ; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
