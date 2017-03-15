package com.hanbit.javaconfigapp.factory;

import android.content.Context;
import android.widget.Button;

import java.util.Map;

/**
 * Created by hb2002 on 2017-03-15.
 */

public class ButtonFactory {
    public static Button createButton(Context context, Map<String, String>buttonMap, String type){
        Button button = null;
        String text = "",layoutParams="",bgColor="";
        switch (type){
            case "basic":
                button = new Button(context);
                break;
        }
        return button;
    }
}
