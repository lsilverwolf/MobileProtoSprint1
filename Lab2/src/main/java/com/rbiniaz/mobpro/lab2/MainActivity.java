package com.rbiniaz.mobpro.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.photo_list);

        final ImageView imgView;
        imgView = (ImageView) findViewById(R.id.listImageView);
        imgView.setImageResource(R.drawable.shoplist);

        Button takePhoto = (Button) findViewById(R.id.CaptureButton);
        Button usePrevious = (Button) findViewById(R.id.PreviousListButton);
        Button showAll = (Button) findViewById(R.id.AllWICButton);

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVirtualReality(view);
            }
        });

        usePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVirtualReality(view);
            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVirtualReality(view);
            }
        });


    }


    public void goToVirtualReality(View view){
        Intent i = new Intent(this, VirtualRealityActivity.class);
        startActivity(i);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
