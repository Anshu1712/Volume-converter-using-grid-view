package com.example.volumeconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapters extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapesArrayList;
    Context context;

    public MyAdapters(ArrayList<Shape> shapesArrayList, Context context) {
        super(context, R.layout.new_layout, shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }

    //////////////////////////////////////////////////////////////
    private static class ViewHolder {
        TextView shapeName;
        ImageView shapeImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shape = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.new_layout,
                    parent,
                    false
            );
            viewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView2);
            viewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.shapeName.setText(shape.getShapeName());
        viewHolder.shapeImg.setImageResource(shape.getShapeImg());
        return convertView;
    }
}
