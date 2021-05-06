package com.example.cookmasterf;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class FragmentFavorite extends Fragment {
    private Context mContext;

    ArrayList<Recipe> recipes;
    ArrayList<Recipe> FavRecipes;


    public FragmentFavorite() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_screen, null);
        recipes = ((MainActivity) getActivity()).getArrayList();
        FavRecipes = ((MainActivity) getActivity()).getFavList();

        ListView recipeList = (ListView) v.findViewById(R.id.recipeList);
        FavouriteAdapter adapter = new FavouriteAdapter(mContext, R.layout.recipe_item, recipes, FavRecipes);
        recipeList.setAdapter(adapter);

    return v;
    }
}