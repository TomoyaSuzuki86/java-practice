package example.level1_01;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Level 1-05: 重複除去（順序維持）
 *
 * ねらい:
 * - 重複を取り除いて一意の集合を作る。
 * - 入力順を維持したい場合に LinkedHashSet が有効であることを知る。
 *
 * なぜこの実装か（考え方）:
 * - HashSet は一意化できるが順序は保証されない。学習の最初は順序維持が分かりやすいので LinkedHashSet。
 * - Set に入れてから配列/リストへ戻すと、以後の処理（表示、検索）にも使いやすい。
 *
 * 実行結果のイメージ:
 * - 入力: ["A", "B", "A", "C", "B"]
 * - 出力: ["A", "B", "C"]（最初に出現した順に並ぶ）
 *
 * ABAP なら（擬似コード）:
 *   SORT itab BY field.
 *   DELETE ADJACENT DUPLICATES FROM itab COMPARING field.
 */
public class Ex05RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println("Level 1-05: 重複除去（順序維持）");

        String[] src = {"A", "B", "A", "C", "B"};

        Set<String> uniq = new LinkedHashSet<String>(Arrays.asList(src));
        String[] result = uniq.toArray(new String[0]);

        System.out.println("入力  = " + Arrays.toString(src));
        System.out.println("一意化= " + Arrays.toString(result));
    }
}

