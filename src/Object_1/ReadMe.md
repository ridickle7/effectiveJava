## Static Factory Method

일반적인 객체 생성 방식은 이렇다.
<pre><code>Object object = new Object();
</code></pre>

하지만 여기에 public static method 의 특징을 두어 외부 클래스에 바로 접근할 수 있도록 할 수 있다.
<pre><code>Object object = newObjectInstance();

....

public static Blog newBlogInstance(){
  return new Object();
}
</code></pre>



Static Factory Convention

아래 함수들은 Static Fatory로 사용된다고 규약을 정한다.

작명 규칙의 예
<pre><code>1. valueOf      : 파라메터와 같은 값을 리턴
2. of           : valueOf를 줄인 형태의 이름이며, EnumSet에서 사용
3. getInstance  : 매개변수에 나타난 인스턴스를 값을 얻어낸다. 매개변수와 같은 값을 가지지 않을 수도 있다. 
                  싱글톤(singleton)의 경우 getInstance는 매개변수가 없고 오직 하나의 인스턴스만 반환
4. newInstance  : getInstance와 유사하나 반환되는 각 인스턴스가 서로 다르다.
5. getType      : getInstance와 유사하나 팩토리 메소드가 다른 클래스에 있을 때 사용한다. 
                  여기서 Type은 팩토리 메소드에서 반환되는 객체의 타입을 나타낸다.
6. newType      : newInstance와 유사하나 팩토리 메소드가 다른 클래스에 있을 때 사용한다. 
                  여기서 Type은 팩토리 메소드에서 반환되는 객체의 타입을 나타낸다.
</code></pre>
