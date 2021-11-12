import 'package:flutter/material.dart';
import 'package:myapp/overwie.dart';

void main() => runApp(MyApp());
// class MyApp extends StatelessWidget {
//   const MyApp({Key? key}) : super(key: key);

//   // This widget is the root of your application.
//   // @override
//   // Widget build(BuildContext context) {
//   //   return MaterialApp(
//   //     title: 'Media Insider',
//   //     theme: ThemeData(
//   //       primarySwatch: Colors.blueGrey,
//   //     ),
//   //     // home: const MyHomePage(title: 'Media Insider'),
//   //   );
//   // }
// }

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Media Insider',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primaryColor: Colors.blueGrey[800],
        accentColor: Color(0xFFFEF9EB),
      ),
      home: Overview(),
    );
  }

  // const MyApp({Key? key, required this.title}) : super(key: key);

  // final String title;

  // int _counter = 0;
  // String name = "tee";

  // // String get text => name;

  // void _incrementCounter() {
  //   setState(() {
  //     _counter++;
  //   });
  // }

  // void changeName() {
  //   setState(() {
  //     name = "tee1";
  //   });
  // }

  // void onChaneName(String vv) {
  //   setState(() {
  //     name = vv;
  //   });
  // }

  // @override
  // Widget build(BuildContext context) {
  //   return Scaffold(
  //     appBar: AppBar(
  //       title: Text(widget.title),
  //     ),
  //     body: Container(
  //         // alignment: Alignment.centerRight,
  //         width: 500.0,
  //         padding: const EdgeInsets.all(0.0),
  //         alignment: Alignment.center,
  //         child: Column(
  //           mainAxisAlignment: MainAxisAlignment.start,
  //           mainAxisSize: MainAxisSize.max,
  //           crossAxisAlignment: CrossAxisAlignment.center,
  //           children: <Widget>[
  //             const Text(
  //               'You have pushed the button this many times:',
  //             ),
  //             Text(
  //               '$_counter',
  //               style: Theme.of(context).textTheme.headline4,
  //             ),
  //             Text('$_counter'),
  //             Text(name),
  //             const Icon(Icons.insert_emoticon,
  //                 color: Colors.green, size: 48.0),
  //             TextField(
  //                 decoration: const InputDecoration(
  //                     border: OutlineInputBorder(),
  //                     hintText: 'Enter a search term'),
  //                 onChanged: (vv) {
  //                   onChaneName(vv);
  //                 }),
  //             OutlinedButton(
  //               onPressed: changeName,
  //               child: const Icon(Icons.change_circle),
  //             ),
  //           ],
  //         )),
  //     floatingActionButton: FloatingActionButton(
  //       onPressed: _incrementCounter,
  //       tooltip: 'Increment',
  //       child: const Icon(Icons.add),
  //     ), // This trailing comma makes auto-formatting nicer for build methods.
  //   );
  // }
}
