package Q2.Prog1999s;

import java.util.ArrayList;

public class IngredientBatch implements Comparable<IngredientBatch> {
    private String temp;
    private ArrayList<IngredientItem> arrlist;

    private void calc() {
        String[] temp2 = temp.split(" ");
        for (int i = 0; i < temp2.length; i++) {
            String[] temp3 = temp2[i].split(":");
            arrlist.add(new IngredientItem(temp3[0], Integer.parseInt(temp3[1])));
        }
    }

    public IngredientBatch(String line) {
        temp = line;
        arrlist = new ArrayList<>();
        calc();
    }

    public ArrayList<IngredientItem> getIngredients() {
        return arrlist;
    }

    @Override
    public int compareTo(IngredientBatch o) {
        return 0;
    }
}
