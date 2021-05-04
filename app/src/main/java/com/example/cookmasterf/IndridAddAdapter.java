package com.example.cookmasterf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class IndridAddAdapter extends ArrayAdapter<Ingridients> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Ingridients> ingridList;
    private ArrayList<Ingridients> AllIngrid;

    IndridAddAdapter(Context context, int resource, ArrayList<Ingridients> ingrid, ArrayList<Ingridients> AllIngrid) {
        super(context, resource, AllIngrid);
        this.ingridList = ingrid;
        this.AllIngrid = AllIngrid;
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
        } else {
            viewHolder.imgIngrid.setImageResource(R.drawable.ic_delete_icon);
        }

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