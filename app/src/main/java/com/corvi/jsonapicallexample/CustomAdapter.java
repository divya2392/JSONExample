package com.corvi.jsonapicallexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by divya on 19/04/17.
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<Model> models;
    Context context;

    public CustomAdapter(ArrayList<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linearLayout = null;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            linearLayout = (LinearLayout) inflater.inflate(R.layout.custom_list_view,null);

        }else
        {
            linearLayout = (LinearLayout)convertView;
        }

        TextView info = (TextView)linearLayout.findViewById(R.id.textView);
        info.setText(models.get(position).toString());
        return linearLayout;
    }
}
