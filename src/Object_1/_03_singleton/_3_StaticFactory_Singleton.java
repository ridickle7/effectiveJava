package Object_1._03_singleton;

/**
 * Created by ridickle on 2017. 7. 21..
 */
public class _3_StaticFactory_Singleton {
    private static final _3_StaticFactory_Singleton instance = new _3_StaticFactory_Singleton();

    private _3_StaticFactory_Singleton(){
        System.out.println("instance created");
    }

    public static _3_StaticFactory_Singleton getInstance(){
        return instance;
    }
}
