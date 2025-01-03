package Q2.Prog1999s;

import java.util.ArrayList;

public class Recipe implements Comparable<Recipe> {
    private String recipeName;
    private IngredientBatch ings;

    public Recipe(String rName, IngredientBatch ingredients) {
        recipeName = rName;
        ings = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public IngredientBatch getIngredients() {
        return ings;
    }

    @Override
    public int compareTo(Recipe o) {
        return recipeName.compareTo(o.recipeName);
    }
}
