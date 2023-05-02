package com.ritik.collegeapp.ui.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ritik.collegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class aboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel>list;
    private ImageView map;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);
        list=new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_cs,"Computer Science","The Department of Computer Engineering was established in July 2008. The department offers a 4 (four) year course, in B. Tech. Computer Science &amp; Engineering"));
        list.add(new BranchModel(R.drawable.ic_me,"Mechanical Engineering","The Department of Mechanical Engineering was established in July 2008. The department offers a 4 (four) year course, in B. Tech. Mechanical  Engineering"));
        list.add(new BranchModel(R.drawable.baseline_person_outline_24,"Civil Engineering","The Department of Civil Engineering was established in July 2008. The department offers a 4 (four) year course, in B. Tech. Civil  Engineering"));

        adapter = new BranchAdapter(getContext(),list);
        viewPager=view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView=view.findViewById(R.id.college_Image);
        imageView.setImageResource(R.drawable.campus);

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
}