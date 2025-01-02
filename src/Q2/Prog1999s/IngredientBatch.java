package Q2.Prog1999s;

public class IngredientBatch {
    private String temp;
    private String ingredient1Name;
    private String ingredient2Name;
    private String ingredient3Name;
    private int ingredient1Qty;
    private int ingredient2Qty;
    private int ingredient3Qty;

    private void calc() {
        String[] temp2 = temp.split(" ");
        String[] i1 = temp2[1].split(":");
        String[] i2 = temp2[2].split(":");
        String[] i3 = temp2[3].split(":");
    }

    public IngredientBatch(String line) {
        temp = line;
        calc();
    }
}
