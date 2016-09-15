package com.example.roman.sample.UI;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.example.roman.sample.R;

public class MainActivity extends AppCompatActivity {
    EditText mValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        mValue = (EditText)findViewById(R.id.mValue);
        String s = intent.getStringExtra("value");
        mValue.setText(s);
    }

    public void secActClick(View view){
        Intent i =  new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
        Log.v("activity", "hello1");
    }

    public void msgBoxBtnClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert!")
                .setMessage("Change activity?")
                .setCancelable(false)
                .setNegativeButton("Show second activity",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i =  new Intent(MainActivity.this, SecondActivity.class);
                                startActivity(i);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void notifBtnClick(View v)
    {
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setContentTitle("Change Activity?")
                .setContentText("Go?")
                .build();
        notificationManager.notify(0, notification);

    }

}
