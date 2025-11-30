package example.level1_01;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Level 1-08: 数値の書式化（3 桁区切り）
 *
 * ねらい:
 * - 金額などの数値を見やすくフォーマットする。
 * - ロケールに応じた区切り（3 桁カンマなど）を体験。
 *
 * なぜこの実装か（考え方）:
 * - 文字列連結で 3 桁区切りを自作するより、NumberFormat を使う方が堅牢で再利用性が高い。
 */
public class Ex08FormatCurrency {

    public static void main(String[] args) {
        System.out.println("Level 1-08: 数値の書式化（3 桁区切り）");

        int amount = 1234567;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.JAPAN);
        String formatted = nf.format(amount);

        System.out.println("元の数値 = " + amount);
        System.out.println("書式化後 = " + formatted); // 1,234,567
    }
}

