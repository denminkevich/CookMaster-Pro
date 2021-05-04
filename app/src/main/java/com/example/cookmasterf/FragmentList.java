package com.example.cookmasterf;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class FragmentList extends Fragment {
    private Context mContext;
    ArrayList<Ingridients> ingrid;
    ArrayList<Ingridients> AllIngrid;
    ArrayList<Ingridients> ShopIngrid;

    public FragmentList() {
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
        View v = inflater.inflate(R.layout.fragment_list, null);
        ingrid = ((MainActivity) getActivity()).getIngridList();
        AllIngrid = ((MainActivity) getActivity()).getAllIngridList();
        ShopIngrid = ((MainActivity) getActivity()).getShopIngridList();
        ListView ingridList = (ListView) v.findViewById(R.id.ShopListIngrid);
        ingridShopListAdapter adapter = new ingridShopListAdapter(mContext, R.layout.ingridient_item, ingrid, AllIngrid, ShopIngrid);
        ingridList.setAdapter(adapter);

        return v;
    }
}