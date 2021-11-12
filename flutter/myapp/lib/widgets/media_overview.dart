import 'package:flutter/material.dart';
import 'package:myapp/model/media.dart';
import 'package:myapp/http_service.dart';

import 'detail_page.dart';

class Media_list extends StatefulWidget {
  @override
  _Media_listState createState() => _Media_listState();
}

class _Media_listState extends State<Media_list> {
  late Future mediaList;

  @override
  void initState() {
    super.initState();
    mediaList = HttpService().getAllMedia();
  }

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
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
          child: futuerMedia(),
        ),
      ),
    );
  }

  Widget futuerMedia() {
    return FutureBuilder(
      future: HttpService().getAllMedia(),
      builder: (BuildContext context, AsyncSnapshot snapshot) {
        // print(snapshot.data);
        if (snapshot.data == null) {
          return const Center(child: Text("Loading..."));
        } else {
          return ListView.builder(
            itemCount: snapshot.data.length,
            itemBuilder: (BuildContext context, int index) {
              Media mediaItem = snapshot.data[index];
              return InkWell(
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => Detail_page(mediaItem)));
                },
                child: Container(
                  margin: const EdgeInsets.only(top: 5.0, bottom: 5.0),
                  padding: const EdgeInsets.symmetric(
                      horizontal: 20.0, vertical: 10.0),
                  decoration: const BoxDecoration(
                    borderRadius: BorderRadius.only(
                      topRight: Radius.circular(20.0),
                      bottomRight: Radius.circular(20.0),
                    ),
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: <Widget>[
                      Row(
                        children: <Widget>[
                          Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: <Widget>[
                              Text(
                                mediaItem.name,
                                style: const TextStyle(
                                  color: Colors.grey,
                                  fontSize: 15.0,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                              const SizedBox(height: 5.0),
                              Container(
                                width: MediaQuery.of(context).size.width * 0.2,
                                child: Text(
                                  mediaItem.description,
                                  style: const TextStyle(
                                    color: Colors.blueGrey,
                                    fontSize: 10.0,
                                    fontWeight: FontWeight.w600,
                                  ),
                                  overflow: TextOverflow.ellipsis,
                                ),
                              ),
                            ],
                          ),
                        ],
                      ),
                      Column(
                        children: <Widget>[
                          Text(
                            mediaItem.uploadDate,
                            style: const TextStyle(
                              color: Colors.grey,
                              fontSize: 15.0,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          Text(
                            mediaItem.uploadBy,
                            style: const TextStyle(
                              color: Colors.grey,
                              fontSize: 15.0,
                              fontWeight: FontWeight.w600,
                            ),
                          ),
                        ],
                      ),
                    ],
                    // onTap: () {
                    //   Navigator.push(
                    //       context,
                    //       new MaterialPageRoute(
                    //           builder: (context) =>
                    //               DetailPage(snapshot.data[index])));
                    // },
                  ),
                ),
              );
            },
          );
        }
      },
    );
  }
}
