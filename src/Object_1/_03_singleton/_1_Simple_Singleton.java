package Object_1._03_singleton;

/**
 * Created by ridickle on 2017. 7. 21..
 */
public class _1_Simple_Singleton {
    // 클래스 생성되는(로드 되는) 시점에서 인스턴스가 초기화
    private static final _1_Simple_Singleton instance = new _1_Simple_Singleton();

    private _1_Simple_Singleton(){
        System.out.println("instance created");
    }
}
