import 'dart:core';
import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:provider/provider.dart';
import 'package:school/models/DocWithStatus.dart';
import 'package:school/providers/school.dart';

class DocumentsPage extends StatefulWidget {
  const DocumentsPage({Key? key}) : super(key: key);

  @override
  _DocumentsPageState createState() => _DocumentsPageState();
}

class _DocumentsPageState extends State<DocumentsPage> {
  var _isLoading = false;
  var _isFirstTime = false;

  List<DocWithStatus> _docsStatus = [];

  List<File?> _pickedImages = [];
  var documentList = [];

  @override
  void didChangeDependencies() {
    // TODO: implement didChangeDependencies
    setState(() {
      _isLoading = true;
    });
    documentList =
        Provider.of<SchoolProvider>(context).selectedSchool.documentsRequired;
    _docsStatus = formStatusList(documentList);

    setState(() {
      _isLoading = false;
    });
    super.didChangeDependencies();
  }

  void _pickImage(String sourceOfImage) async {
    if (sourceOfImage == 'Camera') {
      final pickedImage =
          await ImagePicker().pickImage(source: ImageSource.camera);
      setState(() {
        _pickedImages.add(File(pickedImage!.path));
      });
    } else {
      final pickedImage =
          await ImagePicker().pickImage(source: ImageSource.gallery);
      setState(() {
        _pickedImages.add(File(pickedImage!.path));
      });
    }
  }

  List<DocWithStatus> formStatusList(documentList) {
    List<DocWithStatus> _statusList = [];
    for (var i = 0; i < documentList.length; i++) {
      _statusList.add(DocWithStatus(document: documentList[i], status: 0));
    }
    return _statusList;
  }

  @override
  Widget build(BuildContext context) {
    // var documentList =
    //     Provider.of<SchoolProvider>(context).selectedSchool.documentsRequired;
    // List<DocWithStatus> docsStatus = formStatusList(documentList);
    return Scaffold(
        appBar: AppBar(
          title: Text("Documents"),
        ),
        body: _isLoading
            ? CupertinoActivityIndicator(
                radius: 20.0,
              )
            : ListView.builder(
                itemCount: _docsStatus.length,
                itemBuilder: (context, index) {
                  return ListTile(
                    title: Text(_docsStatus[index].document),
                    trailing: _docsStatus[index].status == 0
                        ? ElevatedButton(
                            child: Text("upload"),
                            onPressed: () {
                              //_pickImage("Camera");
                              setState(() {
                                _docsStatus[index].status = 1;
                              });
                            },
                          )
                        : Icon(
                            Icons.done,
                            color: Colors.green[900],
                          ),
                  );
                },
              ));
  }
}
