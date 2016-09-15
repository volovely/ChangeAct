package com.example.roman.sample.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.roman.sample.R;

/**
 * Created by Roman on 13.09.2016.
 */
public class SecondActivity extends AppCompatActivity{
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        value = (EditText)findViewById(R.id.value);
    }

    public void backClick(View view){
        Intent i = new Intent(SecondActivity.this, MainActivity.class);
        i.putExtra("value", value.getText().toString());
        startActivity(i);
    }
}
