public class Main{
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 使用插入排序算法对整数数组进行排序。
     * 插入排序的工作原理是将数组分为已排序和未排序两个部分，然后逐个将未排序元素插入到已排序部分的正确位置。
     * 此方法不返回任何值，直接在输入的数组上进行排序。
     *
     * @param arr 待排序的整数数组。
     */
    public static void insertSort(int[] arr){
        // 从第二个元素开始遍历，因为第一个元素默认已排序
        for (int i = 1; i < arr.length; i++) {
            // j 用于跟踪当前要插入的元素的前一个位置
            int j = i - 1;
            // k 保存当前要插入的元素
            int k = arr[i];
            // 将当前元素 k 与之前的元素进行比较，并向前移动大于 k 的元素
            while (j >= 0 && arr[j] > k) {
                // 将大于 k 的元素向后移动一位
                arr[j + 1] = arr[j];
                // 向前移动到下一个要比较的元素
                j = j - 1;
            }
            // 将 k 插入到已排序序列的正确位置
            arr[j + 1] = k;
        }
    }
}