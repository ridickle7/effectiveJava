package Object_1._03_singleton;

/**
 * Created by ridickle on 2017. 7. 17..
 */
public enum Elvis{
    INSTANCE;

    public void test() {
        System.out.println("singleton by enum");
    }
}
