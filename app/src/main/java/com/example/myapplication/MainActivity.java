package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.view.CardInputView;

public class MainActivity extends AppCompatActivity {
    CardInputView cardInputView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    private void initLayout() {
        cardInputView = findViewById(R.id.card_input_view);

        cardInputView.setOnTextChangeListener(new CardInputView.TextChangeListener() {
            @Override
            public void onTextChange(String text) {
                Log.i("Main_cardInputView", "onTextChange: " + text);
            }

            @Override
            public void onInputFinish(String text) {
                Log.i("Main_cardInputView", "onInputFinish: " + text);
            }
        });
    }
}