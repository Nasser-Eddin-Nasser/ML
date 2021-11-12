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
  late String type = "Unknown";
  void onSubmit() {
    HttpService().createMedia(Media(
        id: id,
        name: name,
        author: author,
        description: description,
        uploadBy: uploadBy,
        uploadDate: getCurrentDate(),
        type: type));
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

  void onChaneType(String text) {
    print(text);
    setState(() {
      type = text;
    });
  }

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
              child: ListView(
                  shrinkWrap: true,
                  itemExtent: 70.0,
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
                    // DropdownButton<String>(
                    //   value: _chosenValue,
                    //   //elevation: 5,
                    //   style: const TextStyle(color: Colors.black),

                    //   items: <String>[
                    //     'Android',
                    //     'IOS',
                    //     'Flutter',
                    //     'Node',
                    //     'Java',
                    //     'Python',
                    //     'PHP',
                    //   ].map<DropdownMenuItem<String>>((String value) {
                    //     return DropdownMenuItem<String>(
                    //       value: value,
                    //       child: Text(value),
                    //     );
                    //   }).toList(),
                    //   hint: const Text(
                    //     "Please choose a langauage",
                    //     style: TextStyle(
                    //         color: Colors.black,
                    //         fontSize: 16,
                    //         fontWeight: FontWeight.w600),
                    //   ),
                    // ),
//
                    DropdownButtonHideUnderline(
                      child: DropdownButton<String>(
                        hint: const Text("Select Type"),
                        value: type,
                        isDense: true,
                        onChanged: (newValue) {
                          assert(newValue != null);
                          onChaneType(newValue!);
                        },
                        items: <String>['CD', 'DVD', 'Book', 'EBook', 'Unknown']
                            .map((String value) {
                          return DropdownMenuItem<String>(
                            value: value,
                            child: Text(value),
                          );
                        }).toList(),
                      ),
                    ),
                    // TextField(
                    //     decoration: const InputDecoration(
                    //         border: OutlineInputBorder(), hintText: 'type'),
                    //     onChanged: (text) {
                    //       onChaneType(text);
                    //     }),
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
