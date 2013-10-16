package com.rbiniaz.mobpro.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by wolflyra on 10/15/13.
 */
public class VirtualRealityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.virtual_reality);
        final ImageView imgView;
        imgView = (ImageView) findViewById(R.id.virtualRealityView);
        imgView.setImageResource(R.drawable.list_beans);



        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView.setImageResource(R.drawable.list_cannedveg);
                imgView.setImageResource(R.drawable.list_eggs);
            }
        });
}
}
