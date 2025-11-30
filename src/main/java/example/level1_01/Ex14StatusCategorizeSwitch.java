package example.level1_01;

/**
 * Level 1-14: ステータスのカテゴリ分け（switch）
 *
 * ねらい:
 * - 複数のコード値をカテゴリへマップするロジックを switch で表現。
 *
 * なぜこの実装か（考え方）:
 * - if/else の連鎖よりも switch の方が「コード→カテゴリ」が読みやすい場合がある。
 */
public class Ex14StatusCategorizeSwitch {

    public static void main(String[] args) {
        System.out.println("Level 1-14: ステータスのカテゴリ分け");

        String[] codes = {"OPEN", "HOLD", "CLOSED", "CANCEL", "UNKNOWN"};
        for (String c : codes) {
            String category;
            switch (c) {
                case "OPEN":
                case "HOLD":
                    category = "処理中";
                    break;
                case "CLOSED":
                    category = "完了";
                    break;
                case "CANCEL":
                    category = "取消";
                    break;
                default:
                    category = "未定義";
            }
            System.out.println(c + " -> " + category);
        }
    }
}

