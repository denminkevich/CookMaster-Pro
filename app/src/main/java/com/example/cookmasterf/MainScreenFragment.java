package com.example.cookmasterf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;
import android.widget.AdapterView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainScreenFragment extends Fragment {
    private Context mContext;

    ArrayList<Recipe> recipes;
    ArrayList<Recipe> FavRecipe;
    public MainScreenFragment() {
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
        FavRecipe = ((MainActivity) getActivity()).getFavList();

        ListView recipeList = (ListView) v.findViewById(R.id.recipeList);
        RecipeAdapter adapter = new RecipeAdapter(mContext, R.layout.recipe_item, recipes, FavRecipe);
        recipeList.setAdapter(adapter);


        return v;
    }

//    @Override
//    public void onViewCreated(View v, Bundle savedInstanceState) {
//        ListView recipeList = (ListView) v.findViewById(R.id.recipeList);
//        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object selectedItem = (Object) recipes.get(position);
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//
//                Fragment FullRec = new FullRecipe();
//
//                activity.getFragmentManager().beginTransaction()
//                        .replace(R.id.frgmCont, FullRec, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
//
//            }
//        });
//    }
}