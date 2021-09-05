package com.example.taskapplication.ui.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.taskapplication.R;
import com.example.taskapplication.ui.detailsActivity.DetailsActivity;

public class MainActivity extends AppCompatActivity {
EditText Key_et;
Button Analysis_btn;
CharSequence data="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Key_et=findViewById(R.id.key_et);
        Analysis_btn=findViewById(R.id.Analysis_btn);
        SetButtonVisibility();
        SendDetailsActivity();
    }

    private void SetButtonVisibility()
    {
        Key_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.equals(null))
                {
                    Analysis_btn.setVisibility(View.GONE);
                }
                else
                {
                    Analysis_btn.setVisibility(View.VISIBLE);
                    data= s;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void SendDetailsActivity()
    {
        Analysis_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("Details",String.valueOf(data));
                startActivity(intent);
            }
        });

    }
}