package Object_1.builder;

/**
 * Created by ridickle on 2017. 7. 14..
 */
public class NutritionFacts_JavaBeans{
    private int servingSize;  // (용량 : ml)           필수 항목
    private int servings;     // (개수)                필수 항목
    private int calories;     // (칼로리)               선택 필드
    private int fat;          // (지방 함량 : g)        선택 필드
    private int sodium;       // (나트륨 함량 : mg)      선택 필드
    private int carbohydrate; // (탄수화물 함량 : g)     선택 필드

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}

