package com.example.zalandoapp.utility;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.zalandoapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavController.OnDestinationChangedListener{
    private NavController navController;
    private View backButtonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initTabbedFragments();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    public void initTabbedFragments(){
        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabMainPage = findViewById(R.id.tabMainPageFragment);
        TabItem tabSearch = findViewById(R.id.tabSearchFragment);
        TabItem tabFavourite = findViewById(R.id.tabFavouriteFragment);
        TabItem tabCalls = findViewById(R.id.tabBasketFragment);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 4);

        viewPager.setAdapter(pagerAdapter);


        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


    }

    @Override
    public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

        boolean showBackButton = getListOfDestinationsWithBackButton().contains(destination.getId());
        adjustActionBar(showBackButton);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private List<Integer> getListOfDestinationsWithBackButton() {
        return Arrays.asList(
                R.id.offerDetailsFragment
        );
    }

    private void adjustActionBar(boolean showBackButton) {
        if(showBackButton && !isBackButtonVisible()) {
            adjustActionBarWithBackButton();
        } else if(!showBackButton && isBackButtonVisible()) {
            adjustActionBarWithoutBackButton();
        }
    }
    private void adjustActionBarWithBackButton() {
        int width = 0;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        this.backButtonContainer.setLayoutParams(new LinearLayout.LayoutParams(width, height, 0.1f));

        this.backButtonContainer.setVisibility(View.VISIBLE);
    }

    private void adjustActionBarWithoutBackButton() {

        int width = 0;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        this.backButtonContainer.setLayoutParams(new LinearLayout.LayoutParams(width, height, 0));
        this.backButtonContainer.setVisibility(View.GONE);

    }

    private boolean isBackButtonVisible() {
        return this.backButtonContainer.getVisibility() == View.VISIBLE;
    }

}
