package example.level1_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Level 1-20: 2 キー並べ替え（得意先昇順、同一得意先内は金額降順）
 *
 * ねらい:
 * - 複数キーでの並び替えを Comparator で表現する。
 *
 * なぜこの実装か（考え方）:
 * - ABAP の SORT BY customer ASCENDING amount DESCENDING に相当。
 * - 比較の優先順位をコードで明示できるので、読み手の意図が伝わる。
 */
public class Ex20TwoKeySort {

    static class Order {
        String customer; int amount;
        Order(String c, int a){ customer=c; amount=a; }
        public String toString(){ return customer+":"+amount; }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-20: 2 キー並べ替え");

        List<Order> list = new ArrayList<Order>();
        list.add(new Order("A002", 800));
        list.add(new Order("A001", 1200));
        list.add(new Order("A001", 700));
        list.add(new Order("A003", 300));

        Collections.sort(list, new Comparator<Order>() {
            public int compare(Order a, Order b) {
                int c = a.customer.compareTo(b.customer); // 1. 得意先昇順
                if (c != 0) return c;
                return Integer.compare(b.amount, a.amount); // 2. 金額降順
            }
        });

        for (Order o : list) {
            System.out.println(o);
        }
    }
}

