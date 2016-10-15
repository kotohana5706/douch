package com.ajk.douch;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ahnju on 2016-10-02.
 */
public class radiusBtn extends LinearLayout{

    LinearLayout btnLayout;
    TextView btnText;

    public radiusBtn(Context context){
        super(context);
        initView();
    }

    public radiusBtn(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
        getAttrs(attrs);
    }

    public radiusBtn(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs);
        initView();
        getAttrs(attrs, defStyle);
    }

    private void initView(){
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.radius_btn, this, false);
        addView(v);
        btnLayout = (LinearLayout) findViewById(R.id.radius_btn_layout);
        btnText = (TextView) findViewById(R.id.radius_btn_text);
    }

    private void getAttrs(AttributeSet attrs){
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.radiusBtn);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle){
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.radiusBtn, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray){
        int textColor = typedArray.getColor(R.styleable.radiusBtn_textColor, 0);
        String textString = typedArray.getString(R.styleable.radiusBtn_text);
        btnText.setText(textString);
    }

    void setBtnText(String textString){
        btnText.setText(textString);
    }

    void setBtnTextColor(int textColor){
        btnText.setTextColor(textColor);
    }


}
