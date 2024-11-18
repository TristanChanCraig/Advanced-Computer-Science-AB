package Algorithms;

@SuppressWarnings({"unchecked", "unused", "ManualArrayCopy"})

public class SortingAlgorithms {
//    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
//        boolean bool;
//        do {
//            bool = false;
//            for (int lcv = 0; lcv < arr.length - 1; lcv++) {
//                if (arr[lcv].compareTo(arr[lcv + 1]) > 0) {
//                    swap(arr, lcv, lcv + 1);
//                    bool = true;
//                }
//            }
//        } while (bool);
//    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j].compareTo(arr[j+1]) > 0)
                    swap(arr, j, j+1);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        insertionSort(arr, arr.length);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr, int n) {
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        T min;
        int minIndex;
        for (int lcv = 0; lcv < arr.length; ++lcv) {
            min = arr[lcv];
            minIndex = lcv;
            for (int lcv2 = lcv + 1; lcv2 < arr.length; ++lcv2) {
                if (arr[lcv2].compareTo(min) < 0) {
                    min = arr[lcv2];
                    minIndex = lcv2;
                }
            }
            swap(arr, lcv, minIndex);
        }
    }

    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int n = arr.length;
        int gap = n/2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                T temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap].compareTo(temp) > 0) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
            gap = gap / 2;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
        if (arr.length > 1) {
            int mid = (l - r) / 2;
            T[] left = (T[]) new Comparable[mid];
            for (int lcv = 0; lcv < mid - 1; lcv++) left[lcv] = arr[lcv];
            T[] right = (T[]) new Comparable[arr.length - mid];
            int i = 0;
            for (int lcv = mid - 1; lcv < arr.length; lcv++) {
                left[lcv] = arr[i];
                i++;
            }
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
        mergeSort(arr, 0, arr.length-1);
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[i]) < 0) { // check this
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            i++;
            k++;
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
