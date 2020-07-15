package com.example.zalandoapp.ui.TabbedFragments.offerDetails;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private List<Integer> mThumbIds;
    private Context context;

    public ImageAdapter(List<Integer> mThumbIds, Context context) {
        this.mThumbIds = mThumbIds;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView= (ImageView) convertView;

        if (imageView==null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300,450));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageView.setImageResource(mThumbIds.get(position));

        return imageView;
    }
}
