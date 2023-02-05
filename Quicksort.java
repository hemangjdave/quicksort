import java.util.Arrays;

/**
 * Created By Hemang Dave
 * Date: 05/02/23
 * Time: 9:02 pm
 */
public class Quicksort {

    private static int findPartitionIdx(int[] input, int low, int high) {
        var pIdx = low - 1;
        var pivot = input[high];
        for (var i = low; i <= high; i++) {
            if (input[i] < pivot) {
                pIdx++;
                swap(input, pIdx, i);
            }
        }
        pIdx++;
        var temp = input[pIdx];
        input[pIdx] = pivot;
        input[high] = temp;
        return pIdx;
    }

    private static void swap(int[] input, int from, int to) {
        var temp = input[from];
        input[from] = input[to];
        input[to] = temp;
    }

    public static void performSort(int[] input, int low, int high) {
        if (low < high) {
            var partitionIdx = findPartitionIdx(input, low, high);
            performSort(input, low, partitionIdx - 1);
            performSort(input, partitionIdx + 1, high);
        }
    }

    public static void main(String[] args) {
        var array = new int[]{6, 3, 9, 5, 2, 8};
        System.out.println(Arrays.toString(array));
        performSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        array = new int[]{6, 9, 8, 2, 1, 5, 4, 3, 7};
        System.out.println(Arrays.toString(array));
        performSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
