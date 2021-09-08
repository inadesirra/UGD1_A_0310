package com.example.ugd1_a_0310;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.ugd1_a_0310.MainActivity;

public class QuestionActivity extends AppCompatActivity {
    TextView tvNpm;
    private String NPM = "npm";
    private Button b3;
    RadioButton r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        tvNpm = (TextView) findViewById(R.id.tv_npm);
        b3 = (Button) findViewById(R.id.btnSubmit);
        r1 = (RadioButton) findViewById(R.id.opsi1);
        r2 = (RadioButton) findViewById(R.id.opsi2);
        r3 = (RadioButton) findViewById(R.id.opsi3);

        Bundle extras = getIntent().getExtras();
        String npm = extras.getString(NPM);
        tvNpm.setText("Selamat Datang, " + npm);

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String opsi;
                int color;

                if (r1.isChecked()) {
                    opsi = "Mudah";
                    color = Color.rgb(200, 0, 0);
                } else if (r2.isChecked()) {
                    opsi = "Mudah Sekali";
                    color = Color.rgb(0, 200, 0);
                } else {
                    opsi = "Mudah Banget";
                    color = Color.rgb(0, 0, 200);
                }

                Intent iSubmit = new Intent(QuestionActivity.this, MainActivity.class);

                iSubmit.putExtra("opsi", opsi);
                iSubmit.putExtra("color", color);

                iSubmit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(iSubmit);
            }
        });
    }
}