package example.level1_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Level 1-06: 得意先別の合計（金額のグループ集計）
 *
 * ねらい:
 * - Map を使って「キー（得意先）ごとの合計」を出す。
 * - 1 回の走査で集計（更新 or 初期化）するパターンを覚える。
 *
 * なぜこの実装か（考え方）:
 * - ABAP の COLLECT/SUM BY に近い集計は Map への累積がシンプルで分かりやすい。
 * - get の戻りが null（未登録）のときは初期値 0 から加算すれば良い。
 *
 * 実行結果のイメージ（例）:
 *   A001 -> 2100, A002 -> 700, A003 -> 300
 */
public class Ex06GroupSumByKey {

    static class Order {
        String customer;
        int amount;
        Order(String customer, int amount) {
            this.customer = customer;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-06: 得意先別の合計");

        List<Order> orders = sample();

        Map<String, Integer> totalByCustomer = new HashMap<String, Integer>();
        for (Order o : orders) {
            Integer current = totalByCustomer.get(o.customer);
            if (current == null) {
                current = 0; // 初回は 0 から
            }
            totalByCustomer.put(o.customer, current + o.amount);
        }

        for (Map.Entry<String, Integer> e : totalByCustomer.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    private static List<Order> sample() {
        List<Order> list = new ArrayList<Order>();
        list.add(new Order("A001", 1200));
        list.add(new Order("A001", 500));
        list.add(new Order("A002", 700));
        list.add(new Order("A001", 400));
        list.add(new Order("A003", 300));
        list.add(new Order("A001", 500));
        return list;
    }
}

