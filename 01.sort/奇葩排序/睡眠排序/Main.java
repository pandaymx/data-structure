package 奇葩排序.睡眠排序;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1 };
        sleepSort(arr);
    }

    // 睡眠排序
    public static void sleepSort(int[] nums) {
        final int[] sortedArray = new int[nums.length];
        final int[] index = { 0 };

        long startTime = System.currentTimeMillis();

        for (int num : nums) {
            new Thread(() -> {
                try {
                    Thread.sleep(num); // 休眠时间为当前数字的值
                    sortedArray[index[0]++] = num;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // 等待所有线程完成
        while (index[0] < nums.length) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;

        System.out.println("排序后的数组: " + Arrays.toString(sortedArray));
        System.out.println("排序耗时（秒）: " + elapsedTime);
    }
}
