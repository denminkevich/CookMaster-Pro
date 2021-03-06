package com.example.cookmasterf;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class IngridAdapter extends ArrayAdapter<Ingridients> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Ingridients> ingridList;
    private ArrayList<Ingridients> AllIngridList;

    IngridAdapter(Context context, int resource, ArrayList<Ingridients> ingrid, ArrayList<Ingridients> AllIngrid) {
        super(context, resource, ingrid);
        this.ingridList = ingrid;
        this.AllIngridList = AllIngrid;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final IngridAdapter.ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (IngridAdapter.ViewHolder) convertView.getTag();
        }
        final Ingridients Allingridients = ingridList.get(position);

        viewHolder.nameView.setText(Allingridients.getName());
        viewHolder.imgIngrid.setImageResource(R.drawable.ic_delete_icon);

        if (Allingridients.getInFridge() == true) {
            notifyDataSetChanged();
        } else {
            ingridList.remove(position);
            notifyDataSetChanged();
        }

        viewHolder.imgIngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Allingridients.getInFridge() == true) {
                    Allingridients.setInFridge(false);
                    ingridList.remove(position);
                    notifyDataSetChanged();
                }
            }
        });

        return convertView;
    }

    private class ViewHolder {
        final TextView nameView;
        final ImageButton imgIngrid;

        ViewHolder(View view){
            nameView = (TextView) view.findViewById(R.id.ingrid_name);
            imgIngrid = (ImageButton) view.findViewById((R.id.ingrid_img));
        }
    }
}