package com.example.zalandoapp.ui.TabbedFragments.TabFavourites;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;
import com.example.zalandoapp.ui.TabbedFragments.offerDetails.OfferDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.MyViewHolder> {
    Context context;
    private ArrayList<Offer> favouritesList;
    NavController navController;
    int currentitem;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.favourites_row, parent, false);

        //navController = Navigation.findNavController((Activity) context,R.id.nav_host_fragment);


        return new FavouritesAdapter.MyViewHolder(view);
    }


    public FavouritesAdapter(Context ct, ArrayList<Offer> list) {
        this.context = ct;
        this.favouritesList = (ArrayList<Offer>) list;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Offer currentItem = favouritesList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
        holder.color.setText(currentItem.getColor());
        holder.price.setText(Integer.toString(currentItem.getPrice()) + " zł");
        holder.myImage.setImageResource(currentItem.getImages());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new OfferDetailsFragment();
                FragmentManager fragmentManager=((FragmentActivity)context).getSupportFragmentManager();

                String myData;
                myData = currentItem.getTitle()+"/"+currentItem.getDescription()+"/"+currentItem.getColor()+"/"+
                        currentItem.getPrice()+"/"+currentItem.getOid();

                Bundle data = new Bundle();
                data.putString("args",myData);

                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragment.setArguments(data);
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return favouritesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, color, price;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            color = itemView.findViewById(R.id.color);
            price = itemView.findViewById(R.id.price);
            myImage = itemView.findViewById(R.id.myImageview);
        }
    }
}