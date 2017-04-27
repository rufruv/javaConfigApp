package com.hanbit.javaconfigapp.mamber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hanbit.javaconfigapp.factory.LayoutParamsFactory;

import java.util.HashMap;
import java.util.Map;

public class MemberUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = MemberUpdate.this;
        Intent intent = this.getIntent();
        String spec = intent.getExtras().getString("spec").toString();
        Log.d("넘어온 스펙 : ",spec);
        String[] specs = spec.split(",");
        final Map<String,String> map = new HashMap<>();
        String[] keys = new String[specs.length/2];
        String[] vals = new String[specs.length/2];
        int k=0, v=0;
        for(int i=0;i<spec.length();i++){
            if((i%2)==0){
                Log.d("keys["+k+"] = specs["+i+"] :"+k,specs[i]);
                keys[k] = specs[i];
                k++;
            }else{
                Log.d("vals["+v+"] = specs["+i+"] :"+v,specs[i]);
                vals[v]=specs[i];
                v++;
            }
        }
        v=0;
        for(String key:keys){
            map.put(key,vals[v++]);
        }
        LinearLayout ui=new LinearLayout(context);
        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
    }
}
