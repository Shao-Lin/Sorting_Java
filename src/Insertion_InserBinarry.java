public class Insertion_InserBinarry {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        insertionSort(arr);


        int[] arr2 = {7,6,5,4,3,2,1};
        binaryInsertionSort(arr2);

    }
    public static void insertionSort(int[] array) {
        int n = array.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            do {
                comparisons++;
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                    swaps++;
                }
            }
            while (j >= 0 && array[j] > key);

            array[j + 1] = key;
        }

        System.out.println("Insertion Sort Comparisons: " + comparisons);
        System.out.println("Insertion Sort Swaps: " + swaps);
    }
    public static void binaryInsertionSort(int[] array) {
        int n = array.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 1; i < n; ++i) {
            int key = array[i];

// Реализация собственного бинарного поиска с подсчетом сравнений
            int low = 0;
            int high = i - 1;
            int index = -1;

            while (low <= high) {
                comparisons++;
                int mid = (low + high) / 2;
                if (key < array[mid]) {
                    index = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (index == -1) {
                index = i;
            }

// Перемещаем элементы для вставки нового элемента без дополнительных сравнений
            for (int j = i; j > index; j--) {
                array[j] = array[j - 1];
            }
            array[index] = key;
            swaps += i - index;
        }

        System.out.println("Binary Insertion Sort Comparisons: " + comparisons);
        System.out.println("Binary Insertion Sort Swaps: " + swaps);
    }
}