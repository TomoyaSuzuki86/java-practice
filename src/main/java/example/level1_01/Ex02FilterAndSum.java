package example.level1_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 1-02: 明細のフィルタと合計
 *
 * ねらい:
 * - List と簡単な POJO でデータを保持
 * - 条件に合う行だけ合計（金額集計）
 *
 * なぜこの実装か（考え方）:
 * - 業務で扱う明細は「複数の属性（得意先、ステータス、金額など）」を持つことが多いため、
 *   配列よりフィールドを持つ小さなクラス（POJO）で表現すると読みやすい。
 * - 条件「得意先=A001 かつ ステータス=OPEN」を if で明示し、該当時のみ加算することで、
 *   抽出と集計を同時に行える（無駄な中間リストを作らない）。
 * - 文字列比較は == ではなく equals を使用（参照比較と値比較の違いに注意）。
 * - 処理量は O(N)。まずは正しく・分かりやすく書くことを重視（後で Stream 等へ展開可能）。
 *
 * 実行結果のイメージ:
 * - サンプルデータのうち、A001 かつ OPEN の行は 3 件（1200, 800, 100）。
 * - 期待出力:
 *     得意先=A001, ステータス=OPEN
 *     件数 = 3
 *     合計 = 2100
 *
 * ABAP なら（擬似コード）:
 *   total = 0.
 *   LOOP AT it_orders INTO wa WHERE customer = 'A001' AND status = 'OPEN'.
 *     total = total + wa-amount.
 *   ENDLOOP.
 *
 * 実行方法:
 * - Eclipse でこのクラスを右クリック -> Run As -> Java Application
 */
public class Ex02FilterAndSum {

    // 取引明細（ABAP のワークエリアに相当）
    static class Order {
        // なぜフィールドを分けるか: 後で条件を変えたり表示したりする際に読みやすいから。
        String customer; // 得意先コード（例: A001）
        String status;   // ステータス（OPEN/CLOSED）
        int amount;      // 金額

        Order(String customer, String status, int amount) {
            this.customer = customer;
            this.status = status;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-02: 明細のフィルタと合計");

        // サンプル明細を用意。現場では DB 取得結果をこの形にマッピングすると扱いやすい。
        List<Order> orders = sample();

        String targetCustomer = "A001";
        String targetStatus = "OPEN"; // この条件に合う行だけ合計

        int total = 0; // 金額合計
        int hits = 0;  // 該当件数
        for (Order o : orders) {
            // equals を使う理由: 文字列は「値」を比較したい（== は参照比較で誤りになりうる）
            if (targetCustomer.equals(o.customer) && targetStatus.equals(o.status)) {
                total += o.amount; // 金額を合計
                hits++;            // 件数をカウント
            }
        }

        // 結果の出力。期待: 件数=3, 合計=2100
        System.out.println("得意先=" + targetCustomer + ", ステータス=" + targetStatus);
        System.out.println("件数 = " + hits);
        System.out.println("合計 = " + total);
    }

    private static List<Order> sample() {
        // 学習用の固定データ。実務では外部入力や DB から作る想定。
        List<Order> list = new ArrayList<Order>();
        list.add(new Order("A001", "OPEN", 1200));
        list.add(new Order("A001", "CLOSED", 500));
        list.add(new Order("A002", "OPEN", 700));
        list.add(new Order("A001", "OPEN", 800));
        list.add(new Order("A003", "CLOSED", 300));
        list.add(new Order("A001", "OPEN", 100));
        return list;
    }
}
