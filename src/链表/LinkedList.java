package 链表;

public class LinkedList {
    
    private class Node<E> {
        
        public E e;
        public Node next;
        
        public Node(E e , Node next) {
            this.e = e;
            this.next = next;
        }
        
        /** 最后一个节点 */
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
}
