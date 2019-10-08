/*
 *Test
 *
 *@author 87990
 *@email
 *@date 2019/10/2
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
             new Thread(Test::get).start();
        }
    }
    public static void get(){
        System.out.println(Singleton.SINGLETON.get());
    }
    enum Singleton{

        SINGLETON{
            public  Test test=new Test();
            public Test get(){
                return test;
            }
        };
        public Test get(){
            return null;
        }
    }
}
