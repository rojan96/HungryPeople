package com.chiragawale.hungrypeople.Home.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chiragawale.hungrypeople.App;
import com.chiragawale.hungrypeople.Home.Item;
import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.dao.Dao;
import com.chiragawale.hungrypeople.data.model.Business;
import com.ramotion.foldingcell.FoldingCell;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class FoldingCellListAdapter extends ArrayAdapter<Business> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private Context mContext;
    private ArrayList<Business> mObjects;
    private  ArrayList<Business> mAllBusiness;

    public FoldingCellListAdapter(Context context, ArrayList<Business> allBusiness){
        super(context,0,allBusiness);
        this.mContext=context;
        this.mAllBusiness=allBusiness;

        //allBusiness= App.dao.getBusinessList();
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        Business business=mAllBusiness.get(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.businessName = cell.findViewById(R.id.title_business_name);
            viewHolder.address = cell.findViewById(R.id.title_business_address);
            viewHolder.businessID = cell.findViewById(R.id.title_business_id);
            viewHolder.emailAddress = cell.findViewById(R.id.title_business_email);
            viewHolder.phoneNumber=cell.findViewById(R.id.title_phone);
            viewHolder.contentRequestBtn = cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        if (null == business)
            return cell;

        // bind data from selected element to view through view holder
        viewHolder.businessName.setText(business.getBusinessName());
        viewHolder.address.setText(business.getAddress());
        viewHolder.businessID.setText(business.getBusinessID());
        viewHolder.emailAddress.setText(business.getEmailAddress());
        viewHolder.phoneNumber.setText(business.getPhoneNumber());


        // set custom btn handler for list item from that item
        if (business.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(business.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }

        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView businessName;
        TextView contentRequestBtn;
        TextView businessID;
        TextView phoneNumber;
        TextView emailAddress;
        TextView address;


    }
}
