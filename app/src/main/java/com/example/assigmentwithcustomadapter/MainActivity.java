package com.example.assigmentwithcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] name = {"দুর্দান্ত চট্টগ্রামে চাপা পড়ল খুলনাও প্রকাশ: ২৪ জানুয়ারি ২০২২, ২১: ৪৮", "রাতের শিশিরেও সাকিবদের দিন দেখাল কুমিল্লা প্রকাশ: ২৫ জানুয়ারি ২০২২, ২১: ৫৩", "মিতব্যয়ী বোলিংয়ে আফ্রিদির রেকর্ড ছুঁলেন নাহিদুল প্রকাশ: ২৫ জানুয়ারি ২০২২, ২১: ০৯"};
    Integer[] imgID = {R.drawable.bater, R.drawable.injury, R.drawable.mtm};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);

        CustomAdater ca = new CustomAdater(MainActivity.this, name, imgID);
        lv.setAdapter((ListAdapter) ca);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int imv = imgID[position];
                String nm = name[position];

                Intent ii = new Intent(getApplicationContext(),CustomAdater.class);

                ii.putExtra("img", imv);
                ii.putExtra("nme", nm);

                startActivity(ii);
                //------------
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), bater.class);
                    // startActivity(myIntent);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Bater2.class);
                   //startActivityForResult(myIntent, 0);
                    startActivity(myIntent);
                }

               if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Bater3.class);


                    startActivityForResult(myIntent, 0);
                }


            }
     });

    }
}