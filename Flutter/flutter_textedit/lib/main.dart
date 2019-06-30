import 'package:flutter/material.dart';

void main() => runApp(
    new MaterialApp(
      title: 'Flutter Demo',
      theme: new ThemeData(primarySwatch: Colors.blue),
      home: new ExampleWidget(),
    ),
    );

class ExampleWidget extends StatefulWidget {
  //ExampleWidget({Key key}) : super(key: key);

  @override
  _ExampleWidgetState createState() => new _ExampleWidgetState();
}

class _ExampleWidgetState extends State<ExampleWidget> {
  final TextEditingController _controller = new TextEditingController();

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        new TextField(
          controller: _controller,
          decoration: new InputDecoration(
            hintText: 'Type something',
          ),
        ),
        new RaisedButton(
            onPressed: () {
              showDialog(
                  context: context,
                child: new AlertDialog(
                  title: new Text('What you typed'),
                  content: new Text(_controller.text),
                )
              );
            },
            child: new Text('DONE'),
        ),
      ],
    );
  }
}