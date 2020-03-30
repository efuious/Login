package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        String tel=bundle.getString("tel");
        String pswd=bundle.getString("pswd");
        String sex=bundle.getString("sex");
        String hobby=bundle.getString("hobby");
        String city=bundle.getString("city");
        TextView show_text=(TextView)findViewById(R.id.show);
        show_text.setText("手机号："+tel+"\n"+"密码："+pswd+"\n"+"性别:"+sex+"\n"+"爱好:"+hobby+"\n"+"城市:"+city+"\n");
    }

}
