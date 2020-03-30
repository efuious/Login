package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
    private String mytel="";
    private String mypswd="";
    private String mysex="男";
    private String myhobby="";
    private String mycity="";

    EditText tel,pswd;
    RadioGroup sexs;
    RadioButton man,woman;
    CheckBox read,play,music;
    Button register;
    Spinner cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tel     = (EditText)findViewById(R.id.phone);
        pswd    = (EditText)findViewById(R.id.paswd);
        sexs     = (RadioGroup)findViewById(R.id.sex);
        man     = (RadioButton)findViewById(R.id.nan);
        sexs.setOnCheckedChangeListener(this);
        read    = (CheckBox)findViewById(R.id.read_book);
        play    = (CheckBox)findViewById(R.id.play_ball);
        music   = (CheckBox)findViewById(R.id.music);
        register    = (Button)findViewById(R.id.register);
        register.setOnClickListener(this);
        cities    =(Spinner)findViewById(R.id.spinner);
        final String[] citylist = new String[]{"北京","上海","重庆","广州","武汉"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,citylist);
        cities.setAdapter(adapter);
        cities.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mycity=citylist[pos];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.register:
            mytel = tel.getText().toString();
            mypswd = pswd.getText().toString();
            myhobby = "";
            if(read.isChecked()){
                myhobby += read.getText().toString();
            }
            if(play.isChecked()){
                myhobby += play.getText().toString();
            }
            if(music.isChecked()){
                myhobby += music.getText().toString();
            }
//                System.out.println("电话"+mytel);
//                System.out.println("密码"+mypswd);
//                System.out.println("性别"+mysex);
//                System.out.println("爱好"+myhobby);
//                System.out.println("城市"+mycity);
            Intent intent = new Intent(this,show.class);
            Bundle bundle = new Bundle();
            bundle.putString("tel",mytel);
            bundle.putString("pswd",mypswd);
            bundle.putString("sex",mysex);
            bundle.putString("hobby",myhobby);
            bundle.putString("city",mycity);
            intent.putExtras(bundle);
            startActivity(intent);
            break;
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        mysex = i == R.id.nan?"男性":"女性";
    }
}
