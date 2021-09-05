package com.example.taskapplication.ui.detailsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.taskapplication.Pogo.ResponseResult;
import com.example.taskapplication.R;
import com.example.taskapplication.ui.calculateActivity.CalculateActivity;

public class DetailsActivity extends AppCompatActivity {
    ModelViewMain modelViewMain;
    TableLayout tableLayout;
    Button  Cal_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //inflate
        Cal_Btn=findViewById(R.id.Cal_Btn);
        tableLayout=findViewById(R.id.TableDetails);
        //Get Data
        String data=getIntent().getStringExtra("Details");
        Cal_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailsActivity.this, CalculateActivity.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });

        //view Model
        modelViewMain= ViewModelProviders.of(this).get(ModelViewMain.class);
        fillRowOfTable("Qty       ", "Unit       ", "Food      ", "calories      ", "Weight      ");

        String[] arr = data.split(",");
        for (int i = 0; i <arr.length ; i++) {
            sendDataForApi(arr[i].trim());
       }

    }

    private void sendDataForApi(String data) {
            modelViewMain.GetData(data);
            modelViewMain.mutableLiveData.observe(this, new Observer<ResponseResult>() {
                @Override
                public void onChanged(ResponseResult responseResult) {
                   // Log.d("Fady",responseResult.getTotalNutrients().getFAT().getLabel());
                    String s=data.split(" ")[0]+" "+data.split(" ")[1]+" "+data.split(" ")[2]+" "+responseResult.getCalories()+" Kcal "+Math.round(responseResult.getTotalWeight())+" g ";
                    fillRowOfTable(data.split(" ")[0]+" ",data.split(" ")[1]+" ",data.split(" ")[2]+" ",responseResult.getCalories()+" Kcal ",Math.round(responseResult.getTotalWeight())+" g ");
                }
            });
        }

    private void fillRowOfTable(String Qty,String unit,String food,String  calories,String weight)
    {
        TableRow row=new TableRow(this);
        TextView q=new TextView(this);
        q.setText(Qty);
        row.addView(q);

        TextView Unit=new TextView(this);
        Unit.setText(unit);
        row.addView(Unit);
        TextView Food=new TextView(this);
        Food.setText(food);
        row.addView(Food);
        TextView Calories=new TextView(this);
        Calories.setText(calories);
        row.addView(Calories);
        TextView Weight=new TextView(this);
        Weight.setText(weight);
        row.addView(Weight);
        tableLayout.addView(row);
    }
}