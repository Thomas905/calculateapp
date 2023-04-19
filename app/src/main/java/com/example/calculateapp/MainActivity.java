package com.example.calculateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonDot, buttonClear;

    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonAdd = findViewById(R.id.button_add);
        buttonSubtract = findViewById(R.id.button_subtract);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonDivide = findViewById(R.id.button_divide);
        buttonEqual = findViewById(R.id.button_equal);
        buttonDot = findViewById(R.id.button_dot);
        buttonClear = findViewById(R.id.button_clear);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.append("/");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(".");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals("0")) {
                    textView.setText("");
                }
                textView.setText("0");
            }
        });
    }

    private void calculate() {
        String expression = textView.getText().toString();
        String[] tokens = expression.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

        if (tokens.length != 3) {
            return;
        }

        double operand1 = Double.parseDouble(tokens[0].replace(",", ",-."));
        String operator = tokens[1];
        double operand2 = Double.parseDouble(tokens[2].replace(",", "."));

        double result = 0.0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    return;
                }
                break;
            default:
                return;
        }

        this.result = String.format("%.2f", result).replace(",", ".");
        textView.setText(this.result);

        SharedPreferences prefs = getSharedPreferences("history", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String history = prefs.getString("history", "");
        history += expression + " = " + this.result + "\n";
        editor.putString("history", history);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem historyMenuItem = menu.findItem(R.id.menu_history);
        historyMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
                return true;
            }
        });
        return true;
    }

    private void addToHistory(String expression, String result) {
        Intent intent = new Intent(this, History.class);
        intent.putExtra("expression", expression);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}