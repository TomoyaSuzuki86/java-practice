package example.level1_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Level 1-10: 複数値の条件（WHERE IN 相当）
 *
 * ねらい:
 * - ステータスが {OPEN, HOLD} に含まれる行のみ抽出して合計。
 * - セットによる「所属判定」を学ぶ。
 */
public class Ex10FilterWhereIn {

    static class Order {
        String status;
        int amount;
        Order(String status, int amount) {
            this.status = status;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-10: 複数値の条件（WHERE IN 相当）");

        List<Order> orders = sample();
        Set<String> target = new HashSet<String>();
        target.add("OPEN");
        target.add("HOLD");

        int total = 0;
        for (Order o : orders) {
            if (target.contains(o.status)) {
                total += o.amount;
            }
        }

        System.out.println("対象ステータス={OPEN,HOLD} の合計 = " + total);
    }

    private static List<Order> sample() {
        List<Order> list = new ArrayList<Order>();
        list.add(new Order("OPEN", 500));
        list.add(new Order("HOLD", 300));
        list.add(new Order("CLOSED", 700));
        list.add(new Order("OPEN", 200));
        return list;
    }
}

