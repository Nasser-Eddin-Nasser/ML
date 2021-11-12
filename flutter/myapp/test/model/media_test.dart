import 'package:myapp/model/media.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  test('Media Id is set correctly', () {
    final media = Media(
        id: 1,
        name: "Harry Portter-1",
        author: "J. K. Rowling-1",
        description:
            " Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry.",
        uploadBy: "Novel ",
        uploadDate: "08.11.2021",
        type: "Book");

    expect(media.id, 1);
  });

  test('Check DummyMedia', () {
    final media = Media(
        id: 1,
        name: "Harry Portter-1",
        author: "J. K. Rowling-1",
        description:
            " Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry.",
        uploadBy: "Novel ",
        uploadDate: "08.11.2021",
        type: "Book");
    dummyMedia.add(media);
    expect(dummyMedia.length, 1);
    expect(dummyMedia.length, isNot(equals(2)));
    expect(dummyMedia[0], media);
  });
}
