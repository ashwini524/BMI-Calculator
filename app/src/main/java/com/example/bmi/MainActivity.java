package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout LLMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        LLMain=findViewById(R.id.LLmain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get method to take input from user
                //set method to give input to user

                //input type in edittext we have taken number so int return type ** else Number Format exception
               int wt = Integer.parseInt(edtWeight.getText().toString());
               int ft = Integer.parseInt(edtHeightFt.getText().toString());
               int in = Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn=ft*12+in;
               double totalCm=totalIn*2.53;
               double totalM=totalCm/100;

               double bmi= wt/(totalM*totalM);
               if (bmi>25){
                   txtResult.setText("You're Overweight");
                   LLMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
               }else if (bmi<18){
                   txtResult.setText("You're Under Weight");
                   LLMain.setBackgroundColor(getResources().getColor(R.color.colorUW));

               }else {
                   txtResult.setText("You're Healthy");
                   LLMain.setBackgroundColor(getResources().getColor(R.color.colorH));
               }

            }
        });
    }
}