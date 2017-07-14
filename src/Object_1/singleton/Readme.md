## Singleton

싱글톤(singleton)이란?
- 하나의 인스턴스만 생성되는 클래스 / 유일한 시스템 컴포넌트를 나타냄!

### 1. 가장 기본적인 싱글턴 패턴
- 일반적이고 최소의 기능만 있는 싱글턴 패턴

<pre><code>public class EagerInitialization {
	private static EagerInitialization instance = new EagerInitialization();  // private static 로 선언.
	
  // 생성자
	private EagerInitialization () {  
		System.out.println( "call EagerInitialization constructor." );
	}

  // 조회 method
	public static EagerInitialization getInstance () {	
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in EagerInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
</code></pre>
코드리뷰
- 클래스 생성되는 시점에서 인스턴스가 초기화 됨.

해당 방식의 문제점
1. 클래스가 load 되는 시점에 인스턴스를 생성시키는데 이마저도 부담스러울 수가 있다. (2 line)
2. 클래스가 인스턴스화 되는 시점에 어떠한 에러처리도 할 수가 없다.


### 2. static 초기화블럭을 이용하는 싱글턴 패턴
- 클래스가 로딩 될 때 최초 한번 실행하게 된다
- 초기화블럭을 이용하면 logic을 담을 수 있다. (복잡한 초기변수 셋팅이나 에러처리를 위한 구문을 담을 수 있다.)

<pre><code>public class StaticBlockInitalization {
	private static StaticBlockInitalization instance;
	private StaticBlockInitalization () {}
	
	static {  // static 초기화블럭
		try {
			System.out.println("instance create..");
			instance = new StaticBlockInitalization();
		} catch (Exception e) {
			throw new RuntimeException("Exception creating StaticBlockInitalization instance.");
		}
	}
	
	public static StaticBlockInitalization getInstance () {
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in StaticBlockInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}	
}
</code></pre>
코드리뷰
- static 블럭은 최초 한 번 실행되며, static 블럭 내에서 인스턴스 생성 및 초기화(new ___()), 에러 처리(RuntimeException) 진행

해당 방식의 문제점
1. 인스턴스가 사용되는 시점에 생성되는 것은 아니다.
   (아직 1-1 "클래스가 load 되는 시점에 인스턴스를 생성시키는데 이마저도 부담스러울 수가 있다." 해결 못함) 


### 3. 클래스 인스턴스가 사용되는 시점에 인스턴스를 만드는 싱글턴 패턴
- 클래스 인스턴스가 사용되는 시점에 인스턴스를 만듬
- 필요할때 인스턴스를 생성시키는 것이 핵심

<pre><code>public class LazyInitialization {
	
	private static LazyInitialization instance;
	private LazyInitialization () {}
	
	public static LazyInitialization getInstance () {
		if ( instance == null )
			instance = new LazyInitialization();
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in LazyInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
</code></pre>
코드리뷰
- 인스터스 생성 및 초기화(new ___())가 인스턴스 사용 혹은 불러올 시(getInstance() 메소드) 진행
- if문을 이용해 instance가 null 인 경우에만 new를 사용해 객체를 생성 (최초 사용시점에만 인스턴스화)

해당 방식의 문제점
1. 프로그램이 muilti thread 방식이라면 안전하지 않다.
   ex> 동일 시점에 각 쓰레드에서 getInstance() method를 호출하면 인스턴스가 두번 생길 위험이 있다.

### 4. Thread safe 싱글턴 패턴
- Multi Thread 문제를 해결하기 위해 synchronized(동기화)를 사용
- 여러 thread들이 동시에 접근해서 인스턴스를 생성시키는 위험은 없어짐

<pre><code>public class ThreadSafeInitalization {
	
	private static ThreadSafeInitalization instance;
	private ThreadSafeInitalization () {}
	
	public static synchronized ThreadSafeInitalization getInstance () {
		if (instance == null)
			instance = new ThreadSafeInitalization();
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in ThreadSafeInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}	
}
</code></pre>

코드리뷰
- synchronized 만 추가됨.

해당 방식의 문제점
1. 수 많은 Thread 들이 getInstance() method 를 호출하면, 높은 cost 비용으로 인해 프로그램 전반에 성능저하 발생


### 5.  jvm 의 class loader의 매커니즘과 class의 load 시점을 이용한 싱글턴 패턴
- JVM의 class loader의 매커니즘, Class의 load 시점을 이용하여 내부 class를 생성
- 모든 java 버젼과, jvm에서 사용이 가능하며, Thread 간 동기화 문제 해결함

<pre><code>public class InitializationOnDemandHolderIdiom {
	
	private InitializationOnDemandHolderIdiom () {}
	private static class Singleton {
		private static final InitializationOnDemandHolderIdiom instance = new InitializationOnDemandHolderIdiom();
	}
	
	public static InitializationOnDemandHolderIdiom getInstance () {
		System.out.println("create instance");
		return Singleton.instance;
	}
}
</code></pre>

코드리뷰
- private static Singleton 클래스를 통해 객체 생성
- getInstance() 내에서는 Singleton 클래스 내 instance 값을 추출해 냄

 ※ 현재 java 에서 singleton 을 생성시킨다고 하면 거의 위의 방법을 사용한다고 보면 된다.
 
 

### 6.  jvm 의 class loader의 매커니즘과 class의 load 시점을 이용한 싱글턴 패턴
- JVM의 class loader의 매커니즘, Class의 load 시점을 이용하여 내부 class를 생성
- 모든 java 버젼과, jvm에서 사용이 가능하며, Thread 간 동기화 문제 해결함

