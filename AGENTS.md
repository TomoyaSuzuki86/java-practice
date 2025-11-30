# AGENT: Java practice project for SAP ABAP engineer

このリポジトリの目的は、SAP の ABAP エンジニアが「模写＋実行」で Java と Eclipse の基本を体得することです。例題を模写して実行し、少しずつ成功体験を積める構成にします。

## ゴールと方針

- ABAP で日常的に行う処理（テーブル集計・フィルタ・コード値変換など）を Java で書き直す練習問題を用意。
- 例題（模範解答）を`practice` 側に同じコードを実装し、`main` を実行して動作確認できること。
- 難易度の目安
  - 基礎編: Java Bronze（文法・制御構文・配列・基本クラス）
  - 中級編: Java Silver（クラス設計・例外・コレクション・簡単な OOP）
  - 上級編: Java Gold（実務寄り設計・インターフェース・ポリモーフィズム・Stream API など）

## 技術スタックと前提

- 言語: Java 11 〜 17 でコンパイル可能な書き方
- ツール: Eclipse（追加プラグイン不要）
- ビルド: Maven/Gradle には依存せず、Eclipse のプレーン Java プロジェクト
- ディレクトリ:
  - `src/main/java` 配下に `example`（模範解答）と `practice`（練習）

## ディレクトリ構成

```
java-practice/
  AGENTS.md
  .project
  .classpath
  .settings/
    org.eclipse.jdt.core.prefs
  src/
    main/
      java/
        example/
          level1_01/
        practice/
          level1_01/
```

## 作業ルール（AGENTS 向け）

- このファイルのスコープはリポジトリ全体です。
- コードは Java 11 互換を優先（var/records 等の 14+ 特有機能は避ける）。
- Eclipse プロジェクトとして動くことを最優先（`.project`/`.classpath` を維持）。
- 例題は `example/...` に「動く完成コード」を置く。
- 練習は `practice/...` に「mainメソッドの宣言」と、「コメントでのtips」を置く。tipsには、eclipseでの便利なショートカットキーや、勉強が楽しく取り組めるような文章を工夫して記載すること
- 各課題は `main` を実行するだけで結果が確認できること。
- 命名・スタイル
  - 1 ファイル 1 public クラス。クラス名は PascalCase。
  - 1 文字変数は避け、意味のある名前を使う。
  - コメントは学習者（ABAP エンジニア）向けに日本語で補足。
  - 模範解答側は、ABAPだったらどのような実装になるのかをjavaDocに記述すること

## 拡張指針

- level2_xx（Silver）、level3_xx（Gold）を段階的に追加可能。
- 既存例題に干渉しない範囲で、practice 側の TODO やtipsを増やして良い。

## 実行方法（学習者向け要約）

1. Eclipse で「既存プロジェクトをワークスペースへ」から `java-practice` をインポート。
2. `example/...` の任意クラスを右クリック → Run As → Java Application。
3. コードを `practice/...` へコピー。差分（TODO）を埋めて再度実行。
