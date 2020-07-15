package com.example.zalandoapp.ui.TabbedFragments.TabBasket;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;
import com.example.zalandoapp.ui.TabbedFragments.TabFavourites.FavouritesAdapter;
import com.example.zalandoapp.ui.TabbedFragments.TabFavourites.TabFavouriteViewModel;

import java.util.ArrayList;

public class TabBasketFragment extends Fragment {

    private TabBasketViewModel mViewModel;
    private RecyclerView recyclerView;
    private ArrayList<Offer> basketList;
    private BasketAdapter basketAdapter;
    private NavController navController;

    public static TabBasketFragment newInstance() {
        return new TabBasketFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root =inflater.inflate(R.layout.tab_basket_fragment, container, false);


        fillList();
        setAmount(root);


        this.initList((RecyclerView) root.findViewById(R.id.recycleViewfav));

        return root;
    }

    private void setAmount(View view) {
        TextView itemAmount;
        itemAmount = view.findViewById(R.id.itemAmount);
        String xd = Integer.toString(basketList.size());
        String[]tab=xd.split("");

        if (basketList.size()%5==0 | tab[tab.length - 1].equals("6") | tab[tab.length - 1].equals("7")
                | tab[tab.length - 1].equals("8") | tab[tab.length - 1].equals("9")) {
            itemAmount.setText(basketList.size() + " artykułów: wysyłka przez zalando");
        }
        else if(basketList.size()==1){
            itemAmount.setText(basketList.size() +" artykuł: wysyłka przez zalando");
        }
        else {
            itemAmount.setText(basketList.size() +" artykuły: wysyłka przez zalando");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TabBasketViewModel.class);


    }

    private void initList(RecyclerView view) {
        this.recyclerView = view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //manager.setOrientation(RecyclerView.VERTICAL);

        //this.list.setHasFixedSize(false);

        if (getContext() != null) {
            basketAdapter = new BasketAdapter(getActivity(), basketList);
            this.recyclerView.setAdapter(basketAdapter);
        }


    }

    private void fillList(){
        basketList = new ArrayList();
        basketList.add(new Offer("jeans","Yourrun","Traditional jeans skretch",149,R.drawable.jeans1,"blue", 1,"M"));
        basketList.add(new Offer("sweater","Topwoman","Sweater hot cofre",99,R.drawable.sweater1, "beige",1,"M"));
        basketList.add(new Offer("jeans","Yourrun","Traditional jeans skretch",149,R.drawable.jeans1,"blue", 1,"M"));
        basketList.add(new Offer("jeans","Yourrun","Traditional jeans skretch",149,R.drawable.jeans1,"blue", 1,"M"));
        basketList.add(new Offer("jeans","Yourrun","Traditional jeans skretch",149,R.drawable.jeans1,"blue", 1,"M"));
        basketList.add(new Offer("shirtsport","Adidas","Unisex T-shirt CREW NECK",49,R.drawable.shirtsport1, "dark blue",1,"L"));



    }
}



