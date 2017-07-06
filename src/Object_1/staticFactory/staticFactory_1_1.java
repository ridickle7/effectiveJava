package Object_1.staticFactory;

/**
 * Created by ridickle on 2017. 7. 5..
 */
public class staticFactory_1_1 {
    // 장점 4를 활용한 string 별 객체 생성
    Blog a = getInstance("A");
    public static Blog getInstance(String type){
        if(type.equals("A")){
            return new A();
        }
        else if(type.equals("B")){
            return new B();
        }
        return null;
    }
}


class Blog{

}

class A extends Blog{

}

class B extends Blog{

}