package com.groupc.officelocator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class roomSearchMaster extends mapstorage {
    private ListView searchList;
    private EditText searchBar;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String[] buildingList = campusMap.keySet().toArray(new String[campusMap.size()]);
        final String[] rooms = {"test","test2"};//campusMap.values().toArray(new String[0]);
        /*final ArrayList<String[]> room = new ArrayList<>();
        for(int i = 0; i < buildingList.length; ++i){
            room.add(campusMap.get(buildingList[i]));
        }*/

        //for(int i = 0; i < campusMap.size(); ++i){
        //rooms = campusMap.keySet().toArray(new String[campusMap.size()]);
        //}
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_search_master);


        searchList = (ListView) findViewById(R.id.searchList);
        searchList.setEmptyView(findViewById(R.id.empty));
        searchBar = (EditText) findViewById(R.id.searchBar);
        adapter = new ArrayAdapter<String>(this, R.layout.list_items, R.id.textView, rooms);
        searchList.setAdapter(adapter);



        searchBar.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                roomSearchMaster.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}

