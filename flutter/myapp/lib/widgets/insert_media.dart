import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:myapp/model/media.dart';
import 'package:intl/intl.dart';
import 'package:myapp/http_service.dart';

class Insert_media extends StatefulWidget {
  @override
  _InsertMediaState createState() => _InsertMediaState();
}

class _InsertMediaState extends State<Insert_media> {
  late int id;
  late String name;
  late String author;
  late String description;
  late String uploadBy;
  late String uploadDate;
  late String type;

  void onSubmit() {
    print("asd123123");
    HttpService().createMedia(Media(
        id: id,
        name: name,
        author: author,
        description: description,
        uploadBy: uploadBy,
        uploadDate: getCurrentDate(),
        type: type));
    // dummyMedia.add(Media(
    //     id: id,
    //     name: name,
    //     author: author,
    //     description: description,
    //     uploadBy: uploadBy,
    //     uploadDate: getCurrentDate(),
    //     type: type));
  }

  void onChangeAuthor(String text) {
    setState(() {
      author = text;
    });
  }

  void onChaneId(String text) {
    setState(() {
      id = int.parse(text);
    });
  }

  void onChaneName(String text) {
    setState(() {
      name = text;
    });
  }

  void onDescription(String text) {
    setState(() {
      description = text;
    });
  }

  void onChangeUploadBy(String text) {
    setState(() {
      uploadBy = text;
    });
  }

  // void onChangeUploadDate(String text) {
  //   setState(() {
  //     uploadDate = text;
  //   });
  // }

  void onChaneType(String text) {
    setState(() {
      type = text;
    });
  }

  // static const String now = DateFormat("yyyy-MM-dd HH:mm:ss").format(DateTime.now());

  String getCurrentDate() {
    return DateFormat("yyyy-MM-dd HH:mm:ss").format(DateTime.now());
  }

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        margin: EdgeInsets.only(top: 10.0, bottom: 5.0),
        padding: EdgeInsets.symmetric(horizontal: 25.0, vertical: 10.0),
        decoration: const BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.only(
            topLeft: Radius.circular(30.0),
            topRight: Radius.circular(30.0),
          ),
        ),
        child: ClipRRect(
          borderRadius: const BorderRadius.only(
            topLeft: Radius.circular(30.0),
            topRight: Radius.circular(30.0),
          ),
          child: Container(
              padding: const EdgeInsets.all(10.0),
              margin: const EdgeInsets.all(10.0),
              alignment: Alignment.center,
              child: ListView(shrinkWrap: true, itemExtent: 70.0,
                  // mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    TextField(
                        keyboardType: TextInputType.number,
                        inputFormatters: <TextInputFormatter>[
                          FilteringTextInputFormatter.digitsOnly
                        ],
                        decoration: const InputDecoration(
                            border: OutlineInputBorder(), hintText: 'Id'),
                        onChanged: (text) {
                          onChaneId(text);
                        }),
                    TextField(
                        decoration: const InputDecoration(
                            border: OutlineInputBorder(), hintText: 'Name'),
                        onChanged: (text) {
                          onChaneName(text);
                        }),
                    TextField(
                        decoration: const InputDecoration(
                            border: OutlineInputBorder(), hintText: 'Author'),
                        onChanged: (text) {
                          onChangeAuthor(text);
                        }),
                    TextField(
                        decoration: const InputDecoration(
                            border: OutlineInputBorder(),
                            hintText: 'Upload By'),
                        onChanged: (text) {
                          onChangeUploadBy(text);
                        }),
                    TextField(
                        decoration: const InputDecoration(
                            border: OutlineInputBorder(),
                            hintText: 'Description'),
                        onChanged: (text) {
                          onDescription(text);
                        }),
                    // Container(
                    //   // height: 5,
                    //   // margin: const EdgeInsets.all(15.0),
                    //   // padding: const EdgeInsets.all(3.0),
                    //   decoration: BoxDecoration(
                    //       border: Border.all(color: Colors.black)),
                    //   child: Text(getCurrentDate()),
                    // ),
                    // Text(
                    //   getCurrentDate(),
                    //   style: const TextStyle(
                    //     color: Colors.grey,
                    //     fontSize: 15.0,
                    //     fontWeight: FontWeight.bold,
                    //   ),
                    // ),
                    // TextField(
                    //   decoration: const InputDecoration(
                    //       border: OutlineInputBorder(), hintText: getCurrentDate() ),
                    //   onChanged: (text) {
                    //     onChangeUploadDate(text);
                    //   },
                    // ),
                    TextField(
                        decoration: const InputDecoration(
                            border: OutlineInputBorder(), hintText: 'type'),
                        onChanged: (text) {
                          onChaneType(text);
                        }),
                    OutlinedButton(
                      onPressed: onSubmit,
                      child: const Icon(Icons.add),
                    ),
                  ])),
        ),
      ),
    );
  }
}





// dummyMedia
