package example.level1_01;

import java.util.Arrays;

/**
 * Level 1-15: 累積合計（ランニングトータル）
 *
 * ねらい:
 * - 並び順に依存した累積合計を計算する。
 *
 * なぜこの実装か（考え方）:
 * - ABAP の AT NEW/END に通じる考え方。まずは全件での単純な累積から。
 */
public class Ex15RunningTotal {

    public static void main(String[] args) {
        System.out.println("Level 1-15: 累積合計");

        int[] data = {100, 200, -50, 300};
        int[] running = new int[data.length];

        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            running[i] = sum;
        }

        System.out.println("入力   = " + Arrays.toString(data));
        System.out.println("累積合計 = " + Arrays.toString(running));
    }
}

