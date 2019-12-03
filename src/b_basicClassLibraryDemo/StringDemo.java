package b_basicClassLibraryDemo;

/**
 * String类常用类 </br>
 * 1.不可改变类，一旦创建不可改变</br>
 * 2.由于是不可变类，hashcode值一经创建便缓存起来,不需要重新创建,作为hashmap的键,处理速度很快</br>
 * 3.final的String类实现字符串池,不可变的字符串常量都可以指向同一个字符串，节省heap空间</br>
 * 4.不可变类的String实现了多线程安全,同一个字符串实例可以被多个线程共享</br>
 * 
 * @see String
 * @author huanghao
 *
 */
public class StringDemo {

    private final char value[];

    public StringDemo(char v[]) {
        this.value = v;
    }

    public void getSameObject() {
        value[0] = '2';
        String zeroString = "abc";
        System.out.println(zeroString.intern());
        String zero2String = "abc";
        String oneString = new String("abc");
        String twoString = new String("abc");
        String threeString = new String("abcd");
        System.out.println(oneString.equals(twoString));// true
        System.out.println(oneString == twoString);// false
        System.out.println(oneString == zeroString);// false
        System.out.println(zero2String == zeroString);// true
        oneString = threeString;
        System.out.println(oneString);
        System.out.println(zeroString.codePointAt(1));
    }

    public static void main(String[] args) {
        char v[] = { 'a' };
        StringDemo demo = new StringDemo(v);
        System.out.println(demo.value);
        demo.getSameObject();
        System.out.println(demo.value);
    }
}