## 電子掲示板
![screen.png]

#### テーブルの作成
このWebアプリはMySQLを使用していますので、以下のSQLを実行して事前にテーブルを作成してください。
```
CREATE TABLE data (
	id				INT UNSIGNED	NOT NULL AUTO_INCREMENT,
	handle_name		VARCHAR(16),
	email			VARCHAR(256),
	contents		TEXT,
	create_time		DATETIME,
    PRIMARY KEY (`id`)
);
```
また、適宜application.propertiesを修正してください。
