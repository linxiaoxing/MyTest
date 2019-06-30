import 'package:flutter/material.dart';
import 'package:path_provider/path_provider.dart';
import 'dart:io';

void main() => runApp(
    new MaterialApp(
       title: 'Flutter IO Demo',
       theme: new ThemeData(primarySwatch: Colors.blue),
       home: new FlutterDemo(),
    ));

class FlutterDemo extends StatefulWidget {

  FlutterDemo({Key key}) : super(key: key);

  @override
  _FlutterDemoState createState() => new _FlutterDemoState();
}

class _FlutterDemoState extends State<FlutterDemo> {

  int _counter;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _readCounter().then((int value) {
      setState(() {
       // setState(() {
          _counter = value;

      });
    });
  }

  Future<File> _getLocalFile() async {
    String dir = (await getApplicationDocumentsDirectory()).path;
    return new File('$dir/counter.txt');
  }
  
  Future<int> _readCounter() async {
    try {
      File file = await _getLocalFile();

      String contents = await file.readAsString();
      return int.parse(contents);
    } on FileSystemException {
      return 0;
    }
  }

  Future<Null> _incrementCounter() async {
    setState(() {
      _counter++;
    });
    await (await _getLocalFile()).writeAsString('$_counter');
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Scaffold(
      appBar: new AppBar(title: new Text('Flutter Demo')),
      body: new Center(
        child: new Text('Button tapped $_counter time ${
    _counter == 1 ? '' : 's'
    }.'),
      ),
      floatingActionButton: new FloatingActionButton(
          onPressed: _incrementCounter,
          tooltip: 'Increment',
          child: new Icon(Icons.add),
      ),
    );
  }
}
