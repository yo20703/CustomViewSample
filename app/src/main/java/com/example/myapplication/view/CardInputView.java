package com.example.myapplication.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class CardInputView extends ConstraintLayout {
    public interface TextChangeListener {
        void onTextChange(String text);
        void onInputFinish(String text);
    }

    private final String TAG = "CardInputView";
    private TextChangeListener textChangeListener;
    private String text = "";
    private EditText etCardNumber1;
    private EditText etCardNumber2;
    private EditText etCardNumber3;
    private EditText etCardNumber4;
    public CardInputView(Context context) {
        super(context);

        inflate(context, R.layout.view_input_card, this);
        initLayout();
    }

    public CardInputView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.view_input_card, this);
        initLayout();
    }

    public CardInputView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.view_input_card, this);
        initLayout();
    }

    public CardInputView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        inflate(context, R.layout.view_input_card, this);
        initLayout();
    }

    public String getText(){
        return text;
    }

    //callback
    public void setOnTextChangeListener(TextChangeListener textChangeListener){
        this.textChangeListener = textChangeListener;
    }

    private void initLayout() {
        final int CardNumberMaxLength = 4;
        etCardNumber1 = findViewById(R.id.et_card_number1);
        etCardNumber2 = findViewById(R.id.et_card_number2);
        etCardNumber3 = findViewById(R.id.et_card_number3);
        etCardNumber4 = findViewById(R.id.et_card_number4);

        etCardNumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == CardNumberMaxLength){
                    etCardNumber2.requestFocus();
                }

                text = etCardNumber1.getText().toString()
                        + etCardNumber2.getText().toString()
                        + etCardNumber3.getText().toString()
                        + etCardNumber4.getText().toString();
                if(textChangeListener != null){
                    textChangeListener.onTextChange(text);

                    if(text.length() >= 16){
                        textChangeListener.onInputFinish(text);
                    }
                }
                Log.i(TAG, "onTextChanged: " + text);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etCardNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == CardNumberMaxLength){
                    etCardNumber3.requestFocus();
                }

                if(charSequence.length() == 0){
                    etCardNumber1.requestFocus();
                }

                text = etCardNumber1.getText().toString()
                        + etCardNumber2.getText().toString()
                        + etCardNumber3.getText().toString()
                        + etCardNumber4.getText().toString();
                if(textChangeListener != null){
                    textChangeListener.onTextChange(text);
                    if(text.length() >= 16){
                        textChangeListener.onInputFinish(text);
                    }
                }
                Log.i(TAG, "onTextChanged: " + text);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etCardNumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == CardNumberMaxLength){
                    etCardNumber4.requestFocus();
                }

                if(charSequence.length() == 0){
                    etCardNumber2.requestFocus();
                }

                text = etCardNumber1.getText().toString()
                        + etCardNumber2.getText().toString()
                        + etCardNumber3.getText().toString()
                        + etCardNumber4.getText().toString();
                if(textChangeListener != null){
                    textChangeListener.onTextChange(text);
                    if(text.length() >= 16){
                        textChangeListener.onInputFinish(text);
                    }
                }
                Log.i(TAG, "onTextChanged: " + text);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etCardNumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 0){
                    etCardNumber3.requestFocus();
                }

                text = etCardNumber1.getText().toString()
                        + etCardNumber2.getText().toString()
                        + etCardNumber3.getText().toString()
                        + etCardNumber4.getText().toString();
                if(textChangeListener != null){
                    textChangeListener.onTextChange(text);
                    if(text.length() >= 16){
                        textChangeListener.onInputFinish(text);
                    }
                }
                Log.i(TAG, "onTextChanged: " + text);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etCardNumber2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(etCardNumber1.getText().length() < 4){
                    etCardNumber1.requestFocus();
                }
            }
        });

        etCardNumber3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(etCardNumber2.getText().length() < 4){
                    etCardNumber2.requestFocus();
                }
            }
        });

        etCardNumber4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(etCardNumber3.getText().length() < 4){
                    etCardNumber3.requestFocus();
                }
            }
        });

    }
}
