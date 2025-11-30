package example.level1_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 1-16: 入力検証とスキップ（continue）
 *
 * ねらい:
 * - 無効なデータ（負数や極端な値）をスキップして集計する。
 *
 * なぜこの実装か（考え方）:
 * - 業務では「欠陥データは除外して処理継続」がよくある。continue で読みやすく実現。
 */
public class Ex16ValidateAndSkip {

    static class Record {
        int amount;
        Record(int amount) { this.amount = amount; }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-16: 入力検証とスキップ");

        List<Record> list = sample();
        int total = 0;
        int invalid = 0;
        for (Record r : list) {
            if (r.amount < 0 || r.amount > 10_000) {
                invalid++;
                continue; // 無効値はカウントだけしてスキップ
            }
            total += r.amount;
        }

        System.out.println("合計 = " + total);
        System.out.println("無効件数 = " + invalid);
    }

    private static List<Record> sample() {
        List<Record> l = new ArrayList<Record>();
        l.add(new Record(100));
        l.add(new Record(-50));
        l.add(new Record(300));
        l.add(new Record(20_000));
        return l;
    }
}

