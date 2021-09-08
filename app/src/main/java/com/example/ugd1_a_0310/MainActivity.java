package com.example.ugd1_a_0310;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class MainActivity extends Activity {

    private Button b1, b2;
    EditText user, pass;
    TextView answer;

    private String NPM = "npm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btnLogin);
        b2 = (Button) findViewById(R.id.btnClear);
        user = (EditText) findViewById(R.id.editUser);
        pass = (EditText) findViewById(R.id.editPass);
        answer = (TextView) findViewById(R.id.tvOpsi);

        if(getIntent().getStringExtra("opsi")!=null)
        {
            String pilihan = getIntent().getStringExtra("opsi");
            answer.setText(pilihan);
            answer.setBackgroundColor(getIntent().getIntExtra("color",0));

            user.setText("190710310");
            pass.setText("ina");
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String npm = user.getText().toString();

                //set username "190710310" dan password "ina"
                if (user.getText().toString().equals("") || pass.getText().toString().equals(""))
                    //Kondisi jika username atau password kosong
                    Toast.makeText(getApplicationContext(), "Username atau Password Kosong", Toast.LENGTH_SHORT).show();
                else if (user.getText().toString().equals("190710310") && pass.getText().toString().equals("ina")) {
                    //kondisi jika login benar
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                    intent.putExtra(NPM, npm);
                    startActivity(intent);
                } else
                    //jika login gagal
                    Toast.makeText(getApplicationContext(), "Username atau Password Salah", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setText("");
                pass.setText("");
            }
        });
    }
}