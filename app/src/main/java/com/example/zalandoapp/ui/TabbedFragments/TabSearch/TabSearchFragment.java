package com.example.zalandoapp.ui.TabbedFragments.TabSearch;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zalandoapp.R;
import com.example.zalandoapp.entity.Category;
import com.example.zalandoapp.ui.TabbedFragments.TabFavourites.FavouritesAdapter;

import java.util.ArrayList;

public class TabSearchFragment extends Fragment {

    private TabSearchViewModel mViewModel;
    private RecyclerView recyclerView;
    private ArrayList<Category> categoriesList;
    private SearchAdapter searchAdapter;
    private NavController navController;

    public static TabSearchFragment newInstance() {
        return new TabSearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_search_fragment, container, false);

        fillList();

        this.initList((RecyclerView) root.findViewById(R.id.recycleViewfav));

        return root;
    }

    private void fillList() {
        categoriesList = new ArrayList<>();
        categoriesList.add(new Category("Odzież", new String[]{"Wszystko: Odzież", "Koszulki", "Koszule","Bluzy i swetry","Kurtki","" +
                "Spodnie","Garnitury","Bielizna"}));
        categoriesList.add(new Category("Obuwie", new String[]{"Wszystko: Obuwie","Sneakersy","Półbuty","Trampki","Buty zimowe","Kapce"}));
        categoriesList.add(new Category("Odkryj stylizacje", new String[]{"Wszystkie okazje","Klasyczny","Casual","Streatwear"}));
        categoriesList.add(new Category("Sport", new String[]{"Wszystko: sport","Dyscypliny sportowe","Odzież sportowa","Obuwie sportowe","Plecaki","Akcesoria"}));
        categoriesList.add(new Category("Akcesoria", new String[]{"Wszystko: Akcesoria","Torby i plecaki","Czapki i kapelusze","Zegarki","Okulary","Biżuteria"}));
        categoriesList.add(new Category("Kosmetyki", new String[]{"Wszystko: Kosmetki","Twarz","Ciało","Włosy","Zapachy","Higiena"}));
        categoriesList.add(new Category("Premium", new String[]{"Wszystko: Premium","Odzież","Obuwie","Torby","Akcesoria"}));
    }

    private void initList(RecyclerView view) {
        this.recyclerView = view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (getContext() != null) {
            searchAdapter = new SearchAdapter(getActivity(), categoriesList);
            this.recyclerView.setAdapter(searchAdapter);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TabSearchViewModel.class);
        // TODO: Use the ViewModel
    }

}
