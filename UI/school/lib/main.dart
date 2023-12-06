import 'dart:io';

import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:school/providers/school.dart';
import 'package:school/schoolsList.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(providers: [
      ChangeNotifierProvider(create: (context) => SchoolProvider()),
    ], child: MaterialAppWithInitialRoute());
  }
}

class MyHttpOverrides extends HttpOverrides {
  @override
  HttpClient createHttpClient(SecurityContext? context) {
    return super.createHttpClient(context)
      ..badCertificateCallback =
          (X509Certificate cert, String host, int port) => true;
  }
}

class MaterialAppWithInitialRoute extends StatelessWidget {
  const MaterialAppWithInitialRoute({Key? key}) : super(key: key);

  Future<String> getInitialRoute() async {
    return '/';
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: getInitialRoute(),
      builder: ((context, snapshot) {
        if (snapshot.connectionState == ConnectionState.done) {
          if (snapshot.hasData) {
            print(snapshot.data);
            return MaterialApp(
              debugShowCheckedModeBanner: false,
              title: 'School App',
              theme: ThemeData(primarySwatch: Colors.blue),
              initialRoute: snapshot.data.toString(),
              routes: {
                '/': (context) => SchoolsList(),
              },
            );
          } else {
            print("idhar aaya");
            return MaterialApp(
              debugShowCheckedModeBanner: false,
              title: 'Kidys Distributor',
              theme: ThemeData(primarySwatch: Colors.blue),
              initialRoute: '/',
              routes: {
                '/': (context) => SchoolsList(),
              },
            );
          }
        } else {
          return CircularProgressIndicator();
        }
      }),
    );
  }
}

class SharedPreferences {}
