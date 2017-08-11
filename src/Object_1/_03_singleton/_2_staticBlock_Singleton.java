package Object_1._03_singleton;

/**
 * Created by ridickle on 2017. 7. 21..
 */
public class _2_staticBlock_Singleton {
    private static _2_staticBlock_Singleton instance;

    private _2_staticBlock_Singleton() {}

    //최초 한 번만 실행되는 static block
    static {
        try {
            // 인스턴스 생성
            instance = new _2_staticBlock_Singleton();
            System.out.println("instance created");
        } catch (Exception e) { // 에러 처리
            throw new RuntimeException("Exception creating StaticBlockInitalization instance.");
        }
    }

    public static _2_staticBlock_Singleton getInstance(){
        return instance;
    }
}
