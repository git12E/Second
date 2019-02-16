package com.example.second;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    NumberController nc;
    CalcController cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nc = new NumberController();
        nc.setDisplay((TextView)findViewById(R.id.mainEditText));
        cc = new CalcController();
        cc.setNc(nc);
    }

    public void  onPress(View vvvvvv){
        Button b = (Button) vvvvvv;
        Toast t = Toast.makeText(getApplicationContext(),b.getText().toString(),Toast.LENGTH_SHORT);
        t.show();

    }

    public void onDigitClick(View button){
        Button b = (Button)button;
        nc.addDigit(Integer.parseInt(b.getText().toString()));
    }

    public void onCClick(View button){
        nc.clear();
    }

    public void onPlusClick(View b){
        cc.slojit();
    }

    public void onMinusClick(View b){
        cc.vychest();
    }

    public void onUmnojitClick(View b){
        cc.umnojit();
    }

    public void onDelitClick(View b){
        cc.delit();
    }

    public void onCalcClick(View b){
        cc.vychislit();
    }

    public void onDotClick(View b){
        nc.addDot();
    }

    public void onInfoClick(View button){
        Intent i = new Intent(this,InfoActivity.class);
        startActivity(i);
    }
}
