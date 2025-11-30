package example.level1_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 1-19: 明細の結合（2 リストを結合して再集計）
 *
 * ねらい:
 * - 2 つの同型リストを結合（append）して、合計などを再集計する。
 *
 * なぜこの実装か（考え方）:
 * - ABAP の APPEND LINES OF itab2 TO itab1 に相当。Java では addAll が分かりやすい。
 */
public class Ex19MergeAndSum {

    static class Record { int amount; Record(int a){ amount=a; } }

    public static void main(String[] args) {
        System.out.println("Level 1-19: 明細の結合と集計");

        List<Record> list1 = new ArrayList<Record>();
        list1.add(new Record(100));
        list1.add(new Record(200));

        List<Record> list2 = new ArrayList<Record>();
        list2.add(new Record(300));
        list2.add(new Record(400));

        // 結合：list1 に list2 を追加
        list1.addAll(list2);

        int total = 0;
        for (Record r : list1) {
            total += r.amount;
        }
        System.out.println("合計 = " + total); // 100+200+300+400 = 1000
    }
}

