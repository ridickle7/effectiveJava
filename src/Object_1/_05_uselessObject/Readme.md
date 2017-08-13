## ITEM5 : 필요없는 오브젝트가 생성되는것을 피해라


### 1. 객체를 재사용할 경우, 객체(인스턴스) 생성에 소요되는 시간과 리소스(메모리)를 아낄 수 있다.

- new를 통한 인스턴스 생성에 대한 고찰
<pre><code>String s1 = new String("Hello World!");  // 매번 새로운 객체를 생성한다.
String s2 = "Hello world";               // 하나의 String 인스턴스에서 동일한 리터럴을 가짐
</code></pre>

> ##### 리터럴 (literal)
> 코드 내에 지정한 상수 값 <br>
> 자바의 경우, 리터럴 값을 **리터럴 풀(pool)** 메모리 영역에 보관 <br>
> 같은 값을 갖는 리터럴이 코드에 여러 번 나오더라도 **하나만 만들어 공유** <br>
> <pre><code>// s1과 s2는 같은 객체를 참조함 (객체 Aliasing)
> String s1 = "Java";
> String s2 = "Java";
> </code></pre>
>
> <pre><code>// bool1과 bool2는 같은 객체를 참조함 (객체 Aliasing)
> Boolean bool1 = new Boolean("true");        // 새로운 인스턴스를 생성
> Boolean bool2 = Boolean.valueOf("true");    // 새로운 인스턴스를 생성하지 않음
> </code></pre>

- new 연산자를 사용하기 전 고심하고 사용해보자 :)

<br>

### 2.primitive 자료형과 Wrapper class 자료형 간 변환을 최대한 줄이도록 하자!

#### Round 1. 먼저 Java의 자료형에 대해 알아야 한다! <br>
> 1. primitive 형 (기본형 타입) <br>
> 클래스를 통한 인스턴스 생성을 거쳐 선언하지 않는 자료형 <br>
> 해당 데이터는 Stack 영역에 저장됨 <br>
> ex) byte, short, int, long, float, double, char, boolean, void
> 
> 2. Wrapper class 형 (특정 기본형 타입) <br>
> 클래스를 통한 인스턴스 생성을 거치는 **특정 primitive** 자료형 <br>
> 해당 데이터는 Heap 영역에 저장됨 <br>
> 인스턴스에 저장된 값은 변경이 불가능하며, 값을 저장하는 새로운 객체의 생성 및 참조만 가능하다.<br>
> ex) Byte, Short, Integer, Long, Float, Double, Character, Boolean, Void
> 
> 3. primitive 형 / Wrapper class 형 list <br>
> ![Image](https://github.com/ridickle7/effectiveJava/blob/master/src/Object_1/_05_uselessObject/primitive%2C%20wrapper%20class.png)

#### Round 2. Boxing의 개념 <br>

서론
1. primitive 형 / Wrapper class 형 사이의 처리 때문에 필요해짐 (처리 영역이 다름!)
2. 기본형(primitive type) 변수도 때로는 객체로 다루어져야 하는 경우가 있다.
> 1. 매개변수로 객체가 요구 될때.	  ex) Vector / ArrayList 매개변수
> 2. 기본형 값이 아닌 객체로 저장해야 할 때.
> 3. 객체간의 비교가 필요할 때

- 개념은 다음과 같다.
1. Boxing : 기본 자료형을 Wrapper 클래스의 객체로 변경하는 과정 <br>
ex) Integer age = new Integer(30); <br>
2. Unboxing : 각각의 객체를 기본 자료형으로 변경하여 사용하는 과정 <br>
ex) int age2 = age.intValue(); <br>

![Image](https://github.com/ridickle7/effectiveJava/blob/master/src/Object_1/_05_uselessObject/boxing%2C%20unboxing.jpg)

#### Round 3. AutoBoxing과 AutoUnBoxing <br>
- JDK 1.5 version 이후로 자동으로 Boxing과 unBoxing이 처리되도록 기능 제공
- Wrapper class를 통한 인스턴스 생성 필요없이 primitive 데이터를 넣어도 자동으로(auto) Boxing 처리를 해준다.

> 1. AutoBoxing <br>
> ex> Integer age = 30; <br>
> 
> 2. AutoUnboxing : 각각의 객체를 기본 자료형으로 변경하여 사용하는 과정 <br>
> ex> int age2 = age; <br>

#### Round 4. 기타
1. Integer.parseInt("100") / Integer.valueOf("100") 의 차이 <br>
> Integer.parseInt("100")<br>
> "100"이라는 문자열에서 primitive 데이터를 얻어낸다.<br>
>  get **primitive data**

> Integer.valueOf("100")<br>
> "100"이라는 문자열에서 Wrapper class 데이터를 얻어낸다.<br>
>  get **Wrapper class data**

다른 자료형들의 parse와 valueOf 정리 List <br>
![Image](https://github.com/ridickle7/effectiveJava/blob/master/src/Object_1/_05_uselessObject/parse%2C%20valueOf.png)

#### 참고 Reference
1. http://blog.hazard.kr/archives/408
2. http://jusungpark.tistory.com/17
