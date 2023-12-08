import 'package:flutter/material.dart';
import 'package:school/bulletPoint.dart';

class SchoolDetails extends StatelessWidget {
  const SchoolDetails({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final schoolObject =
        ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>;
    return Scaffold(
      appBar: AppBar(title: Text("Details")),
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                "Basic Details",
                style: TextStyle(fontSize: 18),
              ),
              SizedBox(
                height: 20,
              ),
              Text("Name : ${schoolObject['schoolObject'].name}"),
              SizedBox(
                height: 10,
              ),
              Text("Address : ${schoolObject['schoolObject'].address}"),
              SizedBox(
                height: 10,
              ),
              Text("Website :${schoolObject['schoolObject'].website}"),
              SizedBox(
                height: 10,
              ),
              Divider(),
              Text(
                "Eligibility Criteria",
                style: TextStyle(fontSize: 18),
              ),
              SizedBox(
                height: 10,
              ),
              Container(
                height: 150,
                child: Expanded(
                  flex: 2,
                  child: ListView.builder(
                    itemCount:
                        schoolObject['schoolObject'].eligibilityCriteria.length,
                    itemBuilder: (context, index) {
                      return ListTile(
                        leading: Bullet(),
                        title: Text(schoolObject['schoolObject']
                            .eligibilityCriteria[index]),
                      );
                    },
                  ),
                ),
              ),
              Divider(),
              Text(
                "Documents Required",
                style: TextStyle(fontSize: 18),
              ),
              Container(
                child: Expanded(
                  flex: 5,
                  child: ListView.builder(
                    itemCount:
                        schoolObject['schoolObject'].documentsRequired.length,
                    itemBuilder: (context, index) {
                      return ListTile(
                        leading: Bullet(),
                        title: Text(schoolObject['schoolObject']
                            .documentsRequired[index]),
                      );
                    },
                  ),
                ),
              ),
              Divider(),
              Expanded(
                flex: 1,
                child: ElevatedButton(
                    onPressed: () => {
                          Navigator.of(context).pushNamed('/upload-documents'),
                        },
                    child: Text(
                      "Upload Documents",
                      style: TextStyle(color: Colors.white),
                    )),
              )
            ],
          ),
        ),
      ),
    );
  }
}
