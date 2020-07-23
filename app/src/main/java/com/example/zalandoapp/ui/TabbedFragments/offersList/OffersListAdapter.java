package com.example.zalandoapp.ui.TabbedFragments.offersList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;
import com.example.zalandoapp.ui.TabbedFragments.offerDetails.OfferDetailsFragment;

import java.util.ArrayList;

public class OffersListAdapter extends RecyclerView.Adapter<OffersListAdapter.MyViewHolder> {
    Context context;
    private ArrayList<Offer> offersList;
    NavController navController;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.offers_list_row, parent, false);

        //navController = Navigation.findNavController((Activity) context,R.id.nav_host_fragment);


        return new OffersListAdapter.MyViewHolder(view);
    }

    public OffersListAdapter(Context ct, ArrayList<Offer> list) {
        this.context = ct;
        this.offersList = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Offer currentItem = offersList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
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
        return offersList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, price;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            myImage = itemView.findViewById(R.id.myImageview);
        }
    }

}

