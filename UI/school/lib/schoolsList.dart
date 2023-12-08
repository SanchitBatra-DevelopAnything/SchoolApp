import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:school/models/school.dart';
import 'package:school/providers/school.dart';

class SchoolsList extends StatefulWidget {
  const SchoolsList({Key? key}) : super(key: key);

  @override
  _SchoolsListState createState() => _SchoolsListState();
}

class _SchoolsListState extends State<SchoolsList> {
  var _isLoading = true;
  var _isFirstTime = true;

  @override
  void didChangeDependencies() {
    // TODO: implement didChangeDependencies
    if (_isFirstTime) {
      Provider.of<SchoolProvider>(context, listen: false)
          .fetchSchools()
          .then((value) => {
                setState(
                  () => _isLoading = false,
                )
              });
    }
    _isFirstTime = false;
    super.didChangeDependencies();
  }

  @override
  Widget build(BuildContext context) {
    var schoolList = Provider.of<SchoolProvider>(context).schools;
    return Scaffold(
        appBar: AppBar(title: Text("Schools Near Me")),
        body: _isLoading
            ? Center(
                child: CupertinoActivityIndicator(radius: 20.0),
              )
            : ListView.builder(
                itemCount: schoolList.length,
                itemBuilder: (context, index) {
                  return ListTile(
                    title: Text(schoolList[index].name),
                    subtitle: Text(schoolList[index].address),
                    onTap: () => {
                      Provider.of<SchoolProvider>(context, listen: false)
                          .setSelectedSchool = schoolList[index],
                      Navigator.of(context).pushNamed('/school-detail',
                          arguments: {'schoolObject': schoolList[index]}),
                    },
                  );
                },
              ));
  }
}
