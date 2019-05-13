package com.example.scrambler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Button scrambleBtn;
    Button surrenderBtn;
    EditText inputwordText;
    TextView scrambled;
    String kata;
    String realkata;
    int randnum;
    String newone="";


    Vector<Character> listofhuruf = new Vector<>();

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrambleBtn= findViewById(R.id.scramble);
        inputwordText= findViewById(R.id.word);
        surrenderBtn= findViewById(R.id.surrender);
        scrambled=findViewById(R.id.scrambledword);

        scrambleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(inputwordText.getText().toString().isEmpty())
                {
                    kata=scrambled.getText().toString();
                }
                else
                {
                    realkata=inputwordText.getText().toString();
                    kata=inputwordText.getText().toString();
                }
                inputwordText.setText("");

                for(int i=0;i<kata.length();i++)
                {
                    listofhuruf.add(kata.charAt(i));
                }

                for(int i=0;i<kata.length();i++)
                {
                    randnum=rand.nextInt(listofhuruf.size());
                    newone= newone+listofhuruf.get(randnum);
                    listofhuruf.remove(randnum);
                }

                scrambled.setText(newone);
                newone="";
            }
        });

        surrenderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrambled.setText(realkata);
            }
        });
    }
}
