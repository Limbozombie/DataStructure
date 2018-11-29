package 数组;

/**
 * @author Limbo
 */
public class Test {
    
    public static void main(String[] args) {
        
        Array<Object> array = new Array<>();
        for (int i = 0 ; i < 10 ; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.addLast(10);
        array.addLast(new Student("a" , 23));
        System.out.println(array);
        array.remove(0);
        array.remove(0);
        System.out.println(array);
        for (int i = 0 ; i < 10 ; i++) {
            array.addLast(i);
        }
        System.out.println(array);
    }
}
