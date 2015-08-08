#!/usr/bin/python
# coding: utf-8

import json
 
# jsonファイルを読み込む
f = open("NAS_param.json")

# jsonデータを読み込んだファイルオブジェクトからPythonデータを作成
data = json.load(f)

# ファイルを閉じる
f.close()
 
# 普通に表示
#print("普通に表示")
#print(data)

#ファイル数をカウント
num = len(data)
#print(num)
#num_json = num - 1
#print(num_json)

label="help"

if label == "-help":
	print( "sudo ssh {obj[nas]} vol create {obj[volume]} {obj[size]}".format(obj = data[0]) )
else:
	for i in range(num)[1:]:  # 配列の2列目から実行
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
