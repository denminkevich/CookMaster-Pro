package com.example.cookmasterf;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class FullRecipe extends Fragment{
    private Context mContext;
    ImageView RecImg;
    Button RecTxt;

    public FullRecipe() {
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
        View v = inflater.inflate(R.layout.fragment_full_recipe, container, false);
        RecImg = (ImageView) v.findViewById(R.id.recipeFullImage);
        RecImg.setImageResource(R.drawable.meat);
        RecTxt = (Button) v.findViewById(R.id.recipeName);
        RecTxt.setText("Курица");

        return v;
    }

}