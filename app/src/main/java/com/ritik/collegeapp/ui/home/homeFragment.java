package com.ritik.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ritik.collegeapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class homeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private ImageView map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout=view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();

        map =view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        return view;
    }

    private void openMap() {
        Uri uri =Uri.parse("geo:0,0?q=KNIPSS Faridipur Campus, NH96, Chandpur Saido Patti, Uttar Pradesh");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for (int i=0;i<6;i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageDrawable(R.drawable.img_a);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.img_b);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.img_c);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.img_d);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.img_e);
                    break;
                case 5:
                    sliderView.setImageDrawable(R.drawable.img_f);
                    break;

            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderLayout.addSliderView(sliderView);
        }
    }
}