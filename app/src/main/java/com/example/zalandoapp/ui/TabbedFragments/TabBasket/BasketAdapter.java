package com.example.zalandoapp.ui.TabbedFragments.TabBasket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;
import com.example.zalandoapp.ui.TabbedFragments.offerDetails.OfferDetailsFragment;

import java.util.ArrayList;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.MyViewHolder> {
    Context context;
    private ArrayList<Offer> basketList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.basket_row,parent,false);

        return new BasketAdapter.MyViewHolder(view);
    }

    public BasketAdapter(Context ct,ArrayList<Offer> list){
        this.context = ct;
        this.basketList = (ArrayList<Offer>) list;
    }


    @Override
    public void onBindViewHolder(@NonNull BasketAdapter.MyViewHolder holder , int position){
        Offer currentItem = basketList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
        holder.color.setText(currentItem.getColor());
        holder.price.setText(Integer.toString(currentItem.getPrice())+" zł");
        holder.myImage.setImageResource(currentItem.getImages());
        holder.amount.setText("Liczba: " +Integer.toString(currentItem.getAmount()));
        holder.size.setText("Rozmiar: "+currentItem.getSize());
    }

    @Override
    public int getItemCount(){
        return basketList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, description, color, price, size, amount;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            color = itemView.findViewById(R.id.color);
            price = itemView.findViewById(R.id.price);
            myImage = itemView.findViewById(R.id.myImageview);
            size = itemView.findViewById(R.id.size);
            amount = itemView.findViewById(R.id.amount);
        }
    }
}
