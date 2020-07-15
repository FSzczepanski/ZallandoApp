package com.example.zalandoapp.ui.TabbedFragments;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;
import com.example.zalandoapp.ui.TabbedFragments.offerDetails.OfferDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class PropositionsHorizontalAdapter extends RecyclerView.Adapter<PropositionsHorizontalAdapter.MyViewHolder> {
    Context context;
    private ArrayList<Offer> propositionsList;



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.propositions_row, parent, false);

        //navController = Navigation.findNavController((Activity) context,R.id.nav_host_fragment);


        return new PropositionsHorizontalAdapter.MyViewHolder(view);
    }

    public PropositionsHorizontalAdapter(Context ct,ArrayList<Offer> propositionsList){
        this.context = ct;
        this.propositionsList = propositionsList;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder ,int position){
        final Offer currentItem = propositionsList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.price.setText(Integer.toString(currentItem.getPrice())+" zł");
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
    public int getItemCount(){
        return propositionsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, price;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            myImage = itemView.findViewById(R.id.myImageview);
        }
    }
}

