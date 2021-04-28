package org.techtown.mission03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView topImage;
    ImageView bottomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topImage.findViewById(R.id.image01);
        bottomImage.findViewById(R.id.image02);

        Button topbutton = findViewById(R.id.button01);
        topbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imageup();
            }
        });

        Button downbutton = findViewById(R.id.button02);
        downbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                imagedown();
            }
        });

        imageup();

    }

    private void imageup() {
        topImage.setImageResource(R.drawable.messi);
        bottomImage.setImageResource(0);

        topImage.invalidate();
        bottomImage.invalidate();
    }

    private void imagedown() {
        topImage.setImageResource(0);
        bottomImage.setImageResource(R.drawable.messi);

        topImage.invalidate();
        bottomImage.invalidate();
    }

}