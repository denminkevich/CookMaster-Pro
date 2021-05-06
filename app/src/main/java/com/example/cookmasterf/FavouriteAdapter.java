
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
        import android.widget.Toast;

        import androidx.constraintlayout.widget.ConstraintLayout;

        import java.util.ArrayList;

public class FavouriteAdapter extends ArrayAdapter<Recipe> {

    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Recipe> recipesList;
    private ArrayList<Recipe> FavList;

    FavouriteAdapter(Context context, int resource, ArrayList<Recipe> recipes, ArrayList<Recipe> favList) {
        super(context, resource, favList);
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
        final Recipe recipe = FavList.get(position);

        viewHolder.nameView.setText(recipe.getName());
        viewHolder.timeView.setText(recipe.getTime());
        viewHolder.calorieView.setText(recipe.getCalorie());
        viewHolder.imageRecView.setImageResource(recipe.getImageResource());

        if (recipe.getFavourite() == true) {
            viewHolder.imageFavView.setImageResource(R.drawable.favactive);
        } else {
            FavList.remove(recipe);
        }

        viewHolder.RecFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment FullRec = new FullRecipe();
//
//                getActivity().getFragmentManager().beginTransaction()
//                        .replace(R.id.frgmCont, FullRec, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
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
