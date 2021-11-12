import 'dart:convert';

import 'package:myapp/model/media.dart';
import 'package:http/http.dart';

class HttpService {
  final String serverUrl = "http://localhost:8080/media";

  void createMedia(Media media) async {
    // ignore: avoid_print
    print(media.type);
    print("media.type");
    await post(
      Uri.parse(serverUrl),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(media),
    );
  }

  Future<List<Media>> getAllMedia() async {
    Response res = await get(serverUrl);
    List<Media> medias = [];
    if (res.statusCode != 400) {
      List<dynamic> body = jsonDecode(res.body);
      medias = body.map((e) => Media.fromJson(e)).toList();
    } else {
      throw Exception('Failed to load album');
    }
    return medias;
  }
}
