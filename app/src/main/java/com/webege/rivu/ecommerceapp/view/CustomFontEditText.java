package com.webege.rivu.ecommerceapp.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Codez on 5/17/2016.
 */
public class CustomFontEditText extends EditText {
    public CustomFontEditText(Context context, AttributeSet attrs){
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Regular.ttf"));
    }

}
