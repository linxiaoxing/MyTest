import 'package:flutter/material.dart';
import 'package:flutter/animation.dart';

void main() => runApp(GrowTransition());

class GrowTransition extends StatelessWidget {

  GrowTransition({this.child, this.animation});

  final Widget child;

  final Animation<double> animation;

  Widget build(BuildContext context) {
    return new Center(
      child: new AnimatedBuilder(
          animation: animation,
          builder: (BuildContext context, Widget child) {
            return new Container(
                height: animation.value, width: animation.value, child: child);
          },
          child: child),
    );
  }
}