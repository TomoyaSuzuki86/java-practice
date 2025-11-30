package example.level1_01;

import java.util.Arrays;

/**
 * Level 1-04: 並び替え（昇順・降順）
 *
 * ねらい:
 * - 配列の並び替え（昇順）を Arrays.sort で簡潔に行う。
 * - 降順は「昇順後に反転」などシンプルな手で実現できることを知る。
 *
 * なぜこの実装か（考え方）:
 * - 初学段階では「読みやすさ」を優先し、標準 API（Arrays.sort）を使う。
 * - 降順のために無理に複雑なアルゴリズムを書くより、反転の方が意図が伝わりやすい。
 * - 配列は破壊的に並び替えられるので、元配列を残したい場合はコピーしてから操作する。
 *
 * 実行結果のイメージ:
 * - 入力: [5, 2, 9, 1, 5, 6]
 * - 昇順: [1, 2, 5, 5, 6, 9]
 * - 降順: [9, 6, 5, 5, 2, 1]
 *
 * ABAP なら（擬似コード）:
 *   itab = [5,2,9,1,5,6].
 *   SORT itab ASCENDING.
 *   " 降順にしたければ逆順に読む/逆に並べ替える
 *
 * 実行方法:
 * - Eclipse でこのクラスを右クリック -> Run As -> Java Application
 */
public class Ex04SortBasic {

    public static void main(String[] args) {
        System.out.println("Level 1-04: 並び替え（昇順・降順）");

        int[] data = {5, 2, 9, 1, 5, 6};

        // 昇順: 標準 API を使う（読みやすい・高速）
        int[] asc = Arrays.copyOf(data, data.length);
        Arrays.sort(asc);

        // 降順: 昇順結果を反転する（単純・明快）
        int[] desc = Arrays.copyOf(asc, asc.length);
        for (int i = 0; i < desc.length / 2; i++) {
            int j = desc.length - 1 - i;
            int tmp = desc[i];
            desc[i] = desc[j];
            desc[j] = tmp;
        }

        System.out.println("昇順 = " + Arrays.toString(asc));
        System.out.println("降順 = " + Arrays.toString(desc));
    }
}

