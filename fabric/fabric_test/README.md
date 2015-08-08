## test
## これ何？

これはテスト用のディレクトリです。
AmazonLinuxでのmuninの自動構築fabricスクリプトが登録されています。

## munin_construct.py

### 関数

* host_type  
OSの情報を表示する

* yum_update  
yum updateを実行する

* yum_install_munin_server  
muninをインストールする

### 使い方
fab -f munin_construct.py -i (鍵ファイル) ec2-user@(ec2アドレス) (関数)

## 作った人

ftakao2007 Copyright (c) 2013
