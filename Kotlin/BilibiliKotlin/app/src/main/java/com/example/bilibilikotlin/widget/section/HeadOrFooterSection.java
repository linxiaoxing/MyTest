package com.example.bilibilikotlin.widget.section;

import com.example.bilibilikotlin.R;

/**
 * 描述:增加头部或者尾部
 */

public class HeadOrFooterSection extends StatelessSection {

    public ViewHolder holder;

    public HeadOrFooterSection(int headerResourceId) {
        super(headerResourceId, R.layout.layout_empty);
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        this.holder = holder;
    }
}