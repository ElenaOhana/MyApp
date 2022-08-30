package com.jb.myApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PLUS = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMe(View view){ // show alert dialog
        Toast.makeText(this, "Woho!", Toast.LENGTH_LONG).show();
    }

    /*public void calc(View view){
        double current = Double.parseDouble(value.getText().toString());
        switch (actionType){
            case PLUS:
                value.setText(""+(current+tmp));
                break;
        }
        actionType = ActionType.NONE;
    }*/
}