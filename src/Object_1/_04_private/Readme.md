## ITEM4 : PRIVATE 생성자로 인스턴스를 생성할수 없게하라.


서론

- 산술연산이나 배열작업의 경우 static method나 field로 주로 호출하며 해당 작업을 관리하는 클래스가 존재한다.
- 그러나 인스턴스는 생성하지 못하게 설계되어있다. <br>
(자주 사용 및 호출하기 때문에 static으로 만들었는데, 인스턴스를 생성하는 것은 무의미함을 넘어서 낭비이다.)
- 그러나 Java Compiler는 생성자가 없는 클래스라도 default 생성자를 만든다.
- javadoc API 문서에 해당 내용이 있음으로써 사용할 수 있는 클래스로 개발자는 오인할 수 있다.


이를 위해 private 생성자를 선언하여 인스턴스 생성 가능성을 원천 봉쇄한다.


private로 만들면
1. 인스턴스 자체가 생기지도 않는다.
2. javadoc API 문서에도 보이지 않는다.
3. 우연히 호출하더라도 AssertionError 처리로 치명적인 오류를 원천 차단한다.
4. 하위클래스에 영향을 끼치기 때문에 유의하여 사용할 것

코드 example
<pre><code>public class UtilityClass {
    // 디폴트 생성자가 만들어지는것을 방지
    private UtilityClass() {
      // 혹시나 불러질 가능성 대비해서 (클래스 내부에서) 에러 발생
      throw new AssertionError();
    }
  }</code></pre>


