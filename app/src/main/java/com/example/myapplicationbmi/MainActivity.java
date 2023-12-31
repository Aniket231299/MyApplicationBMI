package com.example.myapplicationbmi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText edKg,edFeet,edIns;
    CardView cardBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edFeet = findViewById(R.id.edFeet);
        edKg = findViewById(R.id.edKg);
        cardBtn = findViewById(R.id.cardBtn);
        textView = findViewById(R.id.textView);
        edIns = findViewById(R.id.edIns);


        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String kg = edKg.getText().toString();
                String feet = edFeet.getText().toString();
                String inc = edIns.getText().toString();

                if (kg.length()>0&&feet.length()>0&&inc.length()>0){


                    float weight = Float.parseFloat(kg);
                    float efeet = Float.parseFloat(feet);
                    float eInc = Float.parseFloat(inc);

                    float height = (float) (efeet*0.3048+ eInc*0.0254);
                    float bmiIndex = weight/(height*height);

                    if (bmiIndex>24){

                        textView.setText("Overweight : "+bmiIndex);

                    }else if (bmiIndex>18){

                        textView.setText("Normal weight : "+bmiIndex);


                    }else {

                        textView.setText("Underweight : "+bmiIndex);

                    }


                }else {


                    textView.setText("Please Input All Box");

                }

            }
        });

    }
}