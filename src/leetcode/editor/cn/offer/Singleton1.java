package leetcode.editor.cn.offer;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-08-13 8:34
 * @ClassName Singleton
 * @Description:  2、实现singleton模式
 */
//1、常规
public class Singleton1 {

    private static Singleton1 singleton;
    private Singleton1(){
    }
    public static Singleton1 getInstance(){
        if (singleton == null)
            singleton = new Singleton1();
        return singleton;
    }

}
//2、加锁，通过两次判断singleton是否为空，实现加锁操作只执行一次，提高效率
class Singleton2 {
    private static Singleton2 singleton;
    private Singleton2(){
    }
    public static Singleton2 getInstance(){
        if(singleton == null){
            synchronized (Singleton2.class){
                if(singleton == null)
                    singleton = new Singleton2();
            }
        }
        return singleton;
    }
}
//3、饿汉式
class Singleton3 {
    private static Singleton3 singleton = new Singleton3();
    private Singleton3(){
    }
    public static Singleton3 getInstance(){
        return singleton;
    }
}
//4、静态内部类，实现只有调用getInstance()方法时才从而实例化singleton
class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    private Singleton4(){
    }
    public static final Singleton4 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}