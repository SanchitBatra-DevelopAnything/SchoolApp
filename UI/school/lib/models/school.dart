class School {
  final String id;
  final String name;
  final String website;
  final String location_longitude;
  final String location_latitude;
  final String address;
  final List<dynamic> eligibilityCriteria;
  final List<dynamic> documentsRequired;

  School(
      {required this.id,
      required this.eligibilityCriteria,
      required this.documentsRequired,
      required this.name,
      required this.website,
      required this.location_latitude,
      required this.address,
      required this.location_longitude});
}
