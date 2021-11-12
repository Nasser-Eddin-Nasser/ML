import 'package:flutter/material.dart';
import 'package:myapp/model/media.dart';

class Detail_page extends StatelessWidget {
  late final Media media;

  Detail_page(Media mediaItem) {
    media = mediaItem;
  }

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Scaffold(
        appBar: AppBar(
          title: Text(media.name),
        ),
        backgroundColor: Theme.of(context).primaryColor,
        body: Container(
          // color: Colors.red,
          margin: EdgeInsets.only(top: 10.0, bottom: 5.0),
          padding: EdgeInsets.symmetric(horizontal: 25.0, vertical: 10.0),
          decoration: const BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.only(
              topLeft: Radius.circular(30.0),
              topRight: Radius.circular(30.0),
            ),
          ),
          alignment: Alignment.center,
          child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: <Widget>[
                Column(children: <Widget>[
                  Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: <Widget>[
                        Text(
                          media.id.toString(),
                          textScaleFactor: 1.2,
                        ),
                        Text(
                          media.author,
                          textScaleFactor: 1.2,
                        ),
                        Text(
                          media.type,
                          textScaleFactor: 1.2,
                        ),
                      ]),
                ]),
                Column(children: <Widget>[
                  Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: <Widget>[
                        Flexible(
                            child: Text(
                          media.name,
                          textScaleFactor: 1.2,
                        )),
                        Flexible(
                          child: Text(
                            media.uploadBy,
                            textScaleFactor: 1.2,
                          ),
                        ),
                        Flexible(
                          child: Text(
                            media.uploadDate,
                            textScaleFactor: 1.2,
                          ),
                        ),
                      ]),
                ]),
                Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: <Widget>[
                      Flexible(
                        child: Text(
                          media.description,
                        ),
                      ),
                    ]),
              ]),
        ),
      ),
    );
  }
}
