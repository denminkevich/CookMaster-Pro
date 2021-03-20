package com.example.cookmasterf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    MainScreenFragment mainFrag;
    FragmentFavorite favFrag;
    FragmentIngridients ingridFrag;
    FragmentList listFrag;

    ImageButton imageButtonMain;
    ImageButton imageButtonFavorite;
    ImageButton imageButtonIngredients;
    ImageButton imageButtonShoppingList;

    FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        mainFrag = new MainScreenFragment();
        favFrag = new FragmentFavorite();
        ingridFrag = new FragmentIngridients();
        listFrag = new FragmentList();

        getFragmentManager().beginTransaction()
                .replace(R.id.frgmCont, mainFrag)
                .commit();

        imageButtonMain = (ImageButton)findViewById((R.id.imageButtonMain));
        imageButtonFavorite = (ImageButton)findViewById((R.id.imageButtonFavorite));
        imageButtonIngredients = (ImageButton)findViewById((R.id.imageButtonIngredients));
        imageButtonShoppingList= (ImageButton)findViewById((R.id.imageButtonShoppingList));
    }

    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.imageButtonMain:
                fTrans.addToBackStack(null);
                fTrans.replace(R.id.frgmCont, mainFrag);
                imageButtonMain.setImageResource(R.drawable.ic_icon_main_active);
                imageButtonIngredients.setImageResource(R.drawable.ic_icon_ingrid_nonactive);
                imageButtonFavorite.setImageResource(R.drawable.ic_icon_fav_nonactive);
                imageButtonShoppingList.setImageResource(R.drawable.ic_icon_list_nonactive);
                break;
            case R.id.imageButtonFavorite:
                fTrans.addToBackStack(null);
                fTrans.replace(R.id.frgmCont, favFrag);
                imageButtonFavorite.setImageResource(R.drawable.ic_icon_fav_active);
                imageButtonMain.setImageResource(R.drawable.ic_icon_main_nonactive);
                imageButtonIngredients.setImageResource(R.drawable.ic_icon_ingrid_nonactive);
                imageButtonShoppingList.setImageResource(R.drawable.ic_icon_list_nonactive);
                break;
            case R.id.imageButtonIngredients:
                fTrans.addToBackStack(null);
                fTrans.replace(R.id.frgmCont, ingridFrag);
                imageButtonIngredients.setImageResource(R.drawable.ic_icon_ingrid_active);
                imageButtonFavorite.setImageResource(R.drawable.ic_icon_fav_nonactive);
                imageButtonMain.setImageResource(R.drawable.ic_icon_main_nonactive);
                imageButtonShoppingList.setImageResource(R.drawable.ic_icon_list_nonactive);
                break;
            case R.id.imageButtonShoppingList:
                fTrans.addToBackStack(null);
                fTrans.replace(R.id.frgmCont, listFrag);
                imageButtonShoppingList.setImageResource(R.drawable.ic_icon_list_active);
                imageButtonIngredients.setImageResource(R.drawable.ic_icon_ingrid_nonactive);
                imageButtonFavorite.setImageResource(R.drawable.ic_icon_fav_nonactive);
                imageButtonMain.setImageResource(R.drawable.ic_icon_main_nonactive);
                break;
            default:
                break;
        }
        fTrans.commit();
    }

}