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

1. valueOf : 파라메터와 같은 값을 리턴
2. of
3. getInstance
4. newInstance
5. getType
6. newType
