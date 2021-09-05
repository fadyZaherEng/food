package com.example.taskapplication.ui.calculateActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.taskapplication.Pogo.ResponseResult;
import com.example.taskapplication.R;

public class CalculateActivity extends AppCompatActivity {
TextView totalCalories,DetailsCalories;
ModelViewCalculate modelViewCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        DetailsCalories=findViewById(R.id.DetailsCalories);
        totalCalories=findViewById(R.id.totalCalories);
        modelViewCalculate= ViewModelProviders.of(this).get(ModelViewCalculate.class);

        //Get Data
        String[] data=getIntent().getStringExtra("data").split(",");
        String Data=data[0].trim();
        for (int i = 1; i <data.length ; i++) {
            Data+=" and "+data[1].trim();
        }
        SendDataForApi(Data);
    }

    private void SendDataForApi(String data)
    {
        modelViewCalculate.getMutableLiveData(data).observe(this, new Observer<ResponseResult>() {
            @Override
            public void onChanged(ResponseResult responseResult) {
                totalCalories.setText(responseResult.getCalories()+"");
            }
        });
    }

    private void FillDetailInTextView(ResponseResult response)
    {
        totalCalories.setText(response.getCalories()+"");
        DetailsCalories.setText(response.getTotalNutrients().getFAT().getLabel()+" "+Math.round(response.getTotalNutrients().getFAT().getQuantity())+" "+response.getTotalNutrients().getFAT().getUnit()+"       "+response.getTotalDaily().getFAT().getQuantity()+" "+response.getTotalDaily().getFAT().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getFASAT().getLabel()+" "+Math.round(response.getTotalNutrients().getFASAT().getQuantity())+" "+response.getTotalNutrients().getFASAT().getUnit()+"       "+response.getTotalDaily().getFASAT().getQuantity()+" "+response.getTotalDaily().getFASAT().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getCHOLE().getLabel()+" "+Math.round(response.getTotalNutrients().getCHOLE().getQuantity())+" "+response.getTotalNutrients().getCHOLE().getUnit()+"       "+response.getTotalDaily().getCHOLE().getQuantity()+" "+response.getTotalDaily().getCHOLE().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getNA().getLabel()+" "+Math.round(response.getTotalNutrients().getNA().getQuantity())+" "+response.getTotalNutrients().getNA().getUnit()+"       "+response.getTotalDaily().getNA().getQuantity()+" "+response.getTotalDaily().getNA().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getCHOCDF().getLabel()+" "+Math.round(response.getTotalNutrients().getCHOCDF().getQuantity())+" "+response.getTotalNutrients().getCHOCDF().getUnit()+"       "+response.getTotalDaily().getCHOCDF().getQuantity()+" "+response.getTotalDaily().getCHOCDF().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getFIBTG().getLabel()+" "+Math.round(response.getTotalNutrients().getFIBTG().getQuantity())+" "+response.getTotalNutrients().getFIBTG().getUnit()+"       "+response.getTotalDaily().getFIBTG().getQuantity()+" "+response.getTotalDaily().getFIBTG().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getSUGAR().getLabel()+" "+Math.round(response.getTotalNutrients().getSUGAR().getQuantity())+" "+response.getTotalNutrients().getSUGAR().getUnit()+"       "+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getPROCNT().getLabel()+" "+Math.round(response.getTotalNutrients().getPROCNT().getQuantity())+" "+response.getTotalNutrients().getPROCNT().getUnit()+"       "+response.getTotalDaily().getPROCNT().getQuantity()+" "+response.getTotalDaily().getPROCNT().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getVITD().getLabel()+" "+Math.round(response.getTotalNutrients().getVITD().getQuantity())+" "+response.getTotalNutrients().getVITD().getUnit()+"       "+response.getTotalDaily().getVITD().getQuantity()+" "+response.getTotalDaily().getVITD().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getCA().getLabel()+" "+Math.round(response.getTotalNutrients().getCA().getQuantity())+" "+response.getTotalNutrients().getCA().getUnit()+"       "+response.getTotalDaily().getCA().getQuantity()+" "+response.getTotalDaily().getCA().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getFE().getLabel()+" "+Math.round(response.getTotalNutrients().getFE().getQuantity())+" "+response.getTotalNutrients().getFE().getUnit()+"       "+response.getTotalDaily().getFE().getQuantity()+" "+response.getTotalDaily().getFE().getUnit()+"\n");
        DetailsCalories.setText(response.getTotalNutrients().getK().getLabel()+" "+Math.round(response.getTotalNutrients().getK().getQuantity())+" "+response.getTotalNutrients().getK().getUnit()+"       "+response.getTotalDaily().getK().getQuantity()+" "+response.getTotalDaily().getK().getUnit()+"\n");
    }
}