package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    TextView p_name,pro_price,pro_quantity;
    ImageView p_img;
    Button cart,back;
    TextView finalamount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        p_name=findViewById(R.id.pname);
        pro_price=findViewById(R.id.proprice);
        pro_quantity=findViewById(R.id.proquantity);
        p_img=findViewById(R.id.productimg);

        p_name.setText(MainActivity.p_obj.getName());
        pro_price.setText("$"+MainActivity.p_obj.getPrice());
        p_img.setImageResource(MainActivity.p_obj.getImg());

        pro_quantity=findViewById(R.id.proquantity);
        cart=findViewById(R.id.addtocart);
        back=findViewById(R.id.back);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("&&&&&&&&&&&**********");
                System.out.println("&&&&&&&&&&&**********"+pro_quantity.getText().length());

                if (pro_quantity.getText().length()>0)
                {
                    int quantity= Integer.parseInt( pro_quantity.getText().toString());
                    pro_quantity.setText(null);
                    MainActivity.final_price=MainActivity.p_obj.getPrice()*quantity;
                    System.out.println("&&&&&&&&&&&**********"+MainActivity.final_price);


                }
                Intent intent =new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });



      back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}