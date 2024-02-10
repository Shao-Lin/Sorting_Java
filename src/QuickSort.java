public class QuickSort {

    private static int comparisonCount = 0;

    public static void main(String[] args) {
        int[] array = {3,7,2,4,6,7,1};
        System.out.println("Исходный массив:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("\nОтсортированный массив:");
        printArray(array);

        System.out.println("\nКоличество сравнений: " + comparisonCount);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisonCount++; // Увеличиваем счетчик сравнений

            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
