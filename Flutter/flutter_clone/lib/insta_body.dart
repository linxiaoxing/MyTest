import 'package:flutter/material.dart';
import 'package:flutter_clone/insta_list.dart';
import 'package:flutter_clone/insta_stories.dart';

class InstaBody extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return new Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: <Widget>[
        Flexible(child: InstaList())
      ],
    );
  }
}