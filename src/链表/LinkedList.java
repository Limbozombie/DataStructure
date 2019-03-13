package 链表;

public class LinkedList<E> {
    
    private int size;
    private Node dummyHead;
    
    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }
    
    private class Node {
        
        private E e;
        private Node next;
        
        public Node(E e , Node next) {
            this.e = e;
            this.next = next;
        }
        
        public Node(E e) {
            this(e , null);
        }
        
        public Node() {
            this(null , null);
        }
        
        @Override
        public String toString() {
            return e.toString();
        }
    }
    
    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }
    
    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    
    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index , E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        //找到指定索引的前一个Node
        Node former = dummyHead;
        for (int i = 0 ; i < index ; i++) {
            //初始位置是dummyHead,其索引可理解为-1 , 所以执行 index  次得到指定索引的前一个Node
            former = former.next;
        }
        //            Node node = new Node(e);
        //            node.next = former.next;
        //            former.next = node;
        former.next = new Node(e , former.next);
        size++;
    }
    
    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0 , e);
    }
    
    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size , e);
    }
    
    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node res = dummyHead.next;
        for (int i = 0 ; i < index ; i++) {
            res = res.next;
        }
        return res.e;
    }
    
    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }
    
    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }
    
    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index , E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node res = dummyHead.next;
        for (int i = 0 ; i < index ; i++) {
            res = res.next;
        }
        res.e = e;
    }
    
    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node res = dummyHead.next;
        //当Node指向null时则表明当前为最后一个Node
        while (res != null) {
            if (res.e.equals(e)) {
                return true;
            }
            res = res.next;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node node = dummyHead.next ; node != null ; node = node.next) {
            res.append(node).append("->");
        }
        return res.append("NULL").toString();
    }
}
