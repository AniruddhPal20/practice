package com.example.practiceexampleforwipro.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practiceexampleforwipro.R;
import com.example.practiceexampleforwipro.model.RowDataItem;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ApiCallAdapter extends RecyclerView.Adapter<ApiCallAdapter.MyViewHolder> {

  private ArrayList<RowDataItem> itemsList;
  private Activity activity;

  public ApiCallAdapter(Activity activity, ArrayList<RowDataItem> Items) {
    this.activity = activity;
    this.itemsList = Items;
  }

  class MyViewHolder extends RecyclerView.ViewHolder {

    LinearLayout ll_root;
    TextView txtTitle, txtDetails;
    ImageView imageLogo;

    MyViewHolder(View view) {
      super(view);

      ll_root = view.findViewById(R.id.ll_root);
      txtTitle = view.findViewById(R.id.txt_title);
      txtDetails = view.findViewById(R.id.txt_details);
      imageLogo = view.findViewById(R.id.image_logo);
    }
  }

  @NonNull @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.adapter_item, parent, false);

    return new MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
    myViewHolder.txtTitle.setText(itemsList.get(position).getTitle());

    if (TextUtils.isEmpty(itemsList.get(position).getDescription())) {
      myViewHolder.txtDetails.setText(activity.getString(R.string.str_no_description));
    } else {
      myViewHolder.txtDetails.setText(itemsList.get(position).getDescription());
    }

    Picasso.get()
        .load(itemsList.get(position).getImageHref())
        .placeholder(R.drawable.ic_placeholder)
        .into(myViewHolder.imageLogo);
  }

  @Override
  public int getItemCount() {
    return itemsList.size();
  }
}