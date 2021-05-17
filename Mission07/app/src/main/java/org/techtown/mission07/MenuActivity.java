package org.techtown.mission07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        Toast.makeText(this, "username : " + username+", password : "+password, Toast.LENGTH_SHORT).show();

        Button customer_btn = findViewById(R.id.customer_btn);
        Button sales_btn = findViewById(R.id.sales_btn);
        Button goods_btn = findViewById(R.id.goods_btn);

        customer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("function", "고객 관리");
                setResult(RESULT_OK, resultIntent);// 응답 보내기

                finish();
            }
        });

        sales_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("function", "매출 관리");
                setResult(RESULT_OK, resultIntent);// 응답 보내기

                finish();
            }
        });

        goods_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("function", "상품 관리");
                setResult(RESULT_OK, resultIntent);// 응답 보내기

                finish();
            }
        });
    }
}