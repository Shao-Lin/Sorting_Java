public class ShellAndBubble {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array2 = {10,9, 8, 7, 6, 5, 4, 3, 2, 1};

        int operationCount = bubbleSort(array);

        System.out.println("Sorted array:");
        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println("\nNumber of operations: " + operationCount);

        System.out.println("----------------------------------------------------------");
        int operationCount2 = shellSort(array2);
        System.out.println("Sorted array:");
        for (int value : array2) {
            System.out.print(value + " ");
        }

        System.out.println("\nNumber of operations: " + operationCount2);


    }
    private static int bubbleSort(int[] array) {
        int operationCount = 0;

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {

                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    operationCount ++;
                }
            }
        }

        return operationCount;
    }

    private static int shellSort(int[] array2) {

        int operationCount = 0;


        for (int interval = array2.length / 3; interval > 0; interval /= 3) {
            for (int i = interval; i < array2.length; i++) {
                operationCount++;
                int temp = array2[i];
                int j;

                for ( j = i; j >= interval && array2[j - interval] > temp; j -= interval) {
                    array2[j] = array2[j - interval];
                }

                array2[j] = temp;
            }
        }

        return operationCount;
    }
}