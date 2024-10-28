package Q1.Prog285b;

public class Cl285b implements Comparable<Cl285b> {
    private int id;
    private int code;
    private double sales;
    private double comm;

    private void calc() {
        if (code == 5 || code == 8) {
            if (sales <= 5000)
                comm = sales * 0.075;
            else
                comm = 5000 * 0.075 + (sales - 5000) * 0.085;
        } else if (code == 17) {
            if (sales <= 3500)
                comm = sales * 0.095;
            else
                comm = 3500 * 0.095 + (sales - 3500) * 0.12;
        }
    }

    public Cl285b(int id, int code, double sales) {
        this.id = id;
        this.code = code;
        this.sales = sales;
        this.comm = 0;
        calc();
    }

    public String toString() {
        return String.format("%d\t\t%d\t\t$%.2f\t\t$%.2f", id, code, sales, comm);
    }

    public int compareTo(Cl285b o) {
        return id - o.id;
    }
}
/*
Number	Code	Sales	Commission
291		17		$750.00	$71.25
264		17		$4150.00	$410.50
235		5		$5250.00	$396.25
218		5		$5000.00	$375.00
203		8		$3250.00	$243.75
192		8		$8125.00	$640.63
138		17		$6375.00	$677.50
125		5		$6500.00	$502.50
118		8		$7350.00	$574.75
117		3		$7350.00	$0.00
103		5		$4000.00	$300.00
101		17		$2250.00	$213.75

Process finished with exit code 0

 */