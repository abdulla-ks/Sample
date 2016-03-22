package com.experion.samplelibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 22-03-2016.
 */
public class DashboardActivity extends RelativeLayout {

    public DashboardActivity(Context context) {
        super(context);

    }

    public DashboardActivity(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    private static View initialize(Context context, ViewGroup group) {
        View view = inflate(context, R.layout.activity_dashboard, group);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        List list = new ArrayList();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        listView.setAdapter(new CustomAdapter(context, list));

        return view;
    }

    public static void showDashBoard(Context context) {
        new AlertDialog.Builder(context).setView(initialize(context, new DashboardActivity(context))).show();
    }

    static class CustomAdapter extends BaseAdapter {
        Context context;
        List list;

        public CustomAdapter(Context context, List list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ViewHolder viewholder;

            if (convertView == null) {

                convertView = inflater.inflate(R.layout.list_item, null);

                viewholder = new ViewHolder();


                convertView.setTag(viewholder);

            } else {

                viewholder = (ViewHolder) convertView.getTag();
            }


            // viewholder.img.setImageBitmap(BitmapFactory.decodeFile(itm.getImg(),
            // options));

            return convertView;
        }

        class ViewHolder {
            Button btn;
            TextView txt;
        }
    }
}