package example.level1_01;

import java.util.Arrays;

/**
 * Level 1-13: 最小・最大・平均
 *
 * ねらい:
 * - 1 回のループで min/max/sum を同時に計算し、平均を出す。
 *
 * なぜこの実装か（考え方）:
 * - 3 回ループするより 1 回で済ませる方がシンプルで効率的。
 */
public class Ex13MinMaxAvg {

    public static void main(String[] args) {
        System.out.println("Level 1-13: 最小・最大・平均");

        int[] data = {12, 7, 20, 3, 15};
        int min = data[0];
        int max = data[0];
        long sum = 0; // 平均計算で桁あふれを避けるため long

        for (int n : data) {
            if (n < min) min = n;
            if (n > max) max = n;
            sum += n;
        }
        double avg = sum / (double) data.length;

        System.out.println("入力 = " + Arrays.toString(data));
        System.out.println("最小 = " + min);
        System.out.println("最大 = " + max);
        System.out.println("平均 = " + avg);
    }
}

