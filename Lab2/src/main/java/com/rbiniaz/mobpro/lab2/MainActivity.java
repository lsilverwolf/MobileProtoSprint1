package com.rbiniaz.mobpro.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
                goToVirtualReality(true);
            }
        });

        usePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVirtualReality(true);
            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVirtualReality(false);
            }
        });


    }


    public void goToVirtualReality(boolean useList){
        Intent i = new Intent(this, VirtualRealityActivity.class);
        i.putExtra("useList", useList);
        startActivityForResult(i, 0);
    }

}
