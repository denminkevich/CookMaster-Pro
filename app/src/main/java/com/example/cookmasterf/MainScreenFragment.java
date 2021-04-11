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
import android.widget.ListView;
import java.util.ArrayList;

public class MainScreenFragment extends Fragment {
    private Context mContext;

    ArrayList<Recipe> recipes;
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

        ListView recipeList = (ListView) v.findViewById(R.id.recipeList);
        RecipeAdapter adapter = new RecipeAdapter(mContext, R.layout.recipe_item, recipes);
        recipeList.setAdapter(adapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // получаем выбранный пункт
                Recipe selectedRecipe = (Recipe) parent.getItemAtPosition(position);

                FullRecipe fullRecFrag = new FullRecipe();
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.frgmCont, fullRecFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        };
        recipeList.setOnItemClickListener(itemListener);

        return v;
    }
}