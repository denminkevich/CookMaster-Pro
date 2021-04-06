package com.example.cookmasterf;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class MainScreenFragment extends Fragment {
    private Context mContext;
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

        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        if(recipes.size()==0){
            recipes.add(new Recipe("Паста по итальянски", "30 мин", "330 ккал", R.drawable.pancakes, R.drawable.favactive, true));
            recipes.add(new Recipe("Макароны", "20 мин", "250 ккал", R.drawable.rice, R.drawable.favactive, false));
            recipes.add(new Recipe("Лазанья", "50 мин", "450 ккал", R.drawable.meat, R.drawable.favactive, true));
            recipes.add(new Recipe("Лазанья", "50 мин", "450 ккал", R.drawable.pizza, R.drawable.favactive, true));
        }

        ListView recipeList = (ListView) v.findViewById(R.id.recipeList);
        RecipeAdapter adapter = new RecipeAdapter(mContext, R.layout.recipe_item, recipes);
        recipeList.setAdapter(adapter);

        return v;
    }
}