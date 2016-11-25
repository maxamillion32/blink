package com.example.voldemarius.hereandnow.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.voldemarius.hereandnow.R;
import com.example.voldemarius.hereandnow.tools.ViewPagerMapAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Voldemarius on 04.09.2016.
 */
public class NearbyFragment extends Fragment implements OnMapReadyCallback {

    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private SupportMapFragment map;
    private ViewPager viewPager;
    private ViewPagerMapAdapter viewPagerMapAdapter;

    public static NearbyFragment newInstance()
    {
        NearbyFragment nearbyFragment=new NearbyFragment();
        return nearbyFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.map_fragment,container,false);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.add(R.id.map, fragment);
        transaction.commit();
        fragment.getMapAsync(this);

        viewPager=(ViewPager)view.findViewById(R.id.map_fragment_viewpager);
        viewPagerMapAdapter=new ViewPagerMapAdapter(getFragmentManager());
        if (viewPager != null)
        {
            viewPager.setAdapter(viewPagerMapAdapter);
        }
        Bitmap image = BitmapFactory.decodeResource(view.getContext().getResources(),R.drawable.festival);
        viewPagerMapAdapter.addFragment(ViewPagerMapFragment.newInstance(image,"Rooftop basketball","Tomorrow at 11:00","2271 Frederick Douglass Boulvard"));
        viewPagerMapAdapter.addFragment(ViewPagerMapFragment.newInstance(image,"Rooftop basketball","Tomorrow at 11:00","2271 Frederick Douglass Boulvard"));

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(47.17, 27.5699), 16));
        googleMap.addMarker(new MarkerOptions()
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pin_1)) // Anchors the marker on the bottom left
                .position(new LatLng(47.17, 27.5699))
        .title("Here we go"));//Iasi, Romania

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)//Проверка, дал ли пользователь разрешение на определение локации
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        } else {
            Toast.makeText(getContext(),"Add permission to use 'my location'",Toast.LENGTH_LONG).show();
        }
    }

}
