package com.example.cookmasterf;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Recipe> recipesList;
    private ArrayList<Recipe> FavList;

    RecipeAdapter(Context context, int resource, ArrayList<Recipe> recipes, ArrayList<Recipe> favList) {
        super(context, resource, recipes);
        this.recipesList = recipes;
        this.FavList = favList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Recipe recipe = recipesList.get(position);

        viewHolder.nameView.setText(recipe.getName());
        viewHolder.timeView.setText(recipe.getTime());
        viewHolder.calorieView.setText(recipe.getCalorie());
        viewHolder.imageRecView.setImageResource(recipe.getImageResource());

        if (recipe.getFavourite() == true) {
            viewHolder.imageFavView.setImageResource(R.drawable.favactive);
        } else {
            viewHolder.imageFavView.setImageResource(R.drawable.favnotactive);
        }

        viewHolder.RecFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View viewV = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_full_recipe, null);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Object selectedItem = (Object) recipe;

                Fragment FullRec = new FullRecipe();

                activity.getFragmentManager().beginTransaction()
                        .replace(R.id.frgmCont, FullRec, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        viewHolder.imageFavView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recipe.getFavourite() == true) {
                    recipe.setFavourite(false);
                    FavList.remove(recipe);
                    viewHolder.imageFavView.setImageResource(R.drawable.favnotactive);
                    notifyDataSetChanged();
                } else {
                    recipe.setFavourite(true);
                    FavList.add(FavList.size(), recipe);
                    viewHolder.imageFavView.setImageResource(R.drawable.favactive);
                    notifyDataSetChanged();
                }
            }

        });

        return convertView;
    }

    private class ViewHolder {
        final TextView nameView, timeView, calorieView;
        final ImageView imageRecView;
        final ImageButton imageFavView;
        ConstraintLayout RecFull;

        ViewHolder(View view){
            timeView = (TextView) view.findViewById(R.id.recipeTime);
            nameView = (TextView) view.findViewById(R.id.recipeName);
            calorieView = (TextView) view.findViewById(R.id.recipeKkal);
            imageRecView = (ImageView) view.findViewById(R.id.recipeImage);
            imageFavView = (ImageButton) view.findViewById(R.id.favoritesImage);
            RecFull = (ConstraintLayout) view.findViewById(R.id.list_item_info);
        }
    }
}