package com.chiragawale.hungrypeople.Home.ui.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chiragawale.hungrypeople.App;
import com.chiragawale.hungrypeople.Home.Item;
import com.chiragawale.hungrypeople.Profile.OrderActivity;
import com.chiragawale.hungrypeople.Profile.ProfileActivity;
import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.dao.Dao;
import com.chiragawale.hungrypeople.data.model.Business;
import com.chiragawale.hungrypeople.data.model.FoodItem;
import com.chiragawale.hungrypeople.data.model.User;
import com.ramotion.foldingcell.FoldingCell;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class FoldingCellListAdapter extends ArrayAdapter<User> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private Context mContext;
    //private ArrayList<Business> mObjects;
    private ArrayList<User> mAllBusiness;
    ViewHolder viewHolder;
    ArrayList<FoodItem> foodList;

    public FoldingCellListAdapter(Context context, ArrayList<User> allBusiness){
        //super(context,0,);
        super(context,0,allBusiness);
        this.mContext=context;
        this.mAllBusiness=allBusiness;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        final User business=mAllBusiness.get(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);

            //App.cartDao.getAllItemsFromCart(mContext);
            // binding view parts to view holder
            viewHolder.titleBusinessName = cell.findViewById(R.id.title_business_name);
            viewHolder.titleAddress = cell.findViewById(R.id.title_business_address);
            viewHolder.titleBusinessID = cell.findViewById(R.id.title_business_id);
            viewHolder.titleEmailAddress = cell.findViewById(R.id.title_business_email);
            viewHolder.titlePhoneNumber=cell.findViewById(R.id.title_phone);
            
            viewHolder.contentBusinessID=cell.findViewById(R.id.content_id);
            viewHolder.contentBusinessName=cell.findViewById(R.id.content_name);
            viewHolder.contentMenu1=cell.findViewById(R.id.content_menu1);
            viewHolder.contentMenu2=cell.findViewById(R.id.content_menu2);
            viewHolder.contentMenu3=cell.findViewById(R.id.content_menu3);
            viewHolder.contentMenu4=cell.findViewById(R.id.content_menu4);
            viewHolder.contentRequestBtn = cell.findViewById(R.id.content_request_btn);
            viewHolder.contentAddMenu1=cell.findViewById(R.id.add_menu1);
            viewHolder.contentAddMenu2=cell.findViewById(R.id.add_menu2);
            viewHolder.contentAddMenu3=cell.findViewById(R.id.add_menu3);
            viewHolder.contentAddMenu4=cell.findViewById(R.id.add_menu4);
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
        viewHolder.titleBusinessName.setText(business.getBusinessName());
        viewHolder.titleAddress.setText(business.getAddress());
        viewHolder.titleBusinessID.setText(business.getOpenHours());
        viewHolder.titleEmailAddress.setText(business.getEmailAddress());
        viewHolder.titlePhoneNumber.setText(business.getPhoneNumber());

        viewHolder.contentBusinessID.setText(business.getOpenHours());
        viewHolder.contentBusinessName.setText(business.getBusinessName());

       foodList=App.dao.getFoodItemList(mContext);

        viewHolder.contentAddMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.cartDao.addToCart(foodList.get(0),mContext);
            }
        });

        viewHolder.contentAddMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.cartDao.addToCart(foodList.get(1),mContext);
            }
        });

        viewHolder.contentAddMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.cartDao.addToCart(foodList.get(2),mContext);
            }
        });

        viewHolder.contentAddMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.cartDao.addToCart(foodList.get(3),mContext);
            }
        });
       
        try {
            viewHolder.contentMenu1.setText(foodList.get(0).getFoodName());
            viewHolder.contentMenu2.setText(foodList.get(1).getFoodName());
            viewHolder.contentMenu3.setText(foodList.get(2).getFoodName());
            viewHolder.contentMenu4.setText(foodList.get(3).getFoodName());
        }
        catch(Exception e){
            Log.e("folding",e.getMessage());
        }
        // set custom btn handler for list item from that item
        viewHolder.contentRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ProfileActivity.class));
            }
        });



        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else {
            registerUnfold(position);
            
        }
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
        TextView titleBusinessName;
        TextView titleBusinessID;
        TextView titlePhoneNumber;
        TextView titleEmailAddress;
        TextView titleAddress;

        TextView contentBusinessID;
        TextView contentBusinessName,contentMenu1,contentMenu2,contentMenu3,contentMenu4;
        Button contentRequestBtn;

        ImageButton contentAddMenu1,contentAddMenu2,contentAddMenu3,contentAddMenu4;


    }
}
