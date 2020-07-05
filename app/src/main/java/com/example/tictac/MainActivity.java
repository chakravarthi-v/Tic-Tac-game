package com.example.tictac;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import java.util.Arrays;

//import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    Button best;
    TextView bigger;
    int[] before={2,2,2,2,2,2,2,2,2};
    int[][] fool={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int count=0;
    boolean gameActive=true,full;
    @SuppressLint("SetTextI18n")
    public void onClick(View view){
        ImageView gost=(ImageView) view;
        int roll=Integer.parseInt(gost.getTag().toString());
        if(before[roll]==2&& gameActive) {
            before[roll] = count;
            gost.setTranslationY(-1500);
            if (count == 0) {
                gost.setImageResource(R.drawable.yellow);
                count = 1;
            } else {
                gost.setImageResource(R.drawable.red);
                count = 0;
            }
            for (int i : before) {
                if (i == 2) {
                    full = true;
                    break;
                } else {
                    full = false;
                }
            }
            if(!full){
                bigger.setText("Draw");
                best.setVisibility(View.VISIBLE);
                bigger.setVisibility(View.VISIBLE);
            }
            gost.animate().translationYBy(1500).setDuration(300);
            for (int[] nolan : fool) {
                if (before[nolan[0]] == before[nolan[1]] && before[nolan[1]] == before[nolan[2]] && before[nolan[0]] != 2&& full) {
                    gameActive=false;
                    String winner;
                    if (count == 1) {
                        winner = "yellow";
                    } else {
                        winner = "red";
                    }

                    bigger.setText(winner+" has won!");
                    best.setVisibility(View.VISIBLE);
                    bigger.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void playAgain(View view){
        Button best= findViewById(R.id.button);
        TextView bigger= findViewById(R.id.textView2);
        best.setVisibility(View.INVISIBLE);
        bigger.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = findViewById(R.id.Layout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }
        Arrays.fill(before, 2);
        count=0;
        gameActive=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        best= findViewById(R.id.button);
        bigger= findViewById(R.id.textView2);
    }
}