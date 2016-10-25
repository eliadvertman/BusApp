package com.example.eliad.busapp;

import android.app.Activity;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * Created by Eliad on 23/10/2016.
 */

public class DynamicFragment extends ListFragment implements OnItemClickListener  {
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;



    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] textArray = {"One", "Two", "Three", "Four"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_fragment,textArray);
        setListAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();

    }
}
