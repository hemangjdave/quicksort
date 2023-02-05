import java.util.Arrays;

/**
 * Created By Hemang Dave
 * Date: 05/02/23
 * Time: 11:12 pm
 */
public class QuicksortFirstElementPivot {

    private static int getPartitionIndex(int[] input, int low, int high) {
        var pivot = input[low];
        var partitionIdx = high + 1;
        for (var i = high; i > low; i--) {
            if (input[i] > pivot) {
                partitionIdx--;
                swap(input, partitionIdx, i);
            }
        }
        --partitionIdx;
        var temp = input[partitionIdx];
        input[partitionIdx] = pivot;
        input[low] = temp;
        return partitionIdx;
    }

    private static void swap(int[] input, int from, int to) {
        var temp = input[from];
        input[from] = input[to];
        input[to] = temp;
    }

    private static void sort(int[] input, int low, int high) {
        if (low < high) {
            var partitionIdx = getPartitionIndex(input, low, high);
            sort(input, low, partitionIdx - 1);
            sort(input, partitionIdx + 1, high);
        }
    }

    //6, 3, 9, 5, 2, 8
    public static void main(String[] args) {
        var array = new int[]{6, 3, 9, 5, 2, 8};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        array = new int[]{6, 9, 8, 2, 1, 5, 4, 3, 7};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
