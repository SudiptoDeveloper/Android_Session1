package com.example.assigmentwithcustomadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdater extends BaseAdapter {
    public CustomAdater(Activity context, String[] name, Integer[] imgID) {
        this.context = context;
        this.name = name;
        this.imgID = imgID;
    }

    private final Activity context;
    private final String[] name;
    private final Integer[] imgID;

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View rv, ViewGroup viewGroup) {

      ViewHolder vH;
      if (rv == null) {

          rv = LayoutInflater.from(context).inflate(R.layout.custom_adapter,null,false);

          vH = new ViewHolder(rv);

          rv.setTag(vH);
      }

      else {
          vH = (ViewHolder) rv.getTag();
      }
      vH.textView.setText(name[i]);
      vH.imageView.setImageResource(imgID[i]);


          return rv;
      }
      //View Holder
      private  class ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){

            textView = view.findViewById(R.id.tv1);
            imageView = view.findViewById(R.id.iv1);

        }

      }
    }

