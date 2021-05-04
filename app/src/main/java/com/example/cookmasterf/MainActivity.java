package com.example.cookmasterf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MainScreenFragment mainFrag;
    FragmentFavorite favFrag;
    FragmentIngridients ingridFrag;
    FragmentList listFrag;
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    ArrayList<Ingridients> ingridients = new ArrayList<>();
    ArrayList<Ingridients> AllIngrid = new ArrayList<>();
    ArrayList<Ingridients> ShopIngrid = new ArrayList<>();


    public ArrayList<Recipe> getArrayList(){
        return recipes;
    }
    public ArrayList<Ingridients> getIngridList(){
        return ingridients;
    }
    public ArrayList<Ingridients> getAllIngridList(){
        return AllIngrid;
    }
    public ArrayList<Ingridients> getShopIngridList(){
        return ShopIngrid;
    }

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

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

        if(recipes.size()==0){
            recipes.add(new Recipe("Паста по итальянски", "30 мин", "330 ккал", R.drawable.pancakes, R.drawable.favactive, true));
            recipes.add(new Recipe("Макароны", "20 мин", "250 ккал", R.drawable.rice, R.drawable.favactive, false));
            recipes.add(new Recipe("Лазанья", "50 мин", "450 ккал", R.drawable.meat, R.drawable.favactive, true));
            recipes.add(new Recipe("Лазанья", "50 мин", "450 ккал", R.drawable.pizza, R.drawable.favactive, true));
        }

        if(ingridients.size()==0){

        }

        if(AllIngrid.size()==0){
            AllIngrid.add(new Ingridients("Макароны", false));
            AllIngrid.add(new Ingridients("Гречка", false));
            AllIngrid.add(new Ingridients("Молоко", false));
            AllIngrid.add(new Ingridients("Масло", false));
            AllIngrid.add(new Ingridients("Подсолнечное масло", false));
            AllIngrid.add(new Ingridients("Соль", false));
            AllIngrid.add(new Ingridients("Сахар", false));
            AllIngrid.add(new Ingridients("Рис", false));
            AllIngrid.add(new Ingridients("Говядина", false));
            AllIngrid.add(new Ingridients("Куриная грудка", false));

        }

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