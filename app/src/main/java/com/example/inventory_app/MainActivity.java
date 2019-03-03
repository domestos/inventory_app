package com.example.inventory_app;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.inventory_app.fragments.authorization.AuthFragment;
import com.example.inventory_app.fragments.scanner.ScannerFragment;
import com.example.inventory_app.fragments.user.UserFragment;

public class MainActivity extends AppCompatActivity implements AuthFragment.AuthFragmnetListener, ScannerFragment.ScannerFragmentListener, UserFragment.UserFragmentListener {



    private AuthFragment authFragment;
    private ScannerFragment scannerFragment;
    private UserFragment userFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_auth:
                    fragmentTransaction.replace(R.id.container, authFragment).commit();
                    return true;
                case R.id.navigation_scanner:
                    fragmentTransaction.replace(R.id.container, scannerFragment).commit();
                    return true;
                case R.id.navigation_user:
                    fragmentTransaction.replace(R.id.container, userFragment).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /** init fragments*/
        authFragment = new AuthFragment();
        scannerFragment = new ScannerFragment();
        userFragment = new UserFragment();


    }


    @Override
    public void onAuthFragmentInteraction(Uri uri) {

    }

    @Override
    public void onScannerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onUserFragmentInteraction(Uri uri) {

    }
}
