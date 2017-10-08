package com.idkr.dhavard.foodtinder;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by riksasuviana on 10/09/17.
 */

public class SwipeDeckAdapter extends BaseAdapter {

    private List<String> data;
    private Context context;

    public SwipeDeckAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            // normally use a viewholder
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        }

        ImageView imageView = (ImageView) v.findViewById(R.id.offer_image);
//        Picasso.with(context).load(R.drawable.food).fit().centerCrop().into(imageView);
        imageView.setImageResource(R.mipmap.ic_launcher);
        TextView textView = (TextView) v.findViewById(R.id.sample_text);
        String item = (String)getItem(position);
        textView.setText(item);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));

//                ViewPager viewPager = (ViewPager) v.findViewById(R.id.vp_horizontal_ntb);
//                viewPager.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        return true;
//                    }
//                });
            }
        });
        return v;
    }
}