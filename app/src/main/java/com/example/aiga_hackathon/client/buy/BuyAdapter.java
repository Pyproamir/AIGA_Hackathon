package com.example.aiga_hackathon.client.buy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.BuyFragment;


import java.util.ArrayList;
import java.util.List;

public class BuyAdapter extends RecyclerView.Adapter<BuyViewHolder> {


    private List<ShopModel> shopList;

    public BuyAdapter(List<ShopModel> shopList) {
        this.shopList = shopList;

    }

    @NonNull
    @Override
    public BuyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_item, parent, false);
        return new BuyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyViewHolder holder, int position) {
        ShopModel model = shopList.get(position);
        holder.name.setText(model.getName());
        holder.desc.setText(model.getDesc());
        holder.type.setText(model.isNew() ? "Brand New" : "Old Collection");
        holder.deliveryInfo.setText(String.format("+%.2f$ for delivery Located in %s", model.getDeliveryCost(), model.getDeliveryCity()));
        holder.cost.setText(String.format("$%.2f", model.getCost()));
        Glide.with(holder.image.getContext())
                .load(model.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public void setShopList(List<ShopModel> shopModels){
        this.shopList = new ArrayList<>(shopModels);
        notifyDataSetChanged();
    }

}

class BuyViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView name, desc, deliveryInfo, type, cost;


    public BuyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.ib_product_image);
        cost = itemView.findViewById(R.id.tx_product_cost);
        name = itemView.findViewById(R.id.tx_product_name);
        deliveryInfo = itemView.findViewById(R.id.tx_product_delivery);
        type = itemView.findViewById(R.id.tx_product_type);
        desc = itemView.findViewById(R.id.tx_product_desc);
    }
}
