package com.example.zalandoapp.ui.TabbedFragments.offerDetails;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zalandoapp.R;
import com.example.zalandoapp.ui.TabbedFragments.TabBasket.TabBasketFragment;
import com.example.zalandoapp.ui.TabbedFragments.TabBasket.TabBasketViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class OfferDetailsFragment extends Fragment {

    private OfferDetailsViewModel mViewModel;
    private NavController navController;
    private FloatingActionButton buttonBasket;
    private FloatingActionButton buttonFavourite;

    public static OfferDetailsFragment newInstance() {
        return new OfferDetailsFragment();
    }



    ArrayList<Integer> imageList = new ArrayList<>(Arrays.asList(
            R.drawable.jeans1,R.drawable.jeans2,R.drawable.jeans3,R.drawable.jeans4));

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.offer_details_fragment, container, false);

        GridView gridView = root.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(imageList,getContext()));
        buttonBasket= root.findViewById(R.id.buttonBask);
        buttonFavourite= root.findViewById(R.id.buttonFav);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        Bundle bundle = this.getArguments();
        String myItem = "";
        if (bundle != null) {
            myItem = bundle.getString("args");
        }

        setData(view, myItem);



        buttonBasket.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Fragment fragment = new TabBasketFragment();
                FragmentManager fragmentManager=((FragmentActivity) getActivity()).getSupportFragmentManager();

                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentManager.popBackStack();

            }


        });
        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void setData(View view, String myItem) {

        String[] data = myItem.split("/");

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        TextView color = view.findViewById(R.id.color);
        TextView price = view.findViewById(R.id.price);
        ImageView imageView = view.findViewById(R.id.myImageview);

        title.setText(data[0]);
        description.setText(data[1]);
        color.setText(data[2]);
        price.setText(data[3]+ " zł");

        String mainimage = data[4];
        imageView.setImageResource(view
                .getResources().getIdentifier(mainimage,"drawable",getContext().getOpPackageName()));

        //imageView.setImageResource(Integer.parseInt(xd));

        String idImage = data[4];
        for (int i = 0; i <8; i++) {
           // imageList+= getResources().getString(R.s)
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OfferDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}
