package example.level1_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Level 1-18: 上位 N 件の抽出（金額降順）
 *
 * ねらい:
 * - 金額で降順に並べ、上位 N 件を取り出す。
 *
 * なぜこの実装か（考え方）:
 * - 業務でよくある「ランキング」系要件。Comparator で比較キーを明示すると読みやすい。
 */
public class Ex18TopNByAmount {

    static class Order {
        String customer; int amount;
        Order(String c, int a){ customer=c; amount=a; }
        public String toString(){ return customer+":"+amount; }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-18: 上位 N 件（降順）");

        List<Order> list = sample();
        int N = 3;

        // 金額降順で並べる
        Collections.sort(list, new Comparator<Order>() {
            public int compare(Order a, Order b) {
                return Integer.compare(b.amount, a.amount); // 降順
            }
        });

        // 先頭 N 件を表示（N 超過時はリスト長まで）
        int limit = Math.min(N, list.size());
        for (int i = 0; i < limit; i++) {
            System.out.println((i+1) + ": " + list.get(i));
        }
    }

    private static List<Order> sample() {
        List<Order> l = new ArrayList<Order>();
        l.add(new Order("A001", 1200));
        l.add(new Order("A002", 700));
        l.add(new Order("A003", 300));
        l.add(new Order("A004", 2000));
        l.add(new Order("A005", 900));
        return l;
    }
}

