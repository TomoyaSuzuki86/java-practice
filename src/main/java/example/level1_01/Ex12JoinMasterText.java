package example.level1_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Level 1-12: 名称マスタの JOIN（コード→名称付与）
 *
 * ねらい:
 * - 明細（得意先コード）に対して、名称マスタから名称を引き付与する（JOIN 的発想）。
 *
 * なぜこの実装か（考え方）:
 * - ABAP の READ TABLE WITH KEY のイメージ。Java では Map のキー検索が分かりやすい。
 * - 未登録コードに対してはデフォルト名称を出し、落ちない実装にする。
 */
public class Ex12JoinMasterText {

    static class Order {
        String customer;
        int amount;
        Order(String customer, int amount) {
            this.customer = customer;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-12: 名称マスタの JOIN");

        List<Order> orders = sample();
        Map<String, String> customerName = master();

        for (Order o : orders) {
            String name = customerName.get(o.customer);
            if (name == null) {
                name = "(名称未登録)";
            }
            System.out.println(o.customer + "(" + name + ") : " + o.amount);
        }
    }

    private static List<Order> sample() {
        List<Order> list = new ArrayList<Order>();
        list.add(new Order("A001", 1200));
        list.add(new Order("A002", 700));
        list.add(new Order("A999", 300));
        return list;
    }

    private static Map<String, String> master() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("A001", "田中商事");
        m.put("A002", "佐藤商会");
        m.put("A003", "山田物産");
        return m;
    }
}

