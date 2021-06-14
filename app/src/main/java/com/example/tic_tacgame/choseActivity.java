package com.example.tic_tacgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class choseActivity extends AppCompatActivity {

    EditText one,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);
        one=findViewById(R.id.editText);
        two=findViewById(R.id.editText2);
    }


    public void submit(View view)
    {
        if(one.getText().toString().length()>=3 && two.getText().toString().length()>=3)
        {
            Intent intent=new Intent(choseActivity.this,twoplayer.class);
            ArrayList<String>list=new ArrayList<>();
            list.add(one.getText().toString());
            list.add(two.getText().toString());
            intent.putStringArrayListExtra("names",list);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Enter Player name", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();
        System.exit(0);
    }
}