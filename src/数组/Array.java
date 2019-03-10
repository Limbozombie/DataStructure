package 数组;

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
    }
    
    /** 向指定位置添加元素 */
    public void add(int index , E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Operation Failed : Index: " + index + " , Size: " + size);
        }
        //如果data数组满了就进行扩容
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size ; i > index ; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }
    
    /** 根据索引进行删除,返回值时被删除的元素 */
    public E remove(int index) {
        checkIndexRange(index);
        E e = get(index);
        for (int j = index ; j < size - 1 ; j++) {
            data[j] = data[j + 1];
        }
        size--;
        //        data.length / 4  惰性缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            //data.length如果为1,   data.length / 2 结果为0     新数组的长度不能为0
            resize(data.length / 2);
        }
        return e;
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
    public void removeElement(int e) {
        int index = find(e);
        if (index != - 1) {
            remove(index);
        }
    }
    
    /** 修改index索引位置的元素为e */
    public void set(int index , E e) {
        checkIndexRange(index);
        data[index] = e;
    }
    
    /** 获取index索引位置的元素 */
    public E get(int index) {
        checkIndexRange(index);
        return data[index];
    }
    
    /** 获得最后一个 */
    public E getLast() {
        return get(size - 1);
    }
    
    /** 获得第一个 */
    public E getFirst() {
        return get(0);
    }
    
    /** 查看数组中是否存在某个元素e */
    public boolean contains(E e) {
        for (E o : data) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    /** 查看元素e在数组中的索引 ,不存在则返回 -1 */
    public int find(int e) {
        for (int i = 0 ; i < size ; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return - 1;
    }
    
    /**
     * 检查索引范围合法性
     *
     * @param index 索引
     */
    private void checkIndexRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Operation Failed : Index: " + index + " , Size: " + size);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d , capacity = %d\n" , size , data.length));
        result.append(" [ ");
        for (int i = 0 ; i < size ; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(",");
            }
        }
        result.append(" ] ");
        return result.toString();
    }
    
    /**
     * 调整data容量
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];
        System.arraycopy(data , 0 , temp , 0 , size);
        data = temp;
    }
}
