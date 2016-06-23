package com.example.hthuwal.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    public static int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> messages = new ArrayList<String>();
        messages.add("Haw! You touched me!!");
        messages.add("Don't touch me -_-");
        messages.add("I said dont't touch me.");
        messages.add("How many times do i need to tell You. Don't touch me!!");
        messages.add("I am starting to like it!!");
        messages.add("Oh Yeah, Keep Going :P");
        messages.add("Bad Deadpool… Good Deadpool!");
        messages.add("Say the magic words, Fat Gandalf.");
        messages.add("You have something in your teeth.");
        ImageView imageView = (ImageView)findViewById(R.id.deadpool);
        assert imageView != null;

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView iv = (ImageView)v;
                Random rg = new Random();
                TextView tv = (TextView)findViewById(R.id.textView);
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    count++;
                    if(count%10==0){
                        Intent intent = new Intent(getApplicationContext(),reward.class);
                        startActivity(intent);
                    }
                    int n = rg.nextInt(messages.size());
                    tv.setText(count+" "+messages.get(n));
                    iv.setImageResource(R.drawable.deadpooltouched);

                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    try {
                        TimeUnit.MILLISECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    iv.setImageResource(R.drawable.deadpool);
                    return true;
                }
                return false;
            }
        });
    }

}
