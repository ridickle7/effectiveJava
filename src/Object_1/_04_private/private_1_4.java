package Object_1._04_private;

/**
 * Created by ridickle on 2017. 8. 11..
 */
public class private_1_4 {

//    UtilityClass instance = UtilityClass(); // 생성이 안됨 (오류코드)
}


class UtilityClass {
    // private 선언을 통해 생성자가 만들어지는것을 방지
    private UtilityClass() {
        // 혹시나 불러질 가능성 대비해서 (클래스 내부에서) 에러 발생
        throw new AssertionError();
    }
}

//class UtilSubClass extends UtilityClass{
//
//    // 부모 클래스 생성자가 private라 자식 클래스도 그 영향을 받는다.
////    private UtilSubClass() {}    // (오류코드)
//}