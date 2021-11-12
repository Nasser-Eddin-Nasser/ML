class Media {
  final int id;
  final String name;
  final String author;
  final String description;
  final String uploadBy;
  final String uploadDate;
  final String type;

  Media({
    required this.id,
    required this.name,
    required this.author,
    required this.description,
    required this.uploadBy,
    required this.uploadDate,
    required this.type,
  });

  factory Media.fromJson(Map<String, dynamic> json) {
    return Media(
        id: json['id'] as int,
        name: json['name'] as String,
        author: json['author'] as String,
        description: json['description'] as String,
        uploadBy: json['uploadBy'] as String,
        uploadDate: json['uploadDate'] as String,
        type: json['type'] as String);
  }

  Map<String, dynamic> toJson() {
    return {
      "author": author,
      "description": description,
      "id": id,
      "name": name,
      "type": type,
      "uploadBy": uploadBy,
      "uploadDate": uploadDate
    };
  }
}

List<Media> dummyMedia = []; //used for testing
