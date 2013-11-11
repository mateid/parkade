package com.example.parking;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: matei
 * Date: 6/10/13
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingState extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int id = (Integer) intent.getExtras().get("Id");

        switch (id){
            case 1:
                setContentView(R.layout.parking_allowed);
                break;

            case 2:
                setContentView(R.layout.parking_notallowed);
                break;

            case 3:
                setContentView(R.layout.parking_nostopping);
                break;

            default:
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Parking information is not available at this location.", Toast.LENGTH_LONG);
                toast.show();

                Intent redirectToMain = new Intent(this, Main.class);
                startActivity(redirectToMain);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}