package com.kpvelocite2015.ijarak.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.SessionManager;
import com.kpvelocite2015.ijarak.fragment.ReportedFragment;
import com.kpvelocite2015.ijarak.fragment.RequestJemputFragment;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FloatingActionButton mFAB;

    private static final int PROFILE_SETTING = 1;

    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;

    private String email, name;
    private int id;

    private TextView namaJalanTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

        SessionManager sessionManager = new SessionManager(this);
        name = sessionManager.getUserDetails().get("name");
        email = sessionManager.getUserDetails().get("email");

        setupAccountHeader(savedInstanceState);

        setupDrawer(savedInstanceState);

        result.setSelectionByIdentifier(1);

        setupFAB();

    }

    public void setupAccountHeader(Bundle savedInstanceState){

        final IProfile profile = new ProfileDrawerItem().withName(name).withEmail("081275953368");

        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        profile,
                        new ProfileSettingDrawerItem().withName("Manage Account").withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(PROFILE_SETTING)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile iProfile, boolean b) {
                        if (iProfile instanceof IDrawerItem && ((IDrawerItem) iProfile).getIdentifier() == PROFILE_SETTING) {
                            System.out.println("masuk sini");

                            headerResult.setActiveProfile(iProfile);

                            Intent intent = new Intent(HomeActivity.this, EditProfileActivity.class);
                            startActivity(intent);

                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

    public void setupDrawer(Bundle savedInstanceState){
        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Request Jemput Cucian").withIcon(GoogleMaterial.Icon.gmd_location_searching).withIdentifier(1).withCheckable(false),
                        new PrimaryDrawerItem().withName("Lihat Cucian").withIcon(GoogleMaterial.Icon.gmd_location_city).withIdentifier(2).withCheckable(false),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Logout").withIcon(GoogleMaterial.Icon.gmd_arrow_back).withIdentifier(10).withTag("Bullhorn")
                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        // update the main content by replacing fragments
                        System.out.println(drawerItem.getIdentifier());

                        if (drawerItem != null && drawerItem instanceof Nameable) {
                            getSupportActionBar().setTitle(((Nameable) drawerItem).getName());

                            result.setSelectionByIdentifier(drawerItem.getIdentifier(), false);

                            Fragment fragment = null;
                            switch (drawerItem.getIdentifier()) {
                                case 1:
                                    fragment = new RequestJemputFragment();
                                    break;
                                case 2:
                                    fragment = new ReportedFragment();
                                    break;
                                case 10:
                                    SessionManager sessionManager = new SessionManager(HomeActivity.this);
                                    sessionManager.logoutUser();
                                    break;
                            }
                            if (fragment != null) {
                                FragmentManager fragmentManager = getFragmentManager();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.container, fragment)
                                        .commit();
                            }
                        }

                        return false;
                    }
                })
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View view) {

                    }

                    @Override
                    public void onDrawerClosed(View view) {

                    }

                    @Override
                    public void onDrawerSlide(View view, float v) {
                        onDrawerSlid(v);
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();
    }

    private void setupFAB() {
        //define the icon for the main floating action button_background
        ImageView iconFAB = new ImageView(this);
        iconFAB.setImageResource(R.drawable.ic_action_new);

        //set the appropriate background for the main floating action button_background along with its icon
        mFAB = new FloatingActionButton.Builder(this)
                .setContentView(iconFAB)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HomeActivity.this, AddLaporanActivity.class);
                //startActivity(intent);
            }
        });
    }

    public void showFAB() {
        mFAB.setVisibility(View.VISIBLE);
    }

    public void hideFAB() {
        mFAB.setVisibility(View.INVISIBLE);
    }

    public void onDrawerSlid(float slideOffset) {
        toggleTranslateFAB(slideOffset);
    }

    private void toggleTranslateFAB(float slideOffset) {
        mFAB.setTranslationX(slideOffset * 300);
    }

    public void setNamaJalanTV(String namaJalan){
        namaJalanTV.setText(namaJalan);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        //super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button_background, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            finish();
        }
    }

}
