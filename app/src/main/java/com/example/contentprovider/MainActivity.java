package com.example.contentprovider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final  int REQUEST_CONTACT_PERMISSIONS = 1001;
    private static final  int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    Button btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void addEvents()
    {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyMoManHinhDanhBa();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyMoManHinhTinNhan();
            }
        });

    }
    private void xulyMoManHinhDanhBa()
    {
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        intent.setClassName("com.example.contentprovider","com.example.contentprovider.DanhBa");
        startActivity(intent);

    }
    private void xulyMoManHinhTinNhan()
    {

    }
    public void addControl(){
        btn1  = findViewById(R.id.btn1);
        btn2  = findViewById(R.id.btn2);
    }

}