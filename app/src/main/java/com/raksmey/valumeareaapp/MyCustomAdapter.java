package com.raksmey.valumeareaapp;

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


// This class will responsible for creating the view for each item and binding data to it
public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList;
    private final Context context;

    public MyCustomAdapter(ArrayList<Shape> _shapeArrayList, Context context) {
        super(context, R.layout.grid_item_layout, _shapeArrayList);
        this.shapeArrayList = _shapeArrayList;
        this.context = context;
    }


    // view holder: User to cache reference to the views within an item layout
    private static class MyViewHolder {
        private TextView shapeName;
        private ImageView shapeImage;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1 - get shape for the current position
        Shape shape = getItem(position);

        // 2 - inflating the layout:
        MyViewHolder myViewHolder;

        if (convertView == null) {
            // No view went of screen --> create new view
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);

            // find the view
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.id_item_layout_text_view);
            myViewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.id_item_layout_image_view);

            convertView.setTag(myViewHolder);

        } else {
            // a view went off screen --> reuse it
            myViewHolder = (MyViewHolder) convertView.getTag();


        }

        assert shape != null;
        myViewHolder.shapeName.setText(shape.getShapeName());
        myViewHolder.shapeImage.setImageResource(shape.getShapeImage());

        return convertView;
    }
}
