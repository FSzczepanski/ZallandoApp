package com.example.zalandoapp.ui.TabbedFragments.TabSearch.CategoriesList;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.SubCategory;
import com.example.zalandoapp.ui.TabbedFragments.TabBasket.TabBasketFragment;

import java.util.ArrayList;

public class CategoriesListFragment extends Fragment {

    private CategoriesListViewModel mViewModel;
    private ArrayList<SubCategory> subcategoriesList;
    private CategoriesAdapter categoriesAdapter;
    private RecyclerView categoriesRecyclerView;
    private String nameOfCategory;

    public static CategoriesListFragment newInstance() {
        return new CategoriesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.categories_list_fragment, container, false);


        fillList();

        this.initList((RecyclerView) root.findViewById(R.id.recycleViewfav));
        TextView titleOfCat = root.findViewById(R.id.title);
        titleOfCat.setText(nameOfCategory);



        return root;
    }

    private void initList(RecyclerView view) {
        this.categoriesRecyclerView = view;
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        //manager.setOrientation(RecyclerView.VERTICAL);

        //this.list.setHasFixedSize(false);

        if (getContext() != null) {
            categoriesAdapter = new CategoriesAdapter(nameOfCategory,getActivity(), subcategoriesList);
            this.categoriesRecyclerView.setAdapter(categoriesAdapter);
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View contraint = view.findViewById(R.id.constV);
        contraint.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Fragment fragment = new TabBasketFragment();
                FragmentManager fragmentManager=((FragmentActivity) getActivity()).getSupportFragmentManager();

                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentManager.popBackStack();
            }
        });

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CategoriesListViewModel.class);
        // TODO: Use the ViewModel
    }
    private void fillList() {
        Bundle bundle = this.getArguments();
        String myItem = "";
        if (bundle != null) {
            myItem = bundle.getString("args");
        }


        String[] tab = myItem.split("/");
        nameOfCategory = tab[0];


        subcategoriesList = new ArrayList<>();
        for (int i = 1; i < tab.length ; i++) {
            subcategoriesList.add(new SubCategory(tab[i]));
        }


    }
}
