package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment blankFragment = new BlankFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_layout, blankFragment).commit();
    }

    public int count = -1;
    public int result = 1;

    public void MainClick(View view) {

        Button but = (Button) view;
        String butText = but.getText().toString();
        TextView label = (TextView) findViewById(R.id.mainLabel);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);

        Data data = new Data();

        Button but1 = (Button) findViewById(R.id.But1);
        Button but2 = (Button) findViewById(R.id.But2);
        Button but3 = (Button) findViewById(R.id.But3);
        Button but4 = (Button) findViewById(R.id.But4);

        if (data.rights.contains(butText)) result += 1;

        if (butText.equals("Выйти")) {
            finish();
        }
        else if (butText.equals("Начать")){
            label.setTextSize(40);
            but1.setTextSize(25);
            but2.setTextSize(25);
            but3.setTextSize(25);
            but4.setTextSize(25);
            but3.setVisibility(View.VISIBLE);
            but4.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            count += 1;
            label.setText(data.questions.get(count));
            but1.setText(data.firstBut.get(count));
            but2.setText(data.secondBut.get(count));
            but3.setText(data.thirdBut.get(count));
            but4.setText(data.fourthBut.get(count));
        }
        else if (count == 9)
        {
            progressBar.setProgress(10);
            String temp = "";
            if (result < 4) temp = data.goodWords.get(0);
            else if (result < 6) temp = data.goodWords.get(1);
            else if (result < 8) temp = data.goodWords.get(2);
            else if (result < 10) temp = data.goodWords.get(3);
            else if (result == 10) temp = data.goodWords.get(4);

            String text = temp + "\n"+ result + " из 10";
            label.setText(text);
            but1.setVisibility(View.GONE);
            but3.setText("Выйти");
            but2.setVisibility(View.GONE);
            but4.setVisibility(View.GONE);
        }
        else if (count < 10)
        {
            count += 1;
            progressBar.setProgress(count);
            label.setText(data.questions.get(count));
            but1.setText(data.firstBut.get(count));
            but2.setText(data.secondBut.get(count));
            but3.setText(data.thirdBut.get(count));
            but4.setText(data.fourthBut.get(count));
        }
    }
}