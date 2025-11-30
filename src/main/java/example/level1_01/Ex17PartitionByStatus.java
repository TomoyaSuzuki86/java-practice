package example.level1_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 1-17: 条件で 2 分割（パーティション）
 *
 * ねらい:
 * - 条件（OPEN かどうか）でリストを 2 つに分ける。
 *
 * なぜこの実装か（考え方）:
 * - 抽出（true）とそれ以外（false）を同時に作ると、その後の処理が分かりやすい。
 */
public class Ex17PartitionByStatus {

    static class Order { String status; Order(String s){ status = s; } }

    public static void main(String[] args) {
        System.out.println("Level 1-17: 条件で 2 分割");

        List<Order> src = sample();
        List<Order> open = new ArrayList<Order>();
        List<Order> others = new ArrayList<Order>();

        for (Order o : src) {
            if ("OPEN".equals(o.status)) {
                open.add(o);
            } else {
                others.add(o);
            }
        }

        System.out.println("OPEN  = " + open.size());
        System.out.println("OTHER = " + others.size());
    }

    private static List<Order> sample() {
        List<Order> l = new ArrayList<Order>();
        l.add(new Order("OPEN"));
        l.add(new Order("CLOSED"));
        l.add(new Order("HOLD"));
        l.add(new Order("OPEN"));
        return l;
    }
}

