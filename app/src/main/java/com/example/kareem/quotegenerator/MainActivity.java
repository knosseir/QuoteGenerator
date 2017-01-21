package com.example.kareem.quotegenerator;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageButton smallberg_button, nachenberg_button, miodrag_button;
    Button generate;
    TextView smallberg_text, nachenberg_text, miodrag_text, quote_text;
    //If active professor is 0 => Smallberg, 1 => Nachenberg, 2 => Miodrag
    int active_professor;
    //Add your own quotes here!
    //FUN FACT: miodrag's tumblr has some very "interesting" quotes http://pot-cognac.tumblr.com/
    String [] smallberg_quotes = {"\"Don’t forget the semicolon\""};
    String [] nachenberg_quotes = {"\"I need a volunteer. Yes, you—if it starts smoking, tell me!\""};
    String [] miodrag_quotes = {"\"Don’t get all excited when you find problems easy; your peers will find them easy too\""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set up Image Buttons
        smallberg_button = (ImageButton)findViewById(R.id.smallberg_button);
        nachenberg_button = (ImageButton)findViewById(R.id.nachenberg_button);
        miodrag_button = (ImageButton)findViewById(R.id.eggert_button);

        //Set up Buttons
        generate = (Button)findViewById(R.id.g_button);

        //Set up Text Views
        smallberg_text = (TextView)findViewById(R.id.smbrg);
        nachenberg_text = (TextView)findViewById(R.id.nchnbrg);
        miodrag_text = (TextView)findViewById(R.id.eggrt);
        quote_text = (TextView)findViewById(R.id.quotes);

        //Set up On Click Listeners
        smallberg_button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                active_professor = 0;
            }
        });

        nachenberg_button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                active_professor = 1;
            }
        });

        miodrag_button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                active_professor = 2;
            }
        });

        generate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                switch(active_professor)
                {
                    case 0: quote_text.setText(Arrays.toString(smallberg_quotes).replaceAll("\\[|\\]", ""));
                        break;
                    case 1: quote_text.setText(Arrays.toString(nachenberg_quotes).replaceAll("\\[|\\]", ""));
                        break;
                    case 2: quote_text.setText(Arrays.toString(miodrag_quotes).replaceAll("\\[|\\]", ""));
                        break;
                }
            }
        });

    }

    public void setAllProfessorToBlackText(){
        smallberg_text.setTextColor(Color.BLACK);
        nachenberg_text.setTextColor(Color.BLACK);
        miodrag_text.setTextColor(Color.BLACK);
    }
}
