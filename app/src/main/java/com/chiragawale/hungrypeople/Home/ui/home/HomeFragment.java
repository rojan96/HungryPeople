package com.chiragawale.hungrypeople.Home.ui.home;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.chiragawale.hungrypeople.App;
import com.chiragawale.hungrypeople.Home.Item;
import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.data.model.Business;
import com.iammert.library.ui.multisearchviewlib.MultiSearchView;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private MultiSearchView mv;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_fragment, container, false);

        //EditText editText=v.findViewById(R.id.et_search);
        final ListView listView=v.findViewById(R.id.mainListView);
        final MultiSearchView multiSearchView=v.findViewById(R.id.et_multisearch);
        listView.setVisibility(View.INVISIBLE);

        multiSearchView.setSearchViewListener(new MultiSearchView.MultiSearchViewListener() {
            @Override
            public void onTextChanged(int i, CharSequence charSequence) {
                //animation(multiSearchView);
                RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams) multiSearchView.getLayoutParams();
                params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                multiSearchView.setLayoutParams(params);
                listView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onSearchComplete(int i, CharSequence charSequence) {

            }

            @Override
            public void onSearchItemRemoved(int i) {

            }

            @Override
            public void onItemSelected(int i, CharSequence charSequence) {

            }
        }
        );



        final ArrayList<Business> allBusiness= App.dao.getBusinessList();


        // add custom btn handler to first list item
//        items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show();
//            }
//        });


        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(getActivity(),allBusiness);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
            }
        });

        // set elements to adapter
        listView.setAdapter(adapter);

        // set on click event listener to list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                Log.e("clicked","clicked");
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });


        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
