public class SelectionSort {
    private static void sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int minIndex = findMinIndex(values, i), temp = values[i];
            values[i] = values[minIndex];
            values[minIndex] = temp;
        }
    }

    private static int findMinIndex(int[] values, int i) {
        int minIndex = i;
        for (; i <= values.length - 1; i++) {
            if (values[i] < values[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] values = new int[args.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.valueOf(args[i]);
        }
        sort(values);
        for (int value : values) {
            System.out.println(value);
        }
    }
}
