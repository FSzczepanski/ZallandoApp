package com.example.zalandoapp.ui.TabbedFragments.offerDetails;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.ui.TabbedFragments.TabBasket.TabBasketViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class OfferDetailsFragment extends Fragment {

    private OfferDetailsViewModel mViewModel;
    private NavController navController;

    public static OfferDetailsFragment newInstance() {
        return new OfferDetailsFragment();
    }

    ArrayList<Integer> imageList = new ArrayList<>(Arrays.asList(
            R.drawable.jeans,R.drawable.jeans2,R.drawable.jeans3,R.drawable.jeans4));

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.offer_details_fragment, container, false);

        GridView gridView = root.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(imageList,getContext()));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        //button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.categoriesFragment, null));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OfferDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}
