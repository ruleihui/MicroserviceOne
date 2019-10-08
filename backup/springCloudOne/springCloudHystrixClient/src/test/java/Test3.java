/*
 *Test3
 *
 *@author 87990
 *@email
 *@date 2019/10/5
 */
public class Test3<T> {
    public void write(T o){
        System.out.println(o);
    }

    public static void main(String[] args) {
        new Test3<Integer>().write(3);
        new Test3<String>().write("3");
        new Test3<Test>().write(new Test());
    }
}
