package 傻逼排序.猴子排序;

import java.util.Arrays;
import java.util.Random;

public class Main {


    // 检查数组是否有序
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 随机排列数组
    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = random.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }

    // 猴子排序，返回排序次数
    public static int bogoSort(int[] array) {
        int shuffleCount = 0;
        while (!isSorted(array)) {
            shuffle(array);
            shuffleCount++;
        }
        return shuffleCount;
    }

    // 主函数
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 4, 2,10,7,21,24,36,74,59,64};

        System.out.println("Unsorted array: " + Arrays.toString(array));

        long startTime = System.nanoTime();
        long shuffleCount = bogoSort(array);
        long endTime = System.nanoTime();

        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Number of shuffles: " + shuffleCount);
        System.out.println("Time taken (nanoseconds): " + (endTime - startTime));
    }
}
