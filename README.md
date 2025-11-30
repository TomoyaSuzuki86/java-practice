# Java Practice for SAP ABAP Engineer

ABAP の日常処理（フィルタ・集計・コード変換）を Java で「模写＋実行」する学習用プロジェクトです。Eclipse 上で `main` を実行するだけで確認できます。

## 学習の進め方（模写）
1) `src/main/java/example/...` のクラスを開く → 右クリック → Run As → Java Application（動作確認）
2) `src/main/java/practice/...` の同名クラスを開く（中身は空の骨子）
3) example のコードをそのまま practice 側へコピー（必要なら package 名のみ `practice...` に合わせる）
4) 再度 Run して、同じ結果が出ることを確認
5) 慣れてきたら、変数名や条件を少しずつ変えて試す（任意）

## 構成
- `example/level1_01` 基礎編（Level 1 全20題）……完成コード（模範解答）
  - Ex01 配列とループ（10以上の合計・件数）
  - Ex02 明細のフィルタと合計
  - Ex03 コード値変換（Map）
  - Ex04 並び替え（昇順・降順）
  - Ex05 重複除去（順序維持）
  - Ex06 得意先別の合計（グループ集計）
  - Ex07 文字列行のパース（CSV 風）
  - Ex08 数値の書式化（3 桁区切り）
  - Ex09 文字列整形（トリム・圧縮・大文字）
  - Ex10 WHERE IN 相当の抽出
  - Ex11 日付範囲で抽出
  - Ex12 名称マスタの JOIN（コード→名称）
  - Ex13 最小・最大・平均
  - Ex14 ステータスのカテゴリ分け（switch）
  - Ex15 累積合計
  - Ex16 入力検証とスキップ（continue）
  - Ex17 条件で 2 分割（パーティション）
  - Ex18 上位 N 件（降順）
  - Ex19 明細の結合と集計
  - Ex20 2 キー並べ替え（得意先→金額）
- `practice/level1_01` 練習用の骨子（各 ExXX に対応。main と学習 Tips のみ）

## Java バージョン
- プロジェクト設定は Java 11（Eclipse のデフォルト JRE でも実行可）
- コードは 11 と 17 の両方でコンパイル可能な記述にしています

## 補足
- Maven/Gradle には依存していません。Eclipse のプレーン Java プロジェクトです。
- 例題の ABAP 的な考え方は、example クラスの JavaDoc に記載しています。
