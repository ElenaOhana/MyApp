package com.jb.myApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

enum LastAction{ADD, SUB, MULT, DIV, NONE}

public class CalcActivity extends AppCompatActivity {

    private TextView textView;
    private double value =0;
    private boolean operationClicked;//If there was pressed an operation or not.
    private LastAction lastAction = LastAction.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        textView = findViewById(R.id.text_view);
    }

    public void resetValues() {
        textView.setText("0.00");
    }

    public void setValue(String value) { // No code repeat))
        if (textViewIsEmpty()) {
            textView.setText(value);
        }
        else if (operationClicked) {
            textView.setText(value);
            operationClicked=false;
        } else {
            String current = textView.getText().toString();
            textView.setText(current + value);
        }
    }

    public boolean textViewIsEmpty() {
        return ((textView.getText().toString().equals("0.00")) || (textView.getText().toString().equals("0.0")));
    }

    public void saveValue(){
        String input = textView.getText().toString();
        value = Double.parseDouble(input);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clear: {
                resetValues();
                lastAction=LastAction.NONE;
                break;
            }
            case R.id.btn_div: {
                saveValue();
                operationClicked = true;
                lastAction= LastAction.DIV;
                break;
            }
            case R.id.btn_mult: {
                saveValue();
                operationClicked = true;
                lastAction= LastAction.MULT;
                break;
            }
            case R.id.btn_minus: {
                saveValue();
                operationClicked = true;
                lastAction=LastAction.SUB;
                break;
            }
            case R.id.btn_plus: {
                saveValue();
                operationClicked = true;
                lastAction=LastAction.ADD;
                break;
            }

            case R.id.btn_dot: {
                String current = textView.getText().toString();
                textView.setText(current +".");
                break;
            }

            //Have press the negative button AFTER the number was pressed.
            case R.id.btn_neg: {
                String current = textView.getText().toString();
                textView.setText("-" +current);
                break;
            }

            case R.id.btn_equal: {
                String input = textView.getText().toString();
                double doubleValueFromInput = Double.parseDouble(input);
                double newVal = 0;
                switch (lastAction) {
                    case ADD:
                        newVal= value + doubleValueFromInput;
                        break;
                    case SUB:
                        newVal= value - doubleValueFromInput;
                        break;
                    case MULT:
                        newVal= doubleValueFromInput * value;
                        break;
                    case DIV:
                        if (doubleValueFromInput==0) {
                            Toast.makeText(this, "NaN -Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            resetValues();
                            return;
                        }
                        newVal= value / doubleValueFromInput;
                        break;
                    default:
                        break;
                }
                textView.setText("" + newVal);
                break;
            }

            case R.id.btn_0: {
                setValue("0");
                break;
            }
            case R.id.btn_1: {
                setValue("1");
                break;
            }
            case R.id.btn_2: {
                setValue("2");
                break;
            }
            case R.id.btn_3: {
                setValue("3");
                break;
            }
            case R.id.btn_4: {
                setValue("4");
                break;
            }
            case R.id.btn_5: {
                setValue("5");
                break;
            }
            case R.id.btn_6: {
                setValue("6");
                break;
            }
            case R.id.btn_7: {
                setValue("7");
                break;
            }
            case R.id.btn_8: {
                setValue("8");
                break;
            }
            case R.id.btn_9: {
                setValue("9");
                break;
            }

        }
    }
}