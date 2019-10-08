import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/*
 *Test1
 *
 *@author 87990
 *@email
 *@date 2019/10/2
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Random random=new Random();
        Thread thread = new Thread(() -> {
            try {
                int i = random.nextInt(200);
                Thread.sleep(i);
                System.out.println("test:"+i);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        });
      Thread thread1=  new Thread(()->{
          long start = System.currentTimeMillis();
            thread.start();
            while (System.currentTimeMillis()-start<100){

            }
          try {
              thread.getClass().getDeclaredMethod("interrupt").invoke(thread);
          } catch (NoSuchMethodException e) {
              e.printStackTrace();
          } catch (IllegalAccessException e) {
              e.printStackTrace();
          } catch (InvocationTargetException e) {
              e.printStackTrace();
          }
      });
        thread1.start();
        Thread.sleep(50000);

    }
}
