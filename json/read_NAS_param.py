#!/usr/bin/python
# coding: utf-8

import json # jsonを扱うため
import sys  # モジュール属性 argv を取得するため

argvs = sys.argv  # コマンドライン引数を格納したリストの取得
argc = len(argvs) # 引数の個数

### print(argvs[1])
### print(argc)

f = open("NAS_param.json")  # jsonファイルを読み込む
data = json.load(f)         # jsonデータを読み込んだファイルオブジェクトからPythonデータを作成
f.close()                   # ファイルを閉じる
 
### print(data)             # 普通に表示

num = len(data)             #ファイル数をカウント
#print(num)

### num_json = num - 1
### print(num_json)

if argc == 2 and argvs[1] == "--help":
	print( "sudo ssh {obj[nas]} vol create {obj[volume]} {obj[size]}".format(obj = data[0]) )    # ヘルプを表示

if argc == 1:
	for i in range(num)[1:]:     # 配列の2列目から実行
		print( "sudo ssh {obj[nas]} vol create {obj[volume]} {obj[size]}".format(obj = data[i]) )

# キレイに表示
#print("キレイに表示")
#print(json.dumps(data, sort_keys=True, indent=4))
 
# 中身に直接アクセス
#print("中身に直接アクセス")
#print(data[0]["nas"])
#print(data[0]["volume"])
#print(data[0]["size"])
###print ("sudo rsh " + data[0]["nas"] + "vol create " + data[0]["volume"] + data[0]["size"])

#print( "sudo ssh {obj[nas]} vol create {obj[volume]} {obj[size]}".format(obj = data[0]) )
