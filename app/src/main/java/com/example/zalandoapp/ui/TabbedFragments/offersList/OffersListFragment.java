package com.example.zalandoapp.ui.TabbedFragments.offersList;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;
import com.example.zalandoapp.ui.TabbedFragments.TabBasket.TabBasketFragment;

import java.util.ArrayList;

public class OffersListFragment extends Fragment {

    private OffersListViewModel mViewModel;
    private RecyclerView recyclerView;
    private ArrayList<Offer> offersList;
    private OffersListAdapter offersListAdapter;
    private NavController navController;
    String nameofc = "";

    public static OffersListFragment newInstance() {
        return new OffersListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.offers_list_fragment, container, false);


        Bundle bundle = this.getArguments();
        String myItem = "";
        if (bundle != null) {
            myItem = bundle.getString("args");
        }
        String[] tab = myItem.split("/");

        nameofc = tab[1];
        TextView nameofCat = root.findViewById(R.id.nameofcat);
        nameofCat.setText(nameofc);

        ImageButton backButton = root.findViewById(R.id.backBut);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new TabBasketFragment();
                FragmentManager fragmentManager = ((FragmentActivity) getActivity()).getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentManager.popBackStack();
            }
        });
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
        if (nameofc.equals("Koszulki")) {
            offersList = new ArrayList();
            offersList.add(new Offer("gray", "Gand2a", "T-shirt gray", 149, R.drawable.gray1, "gray", 1, "L"));
            offersList.add(new Offer("one", "Pior one", "overprint, 100% cotton", 41, R.drawable.one1, "black and white", 1, "M"));
            offersList.add(new Offer("car", "Carhart", "T-shirt oversized skate", 119, R.drawable.car1, "white", 1, "L"));
            offersList.add(new Offer("adas", "Adidas", "Black t-shirt adidas all stars", 99, R.drawable.adas1, "black", 1, "L"));
        } else {
            offersList = new ArrayList();
            offersList.add(new Offer("koszula", "Missk", "Jeans shirt, high quality", 29, R.drawable.koszula1, "blue", 1, "L"));
            offersList.add(new Offer("swtr", "Chpo", "Sunny sweater", 199, R.drawable.swtr1, "yellow", 2, "M"));
            offersList.add(new Offer("jeans", "Yourrun", "Traditional jeans skretch", 149, R.drawable.jeans1, "blue", 1, "M"));
            offersList.add(new Offer("gray", "Gand2a", "T-shirt gray", 149, R.drawable.gray1, "gray", 1, "L"));
            offersList.add(new Offer("jeans", "Yourrun", "Traditional jeans skretch", 149, R.drawable.jeans1, "blue", 1, "M"));
        }
    }

    private void initList(RecyclerView view) {
        this.recyclerView = view;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //manager.setOrientation(RecyclerView.VERTICAL);

        //this.list.setHasFixedSize(false);

        if (getContext() != null) {
            offersListAdapter = new OffersListAdapter(getActivity(), offersList);
            this.recyclerView.setAdapter(offersListAdapter);
        }
    }

}
