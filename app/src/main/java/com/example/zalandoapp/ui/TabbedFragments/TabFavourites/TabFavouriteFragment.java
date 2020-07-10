package com.example.zalandoapp.ui.TabbedFragments.TabFavourites;

import androidx.lifecycle.ViewModelProvider;
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

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;

import java.util.ArrayList;
import java.util.List;

public class TabFavouriteFragment extends Fragment {

    private TabFavouriteViewModel mViewModel;
    private RecyclerView recyclerView;
    private ArrayList<Offer> favouritesList;
    private FavouritesAdapter favouritesAdapter;

    public static TabFavouriteFragment newInstance() {
        return new TabFavouriteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        this.mViewModel = ViewModelProviders.of(this).get(TabFavouriteViewModel.class);

        View root = inflater.inflate(R.layout.tab_favourite_fragment,container,false);

        fillList();

        this.initList((RecyclerView) root.findViewById(R.id.recycleViewfav));

        return root;
    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TabFavouriteViewModel.class);
        // TODO: Use the ViewModel
    }
    private void initList(RecyclerView view) {
        this.recyclerView = view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //manager.setOrientation(RecyclerView.VERTICAL);

        //this.list.setHasFixedSize(false);

        if (getContext() != null) {
            favouritesAdapter = new FavouritesAdapter(getActivity(), favouritesList);
            this.recyclerView.setAdapter(favouritesAdapter);
        }
    }

    private void fillList(){
        favouritesList = new ArrayList();
        favouritesList.add(new Offer("1","Adidas","Unisex T-shirt CREW NECK",49,R.drawable.shirtsport, "dark blue"));
        favouritesList.add(new Offer("2","Topwoman","Sweater hot cofre",99,R.drawable.sweater, "beige"));
        favouritesList.add(new Offer("3","Yourrun","Traditional jeans skretch",149,R.drawable.jeans,"blue"));
    }
}
