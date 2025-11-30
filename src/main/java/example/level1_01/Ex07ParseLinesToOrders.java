package example.level1_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 1-07: 文字列行のパース（CSV 風）
 *
 * ねらい:
 * - "A001,OPEN,1200" のような行を分割してオブジェクト化する。
 * - パースエラーを避けるため、型変換時は入力の妥当性を意識する。
 *
 * なぜこの実装か（考え方）:
 * - 外部データ（CSV/テキスト）を扱う基本は split と trim。
 * - まずは最小限の検証（要素数、数値変換）を行い、安全側でスキップする。
 */
public class Ex07ParseLinesToOrders {

    static class Order {
        String customer;
        String status;
        int amount;
        Order(String customer, String status, int amount) {
            this.customer = customer;
            this.status = status;
            this.amount = amount;
        }
        public String toString() {
            return customer + "," + status + "," + amount;
        }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-07: 文字列行のパース（CSV 風）");

        String[] lines = {
            "A001,OPEN,1200",
            "A002,OPEN,700",
            "A001,CLOSED,500",
            "BROKEN_LINE",
            "A003,CLOSED,300"
        };

        List<Order> orders = new ArrayList<Order>();
        for (String line : lines) {
            String[] cols = line.split(",");
            if (cols.length != 3) {
                // 想定外行はスキップ（現場ではログ出力など）
                continue;
            }
            String customer = cols[0].trim();
            String status = cols[1].trim();
            int amount;
            try {
                amount = Integer.parseInt(cols[2].trim());
            } catch (NumberFormatException ex) {
                continue; // 数値化できなければスキップ
            }
            orders.add(new Order(customer, status, amount));
        }

        System.out.println("パース件数 = " + orders.size());
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}

