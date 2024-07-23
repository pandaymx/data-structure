public class Main{
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        shellSort(arr);
        // insertSort(arr);
        System.out.println("\n排序后的数组");
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
    public static void insertSort(int[] arr) {
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

    /**
     * 使用二分插入排序对整数数组进行排序。
     * 二分插入排序的优点在于，当数组部分有序时，它可以更有效地工作，因为它在插入元素时使用了二分搜索来定位插入位置。
     * 这个方法通过比较数组中的元素来排序它们，将每个元素插入到已排序的子数组中的正确位置。
     *
     * @param arr 待排序的整数数组。
     */
    public static void binaryInsertionSort(int[] arr) {
        // 从第二个元素开始遍历数组，因为第一个元素默认已排序
        for (int i = 1; i < arr.length; i++) {
            // 将当前元素存储在key中，以便在接下来的步骤中将其插入到正确的位置
            int key = arr[i];
            // 使用二分搜索确定key应该插入的位置
            int insertPos = binarySearch(arr, key, 0, i - 1);
            // 将大于key的元素向右移动，为key腾出插入位置
            for (int j = i - 1; j >= insertPos; j--) {
                arr[j + 1] = arr[j];
            }
            // 将key插入到找到的正确位置
            arr[insertPos] = key;
        }
    }

    /**
     * 实现二分查找算法。
     * 在已排序的整数数组中查找特定元素的索引，如果元素不存在，则返回插入点。
     * 二分查找是一种效率较高的查找算法，它每次都能将搜索范围减半。
     *
     * @param arr  排序后的整数数组。
     * @param key  需要查找的元素。
     * @param low  搜索范围的最低索引。
     * @param high 搜索范围的最高索引。
     * @return 如果找到元素，则返回其索引；如果未找到，返回插入点的索引。
     */
    private static int binarySearch(int[] arr, int key, int low, int high) {
        /* 当最低索引小于等于最高索引时，继续搜索 */
        while (low <= high) {
            /* 计算中间索引，避免整数溢出 */
            int mid = low + (high - low) / 2;

            /* 如果中间元素小于关键字，则关键字可能在中间元素的右侧，更新最低索引 */
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                /* 否则，关键字可能在中间元素的左侧或就是中间元素本身，更新最高索引 */
                high = mid - 1;
            }
        }
        /* 返回插入点的索引，即最低索引 */
        return low;
    }

    /**
     * 希尔排序
     * 希尔排序是一种基于插入排序的算法，通过设置间隔（gap）来分组元素，对每个组内的元素进行插入排序，
     * 然后逐渐减小间隔，直到间隔为1，此时对整个数组进行一次插入排序。这种方式可以有效地减少元素的移动次数，
     * 提高排序的效率。
     * 
     * @param arr 待排序的整型数组
     */
    // 希尔排序
    public static void shellSort(int[] arr) {
        // 获取数组长度
        int len = arr.length;
        // 用于临时存储交换的元素
        int temp;
        // 初始间隔为数组长度的一半
        int gap = len / 2;

        // 当间隔大于0时，继续排序
        while (gap > 0) {
            // 从间隔开始，对每个元素进行插入排序
            for (int i = gap; i < len; i++) {
                // 保存当前元素，以便插入排序
                temp = arr[i];
                // 计算当前元素的前一个元素的索引
                int j = i - gap;

                // 将大于当前元素的元素依次后移
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                // 将当前元素插入正确的位置
                arr[j + gap] = temp;
            }
            // 缩小间隔，以进行下一轮排序
            gap /= 2;
        }
    }
}