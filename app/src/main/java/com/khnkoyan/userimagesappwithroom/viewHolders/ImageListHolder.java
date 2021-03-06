package com.khnkoyan.userimagesappwithroom.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.khnkoyan.userimagesappwithroom.R;

public class ImageListHolder extends RecyclerView.ViewHolder {
    private ImageView imgItemWithCheckbox;
    private CheckBox chBoxItem;

    public ImageListHolder(View itemView) {
        super(itemView);

        this.imgItemWithCheckbox = (ImageView) itemView.findViewById(R.id.imgItemWithCheckbox);
        this.chBoxItem = (CheckBox) itemView.findViewById(R.id.chBoxItem);
    }

    public ImageView getImgItemWithCheckbox() {
        return imgItemWithCheckbox;
    }

    public CheckBox getChBoxItem() {
        return chBoxItem;
    }

}
