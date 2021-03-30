package com.example.cookmasterf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class RecipeAdapter extends ArrayAdapter<Recipe> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Recipe> recipesList;

    RecipeAdapter(Context context, int resource, ArrayList<Recipe> recipes) {
        super(context, resource, recipes);
        this.recipesList = recipes;
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
        viewHolder.imageFavView.setImageResource(recipe.getImageFavRes());

        return convertView;
    }
    private class ViewHolder {
        final TextView nameView, timeView, calorieView;
        final ImageView imageRecView;
        final ImageButton imageFavView;

        ViewHolder(View view){
            timeView = (TextView) view.findViewById(R.id.recipeTime);
            nameView = (TextView) view.findViewById(R.id.recipeName);
            calorieView = (TextView) view.findViewById(R.id.recipeKkal);
            imageRecView = (ImageView) view.findViewById(R.id.recipeImage);
            imageFavView = (ImageButton) view.findViewById(R.id.favoritesImage);
        }
    }
}