package Object_1._02_builder;

/**
 * Created by ridickle on 2017. 7. 6..
 */
public class builder_1_2 {
    public static void main(String[] args){
        NutritionFacts_Telescoping telescoping = new NutritionFacts_Telescoping(1,2,3,4,5,6);

        // 2. javaBeans
        NutritionFacts_JavaBeans javaBeans = new NutritionFacts_JavaBeans();
        javaBeans.setServingSize(1);
        javaBeans.setServings(2);
        javaBeans.setCalories(3);
        javaBeans.setFat(4);
        javaBeans.setSodium(5);
        javaBeans.setCarbohydrate(6);

        // 3. Builder
        NutritionFacts_Builder temp = new NutritionFacts_Builder
                .Builder(30,40)
                .calories(3)
                .fat(4)
                .sodium(5)
                .carbohydrate(6).build();
    }
}



