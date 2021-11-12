import 'package:flutter/material.dart';
import 'package:myapp/insert.dart';
import '../overwie.dart';

class MySelector extends StatefulWidget {
  final int selectedIndex;
  const MySelector(this.selectedIndex);

  @override
  _MySelectorState createState() => _MySelectorState();
}

class _MySelectorState extends State<MySelector> {
  final List<String> categories = ['Media', 'Insert'];

  @override
  Widget build(BuildContext context) {
    int selectedIndex = widget.selectedIndex;
    return Container(
      height: 90.0,
      color: Theme.of(context).primaryColor,
      child: ListView.builder(
        scrollDirection: Axis.horizontal,
        itemCount: categories.length,
        itemBuilder: (BuildContext context, int index) {
          return GestureDetector(
            onTap: () {
              setState(() {
                selectedIndex = index;
              });
              if (selectedIndex == 1) {
                Navigator.of(context).pushReplacement(
                    MaterialPageRoute(builder: (context) => Insert()));
              } else {
                Navigator.of(context).pushReplacement(
                    MaterialPageRoute(builder: (context) => Overview()));
              }
            },
            child: Padding(
              padding: const EdgeInsets.symmetric(
                horizontal: 20.0,
                vertical: 30.0,
              ),
              child: Text(
                categories[index],
                style: TextStyle(
                  color: index == selectedIndex ? Colors.white : Colors.white60,
                  fontSize: 24.0,
                  fontWeight: FontWeight.bold,
                  letterSpacing: 1.2,
                ),
              ),
            ),
          );
        },
      ),
    );
  }
}
