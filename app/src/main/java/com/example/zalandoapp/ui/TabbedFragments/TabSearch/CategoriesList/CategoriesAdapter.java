package com.example.zalandoapp.ui.TabbedFragments.TabSearch.CategoriesList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.zalandoapp.entity.SubCategory;
import com.example.zalandoapp.ui.TabbedFragments.TabSearch.SearchAdapter;
import com.example.zalandoapp.ui.TabbedFragments.offersList.OffersListFragment;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {
    Context context;
    private ArrayList<SubCategory> subcategoriesList;
    NavController navController;
    String nameOfCategory;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.subcatrow, parent, false);

        //navController = Navigation.findNavController((Activity) context,R.id.nav_host_fragment);


        return new CategoriesAdapter.MyViewHolder(view);
    }


    public CategoriesAdapter(String nameOfCategory, Context ct, ArrayList<SubCategory> list) {
        this.context = ct;
        this.subcategoriesList = list;
        this.nameOfCategory = nameOfCategory;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final SubCategory currentItem = subcategoriesList.get(position);

        holder.title.setText(currentItem.getCategoryName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new OffersListFragment();
                FragmentManager fragmentManager=((FragmentActivity)context).getSupportFragmentManager();

                String myData;
                myData = nameOfCategory+"/"+currentItem.getCategoryName();

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
        return subcategoriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }

}
