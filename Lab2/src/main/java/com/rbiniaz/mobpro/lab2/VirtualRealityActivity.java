package com.rbiniaz.mobpro.lab2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by wolflyra on 10/15/13.
 */
public class VirtualRealityActivity extends Activity {
    boolean useList;
    boolean listAvailable;
    ImageView imgView;
    int currentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        useList = intent.getBooleanExtra("useList", false);
        listAvailable = useList;
        setContentView(R.layout.virtual_reality);

        imgView = (ImageView) findViewById(R.id.virtualRealityView);
        imgView.setImageResource(R.drawable.list_beans);
        currentImage = R.drawable.list_beans;

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cycleImage();
            }
        });
    }

    private void cycleImage() {
        switch (currentImage){
            case R.drawable.list_beans:
                imgView.setImageResource(R.drawable.list_cannedveg);
                currentImage = R.drawable.list_cannedveg;
                break;
            case R.drawable.list_cannedveg:
                imgView.setImageResource(R.drawable.list_eggs);
                currentImage = R.drawable.list_eggs;
                break;
            case R.drawable.list_eggs:
                imgView.setImageResource(R.drawable.list_milk);
                currentImage = R.drawable.list_milk;
                break;
            case R.drawable.list_milk:
                imgView.setImageResource(R.drawable.list_pastasause);
                currentImage = R.drawable.list_pastasause;
                break;
            case R.drawable.list_pastasause:
                imgView.setImageResource(R.drawable.list_beans);
                currentImage = R.drawable.list_beans;
                break;
            case R.drawable.nolist_beans:
                imgView.setImageResource(R.drawable.nolist_cannedveg);
                currentImage = R.drawable.nolist_cannedveg;
                break;
            case R.drawable.nolist_cannedveg:
                imgView.setImageResource(R.drawable.nolist_eggs);
                currentImage = R.drawable.nolist_eggs;
                break;
            case R.drawable.nolist_eggs:
                imgView.setImageResource(R.drawable.nolist_milk);
                currentImage = R.drawable.nolist_milk;
                break;
            case R.drawable.nolist_milk:
                imgView.setImageResource(R.drawable.nolist_pastasause);
                currentImage = R.drawable.nolist_pastasause;
                break;
            case R.drawable.nolist_pastasause:
                imgView.setImageResource(R.drawable.nolist_beans);
                currentImage = R.drawable.nolist_beans;
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.virtual_reality, menu);
        menu.findItem(R.id.action_list_toggle).setChecked(useList);
        if (!listAvailable) {
            menu.findItem(R.id.action_list_toggle).setEnabled(false);
        }
        return true;
    }


    @Override
    public boolean onMenuItemSelected(int id, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list_toggle:
                if (item.isChecked()){
                    item.setChecked(false);
                    useList = false;
                    toggleListFilter();
                } else {
                    item.setChecked(true);
                    useList = true;
                    toggleListFilter();
                }
                return true;
            case R.id.action_new_list:
                finish();
                return true;
            case R.id.action_view_list:
                ViewListDialog m = new ViewListDialog();
                m.show(this.getFragmentManager(), null);
                return true;
            default:
                return super.onMenuItemSelected(id, item);
        }
    }


    private void toggleListFilter(){
        switch (currentImage){
            case R.drawable.list_beans:
                imgView.setImageResource(R.drawable.nolist_beans);
                currentImage = R.drawable.nolist_beans;
                break;
            case R.drawable.list_cannedveg:
                imgView.setImageResource(R.drawable.nolist_cannedveg);
                currentImage = R.drawable.nolist_cannedveg;
                break;
            case R.drawable.list_eggs:
                imgView.setImageResource(R.drawable.nolist_eggs);
                currentImage = R.drawable.nolist_eggs;
                break;
            case R.drawable.list_milk:
                imgView.setImageResource(R.drawable.nolist_milk);
                currentImage = R.drawable.nolist_milk;
                break;
            case R.drawable.list_pastasause:
                imgView.setImageResource(R.drawable.nolist_pastasause);
                currentImage = R.drawable.nolist_pastasause;
                break;
            case R.drawable.nolist_beans:
                imgView.setImageResource(R.drawable.list_beans);
                currentImage = R.drawable.list_beans;
                break;
            case R.drawable.nolist_cannedveg:
                imgView.setImageResource(R.drawable.list_cannedveg);
                currentImage = R.drawable.list_cannedveg;
                break;
            case R.drawable.nolist_eggs:
                imgView.setImageResource(R.drawable.list_eggs);
                currentImage = R.drawable.list_eggs;
                break;
            case R.drawable.nolist_milk:
                imgView.setImageResource(R.drawable.list_milk);
                currentImage = R.drawable.list_milk;
                break;
            case R.drawable.nolist_pastasause:
                imgView.setImageResource(R.drawable.list_pastasause);
                currentImage = R.drawable.list_pastasause;
                break;
        }
    }


    class ViewListDialog extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            final View view = inflater.inflate(R.layout.list_dialog, null);

            ((ListView) view.findViewById(R.id.list)).setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new String[] {"Milk", "Eggs", "Pasta", "Sauce", "Beans", "Cereal", "Canned Veggies"}));


            builder.setView(view)
                    .setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });

            return builder.create();

        }


    }
}