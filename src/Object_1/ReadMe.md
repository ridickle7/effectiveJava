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

Static Factory Method을 활용하면 다음과 같은 장점이 있다.</br></br>
# 1. 기본 생성자와는 다르게 이름을 만들어 줄 수 있다.</br>
기존 new '클래스 이름'() 이 아닌 static method 이름으로 인스턴스를 생성할 수 있다.</br>(이는 **가독성 측면**에서 큰 메리트이다.)

# 2. 중복 Signature Constructor의 형태가 가능하다.</br>
참고 : (함수의 Signature) = (함수 이름) + (입력 매개변수들) + (출력 매개변수)</br>
기존의 방식이라면 해당 함수는 공존할 수 없습니다.
<pre><code>// 1. return type이 다른 경우
int getResult();
String getResult();

// 2. 매개변수 타입이 같은 Constructor은 공존할 수 없음
Blog Blog( String bloggerID );
Blog Blog( String blogName ); 
</code></pre></br>

그러나 Static Factory Method를 활용한다면 가능합니다.


<pre><code>// 1. return type이 같은 메소드 공존 가능
public static int getIntResult();
public static String getStringResult();

// 2. 매개변수 타입이 같은 Constructor 공존 가능
public static Blog newInstance();
public static Blog newPowerBlogInstanceWithBloggerID( String powerBloggerID );
public static Blog newInstanceWithBlogName( String blogName )
</code></pre></br>

# 3. 생성자와 달리 호출될 때마다 새로운 객체를 생성하지 않아도 됨</br>
생성자를 통해 새로운 객체를 생성할 필요 없이, </br>기존에 만들어져 있는 객체를 반환하는 방식(Singleton) 등을 통해 불필요한 객체 생성을 피할 수 있다.

> 객체를 계속 생성하면? </br>
보통 new 를 통하여 새로운 객체가 생성되면서, **heap 메모리** 를 사용하게 된다. (기승전Memory Leak..)

# 4. 반환하는 타입의 SubType(자식Type)도 반환할 수 있다.
기본 JAVA의 상속과 다형성을 이해하고 있다면 이 장점은 예상보다 쉽게 이해 될 것이다.

<pre><code>// 이런 활용이 가능하다.
public static Blog newInstance( String type ){
  if ( type.equals("Image")
    return new ImageBlog();
  else if ( type.equals("video")
    return new VideoBlog();
  
  return null;
}
</code></pre>

장점과 활용 예제들을 보면서 Static Factory Method의 단점과 주의사항을 캐치한 사람들이 있을 것이다.

단도직입적으로 이야기하면 **naming** 에 신중을 가해야 한다.</br>
naming을 제대로 하지 않는다면 위에서 말한 **가독성**은 물론 **효율적인 코드 작성**도 매우 힘들어질 것이다.




## 기타
Static Factory Convention (Static Factory Method 규약)

규약을 정함으로써 Static Factory Method 활용을 조금 더 쉽게 할 수 있다.

<pre><code>example

1. valueOf      : 파라메터와 같은 값을 리턴
2. of           : valueOf를 줄인 형태의 이름이며, EnumSet에서 사용
3. getInstance  : 매개변수에 나타난 인스턴스를 값을 얻어낸다. 매개변수와 같은 값을 가지지 않을 수도 있다. 
                  싱글톤(singleton)의 경우 getInstance는 매개변수가 없고 오직 하나의 인스턴스만 반환
4. newInstance  : getInstance와 유사하나 반환되는 각 인스턴스가 서로 다르다.
5. getType      : getInstance와 유사하나 팩토리 메소드가 다른 클래스에 있을 때 사용한다. 
                  여기서 Type은 팩토리 메소드에서 반환되는 객체의 타입을 나타낸다.
6. newType      : newInstance와 유사하나 팩토리 메소드가 다른 클래스에 있을 때 사용한다. 
                  여기서 Type은 팩토리 메소드에서 반환되는 객체의 타입을 나타낸다.
</code></pre>
