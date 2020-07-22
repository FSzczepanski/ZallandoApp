package com.example.zalandoapp.ui.TabbedFragments.TabSearch;

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
import com.example.zalandoapp.entity.Category;
import com.example.zalandoapp.entity.Offer;
import com.example.zalandoapp.ui.TabbedFragments.TabSearch.CategoriesList.CategoriesListFragment;
import com.example.zalandoapp.ui.TabbedFragments.offerDetails.OfferDetailsFragment;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>{
    Context context;
    private ArrayList<Category> categoriesList;
    NavController navController;
    int currentitem;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.search_row, parent, false);

        //navController = Navigation.findNavController((Activity) context,R.id.nav_host_fragment);


        return new SearchAdapter.MyViewHolder(view);
    }


    public SearchAdapter(Context ct, ArrayList<Category> list) {
        this.context = ct;
        this.categoriesList = list;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Category currentItem = categoriesList.get(position);
        holder.title.setText(currentItem.getCategoryName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new CategoriesListFragment();
                FragmentManager fragmentManager=((FragmentActivity)context).getSupportFragmentManager();

                String myData;
                myData = currentItem.getCategoryName()+"/";

                for (int i = 0; i < currentItem.getSubCategories().length; i++) {
                    myData += currentItem.getSubCategories()[i]+"/";
                }



                Bundle data = new Bundle();
                data.putString("args",myData);

                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragment.setArguments(data);
                fragmentTransaction.replace(R.id.SearchConta,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}