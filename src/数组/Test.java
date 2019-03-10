package 数组;

import java.util.ArrayList;

/**
 * @author Limbo
 */
public class Test {
    
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(6);
        for (int i = 0 ; i < 9 ; i++) {
            array.addLast(i);
            System.out.println(array);
        }
        //        array.addFirst(1);
        //        array.remove(0);
        //        array.addLast(76);
        //        array.removeElement(7);
        //        array.add(1 , 100);
        //        array.removeFirst();
        //        array.removeLast();
        //        array.set(8 , 2);
        for (int i = 1 ; i < 9 ; i++) {
            array.removeFirst();
            System.out.println(array);
        }
    }
}
