package com.example.zalandoapp.ui.TabbedFragments;

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

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Offer;

import java.util.ArrayList;

public class TabMainPageFragment extends Fragment {

    private TabMainPageViewModel mViewModel;
    private NavController navController;
    private ArrayList<Offer> propositionsList;
    private PropositionsHorizontalAdapter propositionsHorizontalAdapter;
    private RecyclerView propostionsRecyclerView;

    public static TabMainPageFragment newInstance() {
        return new TabMainPageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_main_page_fragment, container, false);

        setPropositions();
        this.initList((RecyclerView) root.findViewById(R.id.recyclerViewPropostions));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        //button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.categoriesFragment, null));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TabMainPageViewModel.class);
        // TODO: Use the ViewModel
    }

    private void initList(RecyclerView view) {
        this.propostionsRecyclerView = view;
        propostionsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        //manager.setOrientation(RecyclerView.VERTICAL);

        //this.list.setHasFixedSize(false);

        if (getContext() != null) {
            propositionsHorizontalAdapter = new PropositionsHorizontalAdapter(getActivity(), propositionsList);
            this.propostionsRecyclerView.setAdapter(propositionsHorizontalAdapter);
        }
    }

    private void setPropositions() {


        propositionsList = new ArrayList<>();
        propositionsList.add(new Offer("shirtsport","Adidas","Unisex T-shirt CREW NECK",49,R.drawable.shirtsport1, "dark blue",1,"L"));
        propositionsList.add(new Offer("sweater","Topwoman","Sweater hot cofre",99,R.drawable.sweater1, "beige",1,"M"));
        propositionsList.add(new Offer("jeans","Yourrun","Traditional jeans skretch",149,R.drawable.jeans1,"blue",1,"M"));
        propositionsList.add(new Offer("sweater","Topwoman","Sweater hot cofre",99,R.drawable.sweater1, "beige",1,"M"));
        propositionsList.add(new Offer("sweater","Topwoman","Sweater hot cofre",99,R.drawable.sweater1, "beige",1,"M"));
    }
}
