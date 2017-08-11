package Object_1._02_builder;

/**
 * Created by ridickle on 2017. 7. 14..
 */
public class NutritionFacts_Builder{
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
