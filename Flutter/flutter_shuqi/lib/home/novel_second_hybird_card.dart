
import 'package:flutter/material.dart';

import 'novel_grid_item.dart';
import 'home_section_view.dart';
import 'home_novel_cover_view.dart';
import 'home_model.dart';

class NovelSecondHybirdCard extends StatelessWidget {
  final HomeModule cardInfo;

  NovelSecondHybirdCard(this.cardInfo);

  @override
  Widget build(BuildContext context) {
    var novels = cardInfo.books;
    if (novels.length < 5) {
      return Container();
    }
    
    var tapNovels = novels.sublist(0, 4);
    List<Widget> children = [];
    tapNovels.forEach((novel) {
      children.add(HomeNovelCoverView(novel));
    });
    
    
    return Container(
      color: Colors.white,
      child: Column(
        children: <Widget>[
          HomeSectionView(cardInfo.name),
          Container(
            padding: EdgeInsets.fromLTRB(15, 10, 15, 10),
            child: Wrap(spacing: 15, runSpacing: 15, children: children),
          ),
          Container(
            height: 10,
            color: Color(0xfff5f5f5),
          )
        ],
      ),
    );
  }

}