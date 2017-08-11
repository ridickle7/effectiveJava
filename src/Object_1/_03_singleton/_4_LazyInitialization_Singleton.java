package Object_1._03_singleton;

/**
 * Created by ridickle on 2017. 7. 21..
 */
public class _4_LazyInitialization_Singleton {
    private static _4_LazyInitialization_Singleton instance;
    private _4_LazyInitialization_Singleton () {}

    // getInstance 메소드를 호출 시 생성! (필요에 따라 생성 가능)
    public static _4_LazyInitialization_Singleton getInstance(){
        if(instance == null) {
            instance = new _4_LazyInitialization_Singleton();
            System.out.println("instance Created");
        }
        return instance;
    }
}
