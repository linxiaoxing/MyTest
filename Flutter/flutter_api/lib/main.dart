import 'package:flutter/material.dart';
import 'dart:io';
import 'dart:convert';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new MaterialApp(
      home: new MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {

  MyHomePage({Key key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  var _ipAddress = 'Unknown';

  _getIPAdrress() async {
     var url = 'https://httpbin.org/ip';
     var httpClient = new HttpClient();

     String result;
     try {
       var request = await httpClient.getUrl(Uri.parse(url));
       var response = await request.close();
       if (response.statusCode == HttpStatus.OK) {
         var json = await response.transform(utf8.decoder).join();
         var data = jsonDecode(json);
         result = data['origin'];
       } else {
         result =
             "Error getting IP address:\nHttp status ${response.statusCode}";
       }
     } catch (exception) {
       result = 'Failed getting IP address';
     }

     if (!mounted) return;

     setState(() {
       _ipAddress = result;
     });
  }


  @override
  Widget build(BuildContext context) {
    var spacer = new SizedBox(height: 32.0);
    
    return new Scaffold(
      body: new Center(
      child: new Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          new Text('Your current IP address is:'),
          new Text('$_ipAddress.'),
          spacer,
          new RaisedButton(
              onPressed: _getIPAdrress,
              child: new Text('Get IP address'),
          )
        ],
      ),
    ),
    );
  }
}