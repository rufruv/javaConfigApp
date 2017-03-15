package com.hanbit.javaconfigapp.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by hb2002 on 2017-03-15.
 */

public abstract class ReadQuery extends QueryFactory {
    SQLiteOpenHelper helper;

    public ReadQuery(Context context) {
        super(context);
    }

    @Override
    public SQLiteDatabase getDatabase() {
        return helper.getReadableDatabase();
    }
    public abstract ArrayList<?> read(String sql);
}
