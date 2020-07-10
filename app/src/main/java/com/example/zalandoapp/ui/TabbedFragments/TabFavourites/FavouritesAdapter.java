package com.example.zalandoapp.ui.TabbedFragments.TabFavourites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;

import java.util.ArrayList;
import java.util.List;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.MyViewHolder> {
    Context context;
    private ArrayList<Offer> favouritesList;



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.favourites_row,parent,false);
        return new MyViewHolder(view);
    }

    public FavouritesAdapter(Context ct,ArrayList<Offer> list){
        this.context = ct;
        this.favouritesList = (ArrayList<Offer>) list;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder ,int position){
        Offer currentItem = favouritesList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
        holder.color.setText(currentItem.getColor());
        holder.price.setText(Integer.toString(currentItem.getPrice())+" zł");
        holder.myImage.setImageResource(currentItem.getImages());
    }

    @Override
    public int getItemCount(){
        return favouritesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, description, color, price;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            color = itemView.findViewById(R.id.color);
            price = itemView.findViewById(R.id.price);
            myImage = itemView.findViewById(R.id.myImageview);
        }
    }
}