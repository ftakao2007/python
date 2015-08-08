#!/usr/bin/python
# coding: utf-8
# json モジュールを使ってみる
 
# json モジュールをインポート
import json
 
# jsonファイルを読み込む
f = open("sample.json")
# jsonデータを読み込んだファイルオブジェクトからPythonデータを作成
data = json.load(f)
# ファイルを閉じる
f.close()
 
# 普通に表示
print("普通に表示")
print(data)
 
# キレイに表示
print("キレイに表示")
print(json.dumps(data, sort_keys=True, indent=4))
 
# 中身に直接アクセス
print("中身に直接アクセス")
print(data[0]["name"])
print(data[0]["appearedIn"])
print( "Name : {obj[name]}, appearedIn : {obj[appearedIn]}".format(obj = data[0]) )
#print( "influencedBy", ", ".join(data[0]["influencedBy"]) 
