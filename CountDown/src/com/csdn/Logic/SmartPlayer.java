package com.csdn.Logic;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SmartPlayer extends Activity {

    private long[] longs = {0, 0, 15, 0};
    private List<Object> list;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adpater.notifyDataSetChanged();
            mHandler.sendEmptyMessageDelayed(1, 10);
        }

        ;
    };
    private MyAdpater adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smartplayer_activity);

        list = new ArrayList<Object>();
      /*
        list.add(new Timebean("20161107151701")); // 这是2015年10月20日15时 17分 01秒
        list.add(new Timebean("20161107151800"));
        list.add(new Timebean("20161107151900"));
        list.add(new Timebean("20161107120300"));
        list.add(new Timebean("20161107120400"));
        list.add(new Timebean("20161107120500"));
        list.add(new Timebean("20161107120600"));
        list.add(new Timebean("20161107120700"));*/

        ListView gv = (ListView) findViewById(R.id.lste);
        adpater = new MyAdpater();
        gv.setAdapter(adpater);
        mHandler.sendEmptyMessageDelayed(1, 1);

    }

    class MyAdpater extends BaseAdapter {

        public int getCount() {
            // TODO Auto-generated method stub
            return 10;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(SmartPlayer.this).inflate(
                        R.layout.time_itme, null);
                viewHolder.txt = (TimeView) convertView.findViewById(R.id.iese);
                convertView.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) convertView.getTag();


            viewHolder.txt.setTime(30);
           // viewHolder.txt.reStart();
          //  viewHolder.txt.setPool(100);
           // viewHolder.txt.beginRun();
            return convertView;
        }

        class ViewHolder {
            TimeView txt;
        }

    }


}
