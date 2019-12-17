package com.arashad96.androiddeveloperintermidatekit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Time_Table_Learner extends AppCompatActivity {
    TextView timetable;
    Button github;
    Button info;
    SeekBar multiplierbar;
    ListView multiplyresults;
    ArrayList<Integer> valuestomultiply_using_bar = new <Integer>ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
    ArrayList<Integer> valuestomultiply = new <Integer>ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    ArrayList<Integer> showresults = new <Integer>ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_time__table__learner);

        timetable = findViewById(R.id.timetable);

        for (int i = 1; i <= 10; i++) {
            showresults.add(i);
        }

        multiplierbar = findViewById(R.id.multiplierbar);
        multiplyresults = findViewById(R.id.multiplyresults);

        final ArrayAdapter<Integer> values = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, showresults);
        multiplyresults.setAdapter(values);
        values.notifyDataSetChanged();

        //Limiting the bar for the max number which is 20
        multiplierbar.setMax(valuestomultiply_using_bar.size()-1);
        multiplierbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Log.i("testing ",""+valuestomultiply_using_bar.get(i));
                for (int j = 0 ; j < 10; j++){
                    timetable.setText("Timetable of "+valuestomultiply_using_bar.get(i));
                    showresults.set(j, valuestomultiply_using_bar.get(i)*valuestomultiply.get(j));
                    values.notifyDataSetChanged();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/Time_Table_Learner"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(Time_Table_Learner.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app performing a simple timetable using listview, seekbar, textview and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }
}
