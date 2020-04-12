package com.example.sortedlisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button sortedList = findViewById(R.id.sortedList);
//        sortedList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SortedListActivity.class));
//            }
//        });
    }

    public void toSortedListActivity(View view){
        startActivity(new Intent(this, SortedListActivity.class));
    }
}
