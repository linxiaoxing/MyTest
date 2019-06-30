import 'package:flutter/material.dart';
import 'package:carousel_slider/carousel_slider.dart';

import 'package:flutter_shuqi/public.dart';
import 'home_model.dart';

class HomeBanner extends StatelessWidget {
  final List<CarouselInfo> carouselInfo;

  HomeBanner(this.carouselInfo);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    if (carouselInfo.length == 0) {
      return SizedBox();
    }

    return Container(
      color: Colors.white,
      child: CarouselSlider(
        items: carouselInfo.map((info) {
          return Builder(
             builder: (BuildContext context) {
               return Container(
                 width: Screen.width,
                 margin: EdgeInsets.symmetric(horizontal: 5.0),
                 child: Image.network(
                    info.imageUrl ?? '',
                    fit: BoxFit.cover,
                 ),
               );
             }
          );
      }).toList(),
        aspectRatio: 2,
        autoPlay: true,
      ),
    );
  }
}