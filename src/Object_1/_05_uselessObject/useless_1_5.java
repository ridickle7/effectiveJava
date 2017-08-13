package Object_1._05_uselessObject;

import java.util.ArrayList;

/**
 * Created by ridickle on 2017. 8. 11..
 */
public class useless_1_5 {

    String s1 = new String("abc");               // 매번 새로운 객체 생성
    String s2 = "abc";                           // "abc" 리터럴 풀에서 공수

    Boolean bool1 = new Boolean("true");        // 새로운 인스턴스를 생성
    Boolean bool2 = Boolean.valueOf("true");    // 새로운 인스턴스를 생성하지 않음

    public static void main(String[] args){

        Object o = 123;

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(new Integer(300));


        System.out.println(o);
    }
}
