package Q1;
import Algorithms.SearchAlgorithms;

public class Pelican_50_4 {
    public static void main(String[] args) {
        int[] i = {-7, 15, 21, 22, 43, 49, 51, 67, 78, 81, 84, 89, 95, 97};
        Integer[] iw = new Integer[14];
        for (int k = 0; k < 14; k++) iw[k] = i[k];
        System.out.println(SearchAlgorithms.binarySearch(iw, 22));
        System.out.println(SearchAlgorithms.binarySearch(iw, 89));
        System.out.println(SearchAlgorithms.binarySearch(iw, -100));
        System.out.println(SearchAlgorithms.binarySearch(iw, 72));
        System.out.println(SearchAlgorithms.binarySearch(iw, 102));
    }
}
/*
3
11
-1
-1
-1
 */