package Object_1._04_private;

/**
 * Created by ridickle on 2017. 8. 11..
 */
public class private_1_4 {

    UtilityClass instance = UtilityClass(); // 에러 발생 (
}


class UtilityClass {
    // 디폴트 생성자가 만들어지는것을 방지
    private UtilityClass instance;
    private UtilityClass() {
        // 혹시나 불러질 가능성 대비해서 (클래스 내부에서) 에러 발생
        throw new AssertionError();
    }
}