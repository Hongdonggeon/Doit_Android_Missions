package org.techtown.mission04;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView byteMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        byteMsg = findViewById(R.id.textView);
        EditText inputMsg = findViewById(R.id.text_ms);
        Button submit_btn = findViewById(R.id.submit);
        Button close_btn = findViewById(R.id.cancel);

        inputMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            bytesCounter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String msg = inputMsg.getText().toString();
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
    private void bytesCounter(CharSequence sc){
        byteMsg.setText(""+ sc.toString().getBytes().length + " / 80 바이트");
    }
}