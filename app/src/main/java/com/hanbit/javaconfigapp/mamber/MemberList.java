package com.hanbit.javaconfigapp.mamber;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hanbit.javaconfigapp.action.IList;
import com.hanbit.javaconfigapp.factory.LayoutParamsFactory;
import com.hanbit.javaconfigapp.factory.ReadQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = MemberList.this;
        LinearLayout ui = new LinearLayout(context);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
        ListView lv = new ListView(context);
        lv.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        ui.addView(lv);
        LinearLayout ui2 = new LinearLayout(context);


        final ListView listView = lv;
        final InMemberList mList = new InMemberList(context);
        IList service = new IList() {
            @Override
            public ArrayList<?> list() {
                ArrayList<?> list = mList.read("SELECT _id AS id,name,phone,age,address,salary FROM Member;");
                return list;
            }
        };

    }

    class InMemberList extends ReadQuery {

        public InMemberList(Context context) {
            super(context);
        }

        @Override
        public ArrayList<?> read(String sql) {
            ArrayList<Map> list = new ArrayList<>();
            SQLiteDatabase db = super.getDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            Map<String, String> map = null;
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    do {
                        map = new HashMap<>();
                        map.put("id", cursor.getString(cursor.getColumnIndex("id")));
                        map.put("name", cursor.getString(cursor.getColumnIndex("name")));
                        map.put("phone", cursor.getString(cursor.getColumnIndex("phone")));
                        map.put("age", cursor.getString(cursor.getColumnIndex("age")));
                        map.put("address", cursor.getString(cursor.getColumnIndex("address")));
                        map.put("salary", cursor.getString(cursor.getColumnIndex("salary")));
                        list.add(map);
                    } while (cursor.moveToNext());
                }
            }
            return list;
        }
    }

    class MemberAdapter extends BaseAdapter {

        public MemberAdapter() {
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}