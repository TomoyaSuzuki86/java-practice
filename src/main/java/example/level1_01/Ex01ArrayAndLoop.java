package example.level1_01;

/**
 * Level 1-01: 配列とループ（合計と件数）
 *
 * ねらい:
 * - for-each ループと if 条件の基本を体験する。
 * - 数値配列から「10以上」の合計と件数をシンプルに計算する。
 *
 * なぜこの実装か（考え方）:
 * - for-each は配列の全要素を安全・簡潔に走査でき、添字ミスを避けられる。
 * - 条件は n >= 10 をそのまま書くことで、読み手が意図（10以上のみ計上）を一目で理解できる。
 * - 合計(sum)と件数(count)はループ内で同時に更新すると、無駄な二重走査を避けられる。
 * - まずは“読みやすさと正しさ”を優先（最適化や高度な API は後のレベルで学ぶ）。
 *
 * 実行結果のイメージ:
 * - 入力: {5, 12, 7, 20, 3, 15}
 * - 計上対象: 12, 20, 15（10以上）
 * - 期待出力:
 *     10以上の合計 = 47
 *     10以上の件数 = 3
 *
 * ABAP なら（擬似コード）:
 *   LOOP AT it_numbers INTO wa.
 *     IF wa GE 10.
 *       sum = sum + wa.
 *       count = count + 1.
 *     ENDIF.
 *   ENDLOOP.
 *
 * 実行方法:
 * - Eclipse でこのクラスを右クリック -> Run As -> Java Application
 */
public class Ex01ArrayAndLoop {

    public static void main(String[] args) {
        System.out.println("Level 1-01: 配列とループ（10以上の合計・件数）");

        // 入力データ（固定配列）: 現場では DB の取得結果（内表）を想定
        int[] numbers = {5, 12, 7, 20, 3, 15};

        // 合計と件数を保持する変数。
        // 初期値は 0（加算の単位元）にするのが自然で、分かりやすい。
        int sum = 0;
        int count = 0;

        // 1 回のループで「判定」と「集計」を同時に行う。
        // 単純明快・可読性優先。要素数 N に対して O(N) の処理量。
        for (int n : numbers) { // 配列の全要素を順に取り出す
            if (n >= 10) {      // 仕様: 10以上のみ計上
                sum += n;       // 合計に加算（sum = sum + n）
                count++;        // 件数を 1 増やす（count = count + 1）
            }
        }

        // 結果の表示。期待値: 合計=47, 件数=3
        System.out.println("10以上の合計 = " + sum);
        System.out.println("10以上の件数 = " + count);
    }
}
