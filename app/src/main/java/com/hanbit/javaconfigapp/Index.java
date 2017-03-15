package com.hanbit.javaconfigapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.javaconfigapp.factory.LayoutParamsFactory;
import com.hanbit.javaconfigapp.mamber.MemberList;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = Index.this;
        LinearLayout ui = new LinearLayout(context);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
        TextView tv = new TextView(context);
        tv.setText("HELLO");
        tv.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        ui.addView(tv);
        Button btn = new Button(context);
        btn.setText("ENTER");
        btn.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        btn.setBackgroundColor(Color.parseColor("#00ff00"));
        ui.addView(btn);
        setContentView(ui);
        /* 위에까지가 화면구성(xml) */
        ViewGroup.MarginLayoutParams tvMargin = new ViewGroup.MarginLayoutParams(tv.getLayoutParams());
        tvMargin.setMargins(0,200,0,0);
        tv.setLayoutParams(new LinearLayout.LayoutParams(tvMargin));
        ViewGroup.MarginLayoutParams btnMargin = new ViewGroup.MarginLayoutParams(btn.getLayoutParams());
        btnMargin.setMargins(0,300,0,0);
        btn.setLayoutParams(new LinearLayout.LayoutParams(btnMargin));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"HELLO",Toast.LENGTH_LONG).show();
                DatabaseHelper helper = new DatabaseHelper(Index.this);
                startActivity(new Intent(Index.this, MemberList.class));
            }
        });
    }
    class DatabaseHelper extends SQLiteOpenHelper {
        final static String DATABASE_NAME="hanbit.db";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 2);
            this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE IF NOT EXISTS Member(\n" +
                    "  _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "  name TEXT,\n" +
                    "  phone TEXT,\n" +
                    "  age TEXT,\n" +
                    "  address TEXT,\n" +
                    "  salary TEXT\n" +
                    ");";
            db.execSQL(sql);
        /*for (int i = 0; i < 10; i++) {
            db.execSQL(String.format("INSERT INTO Member(name,phone,age,address,salary)\n" +
                            " VALUES('%s','%s','%s','%s','%s'); \n"
                    , "홍길동" + i, "010-0000-000" + i, "2" + i, "서울", (i + 1) + "00"));
        }*/
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Member");
            onCreate(db);
        }
    }
}
// message: title, content, writedate, sender, receiver