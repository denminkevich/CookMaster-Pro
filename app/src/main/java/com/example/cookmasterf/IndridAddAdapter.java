package com.example.cookmasterf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IndridAddAdapter extends ArrayAdapter<Ingridients> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Ingridients> ingridList;
    private ArrayList<Ingridients> AllIngrid;
    private ArrayList<Ingridients> ShopIngrid;

    IndridAddAdapter(Context context, int resource, ArrayList<Ingridients> ingrid, ArrayList<Ingridients> AllIngrid, ArrayList<Ingridients> ShopIngrid) {
        super(context, resource, AllIngrid);
        this.ingridList = ingrid;
        this.AllIngrid = AllIngrid;
        this.ShopIngrid = ShopIngrid;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final IndridAddAdapter.ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (IndridAddAdapter.ViewHolder) convertView.getTag();
        }
        final Ingridients ingridients = AllIngrid.get(position);

        viewHolder.nameView.setText(ingridients.getName());

        if (ingridients.getInFridge() == false) {
            viewHolder.imgIngrid.setImageResource(R.drawable.ic_simple_plus);
            viewHolder.imgShop.setImageResource(R.drawable.ic_shopping_cart);
        } else {
            viewHolder.imgIngrid.setImageResource(R.drawable.ic_delete_icon);
        }

        viewHolder.imgShop.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (ingridients.getInFridge() == true) {
                    Toast toast = Toast.makeText(v.getContext(), R.string.isInFridge, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    if (ShopIngrid.contains(ingridients) == false) {
                        ShopIngrid.add(ShopIngrid.size(), ingridients);
                    }
                    notifyDataSetChanged();
                }
            }
        }));

        viewHolder.imgIngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ingridients.getInFridge() == true) {
                    ingridients.setInFridge(false);
                    viewHolder.imgIngrid.setImageResource(R.drawable.ic_delete_icon);
                    ingridList.remove(ingridients);
                    notifyDataSetChanged();
                } else if (ingridients.getInFridge() == false) {
                    ingridients.setInFridge(true);
                    viewHolder.imgIngrid.setImageResource(R.drawable.ic_simple_plus);
                    ingridList.add(ingridList.size(), ingridients);
                    ShopIngrid.remove(ingridients);
                    notifyDataSetChanged();
                }
            }
        });

        return convertView;
    }

    private class ViewHolder {
        final TextView nameView;
        final ImageButton imgIngrid, imgShop;

        ViewHolder(View view){
            nameView = (TextView) view.findViewById(R.id.ingrid_name);
            imgIngrid = (ImageButton) view.findViewById((R.id.ingrid_img));
            imgShop = (ImageButton) view.findViewById((R.id.shop_img));
        }
    }
}