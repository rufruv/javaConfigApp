package com.hanbit.javaconfigapp.mamber;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = MemberList.this;
        LinearLayout ui = new LinearLayout(context);
        LinearLayout.LayoutParams matchAndMatch = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams matchAndWrap = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams wrapAndMatch = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams wrapAndWrap = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(matchAndMatch);
        ListView lv = new ListView(context);

        lv.setLayoutParams(matchAndWrap);
        ui.addView(lv);
        Button btn = new Button(context);
        btn.setText("ENTER");
        btn.setLayoutParams(matchAndWrap);
        btn.setBackgroundColor(Color.parseColor("#00ff00"));
        ui.addView(btn);
        setContentView(ui);
    }
}
