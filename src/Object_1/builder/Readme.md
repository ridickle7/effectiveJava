## builder

생성자와 Static Factory Method 의 경우 매개변수 처리가 유연하지 않다.

1. 텔레스코핑 생성자(telescoping constructor) 패턴
- 해석하면 점층적 생성자 패턴
- 필수인자만 받는 생성자 하나를 정의하고, 선택적 인자를 점층적으로 추가하여 해당 파라미터 내용들에 대한 생성자를 호출하는 방식

<pre><code>// example
public class NutritionFacts {
    private final int servingSize;  // (용량 : ml)           필수 항목
    private final int servings;     // (개수)                필수 항목
    private final int calories;     // (칼로리)               선택 필드
    private final int fat;          // (지방 함량 : g)        선택 필드
    private final int sodium;       // (나트륨 함량 : mg)      선택 필드
    private final int carbohydrate; // (탄수화물 함량 : g)     선택 필드

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    // ....
    
    // 
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
</code></pre>
- 단점
1. 매개변수가 많으면 뭐가 어떤 값에 들어가는 지 알기 힘듦
2. 설정할 필요가 없는 필드에도 인자를 전달해야 한다. (예제에서는 0)


2. 자바빈즈(javabeans) 패턴
- 매개변수가 없는 생성자를 호출해서 객체를 생성하고 setter메소드를 호출해 각각의 값들을 모두 지정하는 방식

<pre><code>// example
public class NutritionFacts {
    private final int servingSize;  // (용량 : ml)           필수 항목
    private final int servings;     // (개수)                필수 항목
    private final int calories;     // (칼로리)               선택 필드
    private final int fat;          // (지방 함량 : g)        선택 필드
    private final int sodium;       // (나트륨 함량 : mg)      선택 필드
    private final int carbohydrate; // (탄수화물 함량 : g)     선택 필드

}
</code></pre>
- 단점
1. 매개변수가 많으면 뭐가 어떤 값에 들어가는 지 알기 힘듦
2. 설정할 필요가 없는 필드에도 인자를 전달해야 한다. (예제에서는 0)


3. 빌더(builder) 패턴
- 텔레스코핑 생성자 패턴의 **안전성** + 자바빈즈 패턴의 **가독성**을 결합한 패턴
- jquery의 메소드 체이닝 방법과 유사(?!)해 보인다.

<pre><code>
class NutritionFacts_Builder{
    private int servingSize;  // (용량 : ml)           필수 항목
    private int servings;     // (개수)                필수 항목
    private int calories;     // (칼로리)               선택 필드
    private int fat;          // (지방 함량 : g)        선택 필드
    private int sodium;       // (나트륨 함량 : mg)      선택 필드
    private int carbohydrate; // (탄수화물 함량 : g)     선택 필드

    public static class Builder {
        private final int servingSize;      // (용량 : ml)            필수 항목
        private final int servings;         // (개수)                 필수 항목
        private int calories = 0;           // (칼로리)                선택 필드
        private int fat = 0;                // (지방 함량 : g)         선택 필드
        private int sodium = 0;             // (나트륨 함량 : mg)       선택 필드
        private int carbohydrate = 0;       // (탄수화물 함량 : g)      선택 필드

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts_Builder build() {
            return new NutritionFacts_Builder(this);
        }
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    private NutritionFacts_Builder(Builder builder){
        servingSize     = builder.servingSize;
        servings        = builder.servings;
        calories        = builder.calories;
        fat             = builder.fat;
        sodium          = builder.sodium;
        carbohydrate    = builder.carbohydrate;
    }
}
</code></pre>

- 단점
1. 추가적으로 빌더를 생성해야 하므로 생성 비용이 드는 단점이 있다.
2. 해당 클래스에서 빌더를 무조건 생성해야 하며, 코드가 길어진다.

