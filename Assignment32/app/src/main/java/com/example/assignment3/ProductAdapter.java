package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList<Product>pList=new ArrayList<>();
    LayoutInflater inflater;//this we need to initialize the objects to link to the list_row

    public ProductAdapter (Context context,ArrayList<Product>pList)
    {
        this.pList=pList;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return pList.size();
    }

    @Override
    public Object getItem(int position) {
        return pList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view==null)
        {
            view=inflater.inflate(R.layout.list_row,null);
            holder=new ViewHolder();
            holder.name=view.findViewById(R.id.txvName);
            holder.age=view.findViewById(R.id.txvProduct);
            holder.stImg=view.findViewById(R.id.img);
            view.setTag(holder);

        }
        else
            holder=(ViewHolder) view.getTag();
        holder.name.setText(pList.get(i).getName());
        holder.age.setText(String.valueOf(pList.get(i).getPrice()));
        holder.stImg.setImageResource(pList.get(i).getImg());
        return view;
    }
    static class ViewHolder{
        TextView name;
        TextView age;
        ImageView stImg;
    }
}
