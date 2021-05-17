package org.techtown.mission07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_MENU = 101;

    EditText usernameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                Intent intent = new Intent(getApplicationContext(),MenuActivity.class); // 이벤트 처리 메서드 안에서 this 변수로 MainActivity 객체를 참조할 수 없음
                intent.putExtra("username", username);
                intent.putExtra("password", password);

                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            String function = data.getStringExtra("function");
            Toast.makeText(getApplicationContext(), "응답으로 전달된 function : " + function, Toast.LENGTH_SHORT).show();
        }
    }
}