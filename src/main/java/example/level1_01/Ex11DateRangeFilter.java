package example.level1_01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Level 1-11: 日付範囲で抽出（yyyy-MM-dd）
 *
 * ねらい:
 * - 文字列の日付を LocalDate に変換し、範囲条件（開始～終了の間）で抽出する。
 *
 * なぜこの実装か（考え方）:
 * - 日付比較は文字列ではなく LocalDate 等の型で扱う方が安全で読みやすい。
 */
public class Ex11DateRangeFilter {

    static class Event {
        String name;
        LocalDate date;
        Event(String name, String yyyyMMdd) {
            this.name = name;
            this.date = LocalDate.parse(yyyyMMdd);
        }
    }

    public static void main(String[] args) {
        System.out.println("Level 1-11: 日付範囲で抽出");

        List<Event> events = sample();
        LocalDate from = LocalDate.parse("2023-04-01");
        LocalDate to   = LocalDate.parse("2023-04-30");

        int hits = 0;
        for (Event e : events) {
            if (!e.date.isBefore(from) && !e.date.isAfter(to)) { // from<=date<=to
                System.out.println(e.name + " @" + e.date);
                hits++;
            }
        }
        System.out.println("該当件数 = " + hits);
    }

    private static List<Event> sample() {
        List<Event> list = new ArrayList<Event>();
        list.add(new Event("Kickoff", "2023-03-31"));
        list.add(new Event("Dev1",    "2023-04-10"));
        list.add(new Event("Dev2",    "2023-04-25"));
        list.add(new Event("Release", "2023-05-01"));
        return list;
    }
}

