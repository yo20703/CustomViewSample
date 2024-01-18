package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.view.CardInputView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    CardInputView cardInputView;
    TextView tv1;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    private void initLayout() {
        cardInputView = findViewById(R.id.card_input_view);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        cardInputView.setOnTextChangeListener(new CardInputView.TextChangeListener() {
            @Override
            public void onTextChange(String text) {
                Log.i("Main_cardInputView", "onTextChange: " + text);
                tv1.setText(text);
            }

            @Override
            public void onInputFinish(String text) {
                Log.i("Main_cardInputView", "onInputFinish: " + text);
                tv2.setText("輸入完成 卡號為：" + text);
            }
        });
    }
}