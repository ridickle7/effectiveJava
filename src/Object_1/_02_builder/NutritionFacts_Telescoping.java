package Object_1._02_builder;

/**
 * Created by ridickle on 2017. 7. 14..
 */
public class NutritionFacts_Telescoping{
    private final int servingSize;  // (용량 : ml)           필수 항목
    private final int servings;     // (개수)                필수 항목
    private final int calories;     // (칼로리)               선택 필드
    private final int fat;          // (지방 함량 : g)        선택 필드
    private final int sodium;       // (나트륨 함량 : mg)      선택 필드
    private final int carbohydrate; // (탄수화물 함량 : g)     선택 필드

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    // ....

    //
    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}

