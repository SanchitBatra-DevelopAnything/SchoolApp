import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

import '../models/school.dart';

class SchoolProvider with ChangeNotifier {
  List<School> _schoolList = [];
  List<School> get schools {
    return [..._schoolList];
  }

  List<School> _selectedSchools = [];

  School get selectedSchool {
    return _selectedSchools[0];
  }

  set setSelectedSchool(School s) {
    _selectedSchools = [];
    _selectedSchools.add(s);
    notifyListeners();
  }

  Future<void> fetchSchools() async {
    const url =
        "https://schoolsapp-61838-default-rtdb.firebaseio.com/schools.json";
    try {
      final response = await http.get(Uri.parse(url));
      final List<School> loadedSchools = [];
      final extractedData = json.decode(response.body) as Map<String, dynamic>;
      extractedData.forEach((schoolId, schoolData) {
        loadedSchools.add(School(
            id: schoolId,
            address: schoolData['address'],
            eligibilityCriteria: schoolData['eligibilityCriteria'],
            documentsRequired: schoolData['documentsRequired'],
            name: schoolData['name'],
            website: schoolData['website'],
            location_latitude: schoolData['location_latitude'],
            location_longitude: schoolData['location_longitude']));
      });
      _schoolList = loadedSchools;
      notifyListeners();
    } catch (error) {
      throw error;
    }
  }

  // setSelectedSchool(School schoolList) {}
}
