package Q2.Prog1999s;

public class IngredientItem implements Comparable<IngredientItem>{
    private String name;
    private int cnt;

    public IngredientItem(String n, int c) {
        name = n;
        cnt = c;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    @Override
    public int compareTo(IngredientItem o) {
        return name.compareTo(o.name);
    }
}
