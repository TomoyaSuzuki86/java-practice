package example.level1_01;

import java.util.HashMap;
import java.util.Map;

/**
 * Level 1-03: コード値変換（Map）
 *
 * ねらい:
 * - Map によるコード→名称の高速変換（キー検索）。
 * - 未定義コードの扱い（デフォルト表示）を学ぶ。
 *
 * なぜこの実装か（考え方）:
 * - コード値から名称を引く処理は「コード一覧を毎回ループで探す」より、Map のキー検索が高速で明快。
 * - HashMap#get は該当キーが無いと null を返す。null を検知してデフォルト文言を出すと、
 *   コード表に存在しない入力にも安全に対応できる。
 * - containsKey を使って存在チェックしてから get する方法もある（null を値に持つ場合に有効）。
 *
 * 実行結果のイメージ:
 * - コード配列: [OPEN, CLOSED, OPEN, X]
 * - 期待出力:
 *     OPEN -> 受付
 *     CLOSED -> 完了
 *     OPEN -> 受付
 *     X -> (未定義)
 *
 * ABAP なら（擬似コード）:
 *   READ TABLE t_status INTO wa WITH KEY code = code.
 *   IF sy-subrc <> 0.
 *     text = '(未定義)'.
 *   ENDIF.
 *
 * 実行方法:
 * - Eclipse でこのクラスを右クリック -> Run As -> Java Application
 */
public class Ex03CodeValueConversion {

    public static void main(String[] args) {
        System.out.println("Level 1-03: コード値変換");

        // コード -> 名称 の対応を Map に保持。
        // なぜ Map?: コード（キー）から名称（値）を一発で取得できるから。
        Map<String, String> statusText = new HashMap<String, String>();
        statusText.put("OPEN", "受付");
        statusText.put("CLOSED", "完了");
        statusText.put("CANCEL", "取消");

        // 変換したいコードの並び。
        String[] codes = {"OPEN", "CLOSED", "OPEN", "X"};

        for (String code : codes) {
            // get の戻りが null なら、未定義コードと判断してデフォルト表示。
            String text = statusText.get(code);
            if (text == null) {
                text = "(未定義)"; // デフォルト文言（要件に合わせて変更可）
            }
            System.out.println(code + " -> " + text);
        }
    }
}

