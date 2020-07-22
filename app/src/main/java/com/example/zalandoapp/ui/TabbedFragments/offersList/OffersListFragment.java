package com.example.zalandoapp.ui.TabbedFragments.offersList;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;

import java.util.ArrayList;

public class OffersListFragment extends Fragment {

    private OffersListViewModel mViewModel;
    private RecyclerView recyclerView;
    private ArrayList<Offer> offersList;
    private OffersListAdapter offersListAdapter;
    private NavController navController;

    public static OffersListFragment newInstance() {
        return new OffersListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.offers_list_fragment,container,false);

        fillList();

        this.initList((RecyclerView) root.findViewById(R.id.recyclerViewOffers));

        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OffersListViewModel.class);
        // TODO: Use the ViewModel
    }

    private void fillList() {
        offersList = new ArrayList();
        offersList.add(new Offer("koszula","Missk","Jeans shirt, high quality",29,R.drawable.koszula1, "blue",1,"L"));
        offersList.add(new Offer("swtr","Chpo","Sunny sweater",199,R.drawable.swtr1, "yellow",2,"M"));
        offersList.add(new Offer("jeans","Yourrun","Traditional jeans skretch",149,R.drawable.jeans1,"blue",1,"M"));
        offersList.add(new Offer("gray","Gand2a","T-shirt gray",149,R.drawable.gray1,"gray",1,"L"));
        offersList.add(new Offer("jeans","Yourrun","Traditional jeans skretch",149,R.drawable.jeans1,"blue",1,"M"));

    }

    private void initList(RecyclerView view) {
        this.recyclerView = view;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        //manager.setOrientation(RecyclerView.VERTICAL);

        //this.list.setHasFixedSize(false);

        if (getContext() != null) {
            offersListAdapter = new OffersListAdapter(getActivity(), offersList);
            this.recyclerView.setAdapter(offersListAdapter);
        }
    }

}
