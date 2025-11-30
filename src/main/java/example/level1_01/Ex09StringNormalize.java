package example.level1_01;

/**
 * Level 1-09: 文字列の整形（トリム・スペース圧縮・大文字化）
 *
 * ねらい:
 * - 入力文字列の前後空白除去、連続スペースの圧縮、変換（大文字化）を学ぶ。
 *
 * なぜこの実装か（考え方）:
 * - ABAP の CONDENSE に相当: 正規表現で連続空白を 1 つにまとめる。
 * - trim で前後空白を落とすのは定番の前処理。
 */
public class Ex09StringNormalize {

    public static void main(String[] args) {
        System.out.println("Level 1-09: 文字列の整形");

        String raw = "  aBc   de   F  ";
        String trimmed = raw.trim();
        String condensed = trimmed.replaceAll("\\s+", " "); // 連続空白を 1 つに
        String upper = condensed.toUpperCase();

        System.out.println("元   = [" + raw + "]");
        System.out.println("整形 = [" + upper + "]"); // ABC DE F
    }
}

