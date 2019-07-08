import 'package:flutter/material.dart';
import 'package:flutter_zhihu/home/question_page.dart';
import 'package:flutter_zhihu/home/hot.dart';
import 'package:flutter_zhihu/home/reply_page.dart';
import 'package:flutter_zhihu/home/recommend.dart';
import 'package:flutter_zhihu/home/home_page.dart';
import 'package:flutter_zhihu/index/index.dart';

void main() => runApp(new ZhiHu());

class ZhiHu extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "知乎-高仿版",
      home: new Index(),
    );
  }

}
