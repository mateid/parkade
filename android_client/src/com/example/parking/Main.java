package com.example.parking;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.parking.integration.IntentIntegrator;
import com.example.parking.integration.IntentResult;

/**
 * Created with IntelliJ IDEA.
 * User: matei
 * Date: 5/20/13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button scanButton = (Button) findViewById(R.id.scan_button);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(Main.this);
                integrator.initiateScan();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {

            String content = scanResult.getContents();

            try
            {
                Uri address = Uri.parse(content);
                int id = Integer.parseInt(address.getLastPathSegment());
                Intent displayStatusIntent = new Intent(this, ParkingState.class);
                displayStatusIntent.putExtra("Id", id);
                startActivity(displayStatusIntent);
            }
            catch(Exception e)
            {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "The code does not appear to contain any parking information!", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}