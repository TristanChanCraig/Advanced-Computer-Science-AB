package Algorithms;

@SuppressWarnings({"unchecked", "unused", "ManualArrayCopy"})

public class SortingAlgorithms {
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean bool;
        do {
            bool = false;
            for (int lcv = 0; lcv < arr.length - 1; lcv++) {
                if (arr[lcv].compareTo(arr[lcv + 1]) > 0) {
                    swap(arr, lcv, lcv + 1);
                    bool = true;
                }
            }
        } while (bool);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        T insert;
        int cnt;
        boolean bool;
        for (int lcv = 1; lcv < arr.length - 1; lcv++) {
            insert = arr[lcv];
            cnt = lcv - 1;
            bool = true;
            while ((cnt >= 0) && bool) {
                if (insert.compareTo(arr[cnt]) < 0) {
                    arr[cnt + 1]= arr[cnt];
                    cnt--;
                    if (cnt == -1) arr[0] = insert;
                } else {
                    bool = false;
                    arr[cnt + 1] = insert;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        T min;
        int minIndex;
        for (int lcv = 0; lcv < arr.length-1; lcv++) {
            min = arr[lcv];
            minIndex = lcv;
            for (int lcv2 = lcv + 1; lcv2 < arr.length-1; ++lcv2) {
                if (arr[lcv].compareTo(min) > 0) {
                    min = arr[lcv2];
                    minIndex = lcv2;
                }
            }
            swap(arr, lcv, minIndex);
        }
    }
}
