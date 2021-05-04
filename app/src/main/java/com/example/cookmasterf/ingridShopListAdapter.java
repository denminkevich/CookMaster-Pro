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

public class ingridShopListAdapter extends ArrayAdapter<Ingridients> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Ingridients> ingridList;
    private ArrayList<Ingridients> AllIngrid;
    private ArrayList<Ingridients> ShopIngrid;

    ingridShopListAdapter(Context context, int resource, ArrayList<Ingridients> ingrid, ArrayList<Ingridients> AllIngrid, ArrayList<Ingridients> ShopIngrid) {
        super(context, resource, ShopIngrid);
        this.ingridList = ingrid;
        this.AllIngrid = AllIngrid;
        this.ShopIngrid = ShopIngrid;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final ingridShopListAdapter.ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ingridShopListAdapter.ViewHolder) convertView.getTag();
        }
        final Ingridients ingridients = ShopIngrid.get(position);

        viewHolder.nameView.setText(ingridients.getName());

        if (ShopIngrid.isEmpty()) {

        }

        if (ingridients.getInFridge() == true) {
            ShopIngrid.remove(ingridients);
        }

        if (ingridients.getInFridge() == false) {
            viewHolder.imgIngrid.setImageResource(R.drawable.ic_shopping_cart);
        }

        viewHolder.imgIngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ingridients.getInFridge() == false) {
                    ingridients.setInFridge(true);
                    ShopIngrid.remove(ingridients);
                    ingridList.add(ingridList.size(), ingridients);
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
