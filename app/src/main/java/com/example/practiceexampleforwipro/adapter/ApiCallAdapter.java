package com.example.practiceexampleforwipro.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.practiceexampleforwipro.R;
import com.example.practiceexampleforwipro.model.RowDataItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ApiCallAdapter extends RecyclerView.Adapter<ApiCallAdapter.MyViewHolder> {

    private ArrayList<RowDataItem> itemsList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llMainLayout;
        RelativeLayout llDetails;
        TextView txtTitle, txtDetails;
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            llMainLayout = (LinearLayout) view.findViewById(R.id.ll_main_layout);
            llDetails = (RelativeLayout) view.findViewById(R.id.ll_details);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtDetails = (TextView) view.findViewById(R.id.txt_details);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    public ApiCallAdapter(Context mContext, ArrayList<RowDataItem> Items) {
        this.mContext = mContext;
        this.itemsList = Items;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.txtTitle.setText(itemsList.get(position).getTitle());

        if(TextUtils.isEmpty(itemsList.get(position).getDescription())){
            myViewHolder.txtDetails.setText("No description found");
        }else{
            myViewHolder.txtDetails.setText(itemsList.get(position).getDescription());
        }


        Picasso.get()
                .load(itemsList.get(position).getImageHref())
                .placeholder(R.drawable.ic_placeholder)
                .into(myViewHolder.imageView);

    }


    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}