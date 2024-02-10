public class MergeSort {
    public static int comparisonCount = 0;
    public static void main(String[] args) {
        int[] array = {5,9,8,7,1,10,4,3,2,1};

        System.out.println("Исходный массив:");
        printArray(array);

        mergeSort(array);

        System.out.println("\nОтсортированный массив:");
        printArray(array);

        System.out.println("\nКоличество сравнений: " + comparisonCount);
    }

    private static void mergeSort(int[] array) {
        int n = array.length;
        if (n > 1) {
            int mid = n / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[n - mid];

            System.arraycopy(array, 0, leftArray, 0, mid);
            System.arraycopy(array, mid, rightArray, 0, n - mid);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(array, leftArray, rightArray);
        }
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            comparisonCount++;

            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}