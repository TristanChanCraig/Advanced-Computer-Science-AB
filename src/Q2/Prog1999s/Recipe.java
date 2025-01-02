package Q2.Prog1999s;

public class Recipe implements Comparable<Recipe> {
    private String recipeName;
    private String ingredient1Name;
    private String ingredient2Name;
    private String ingredient3Name;
    private int ingredient1Qty;
    private int ingredient2Qty;
    private int ingredient3Qty;

    public Recipe(String rName, String i1Name, String i2Name, String i3Name, int i1Qty, int i2Qty, int i3Qty) {
        recipeName = rName;
        ingredient1Name = i1Name;
        ingredient2Name = i2Name;
        ingredient3Name = i3Name;
        ingredient1Qty = i1Qty;
        ingredient2Qty = i2Qty;
        ingredient3Qty = i3Qty;
    }

    @Override
    public int compareTo(Recipe o) {
        return recipeName.compareTo(o.recipeName);
    }
}
