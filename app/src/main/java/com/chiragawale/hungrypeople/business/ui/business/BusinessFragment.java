package com.chiragawale.hungrypeople.business.ui.business;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chiragawale.hungrypeople.App;
import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.data.model.Business;
import com.chiragawale.hungrypeople.data.model.FoodItem;

import java.util.ArrayList;

public class BusinessFragment extends Fragment {

    private BusinessViewModel mViewModel;
    TextView businessName,businessId,businessPhone;
    RecyclerView rv_business;

    public static BusinessFragment newInstance() {
        return new BusinessFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.business_fragment, container, false);
        businessId=root.findViewById(R.id.business_id);
        businessName=root.findViewById(R.id.business_name);
        businessPhone=root.findViewById(R.id.business_phoneNumber);
        rv_business=root.findViewById(R.id.rv_business);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BusinessViewModel.class);
        // TODO: Use the ViewModel
    }

}
