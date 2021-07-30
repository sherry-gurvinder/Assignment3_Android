package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView products;
    public static double final_price=0;
    TextView finalamount;

    public static Product p_obj;
    ArrayList<Product>pList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products=findViewById(R.id.lvProducts);
        finalamount=findViewById(R.id.finalamount);
        fillData();
        if(final_price!=0)
        {
            finalamount.setText("$"+(double)final_price);
        }

        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                p_obj=pList.get(position);
                Intent intent =new Intent(getBaseContext(),ProductActivity.class);
                startActivity(intent);
            }
        });
        //create an array adapter and fill it from the array stdList
        products.setAdapter(new ProductAdapter(this,pList));

    }
    public void fillData()
    {
        pList.add(new Product("Head & Shoulder",8.50,R.mipmap.p1));
        pList.add(new Product("Pantene Pro IV",12.20,R.mipmap.p2));
        pList.add(new Product("Vatika",5.64,R.mipmap.p3));
        pList.add(new Product("TRESemme",10.12,R.mipmap.p4));
        pList.add(new Product("L'oReal",6.85,R.mipmap.p5));



    }
}