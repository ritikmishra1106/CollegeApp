package com.ritik.collegeapp.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ritik.collegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class galleryFragment extends Fragment {
    private ProgressBar progressBar;
    RecyclerView convoRecycler,otherRecycler,indeRecycler,festRecycler,freshRecycler,yogaRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRecycler=view.findViewById(R.id.convoRecycler);
        otherRecycler=view.findViewById(R.id.othersRecycler);
        indeRecycler=view.findViewById(R.id.indeRecycler);
        festRecycler=view.findViewById(R.id.festRecycler);
        freshRecycler=view.findViewById(R.id.freshRecycler);
        yogaRecycler=view.findViewById(R.id.yogaRecycler);


        progressBar=view.findViewById(R.id.progressBar);

        reference= FirebaseDatabase.getInstance().getReference().child("Gallery");
        
        getConvoImage();
        getIndependenceDayImage();
        getOtherImages();
        getFestImages();
        getFreshImages();
        getYogaDayImages();

        return view;
    }

    private void getYogaDayImages() {
        reference.child("YOGA DAY").addValueEventListener(new ValueEventListener() {
            final List<String>imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Object data =dataSnapshot.getValue();
                    if (data instanceof String) {
                        String stringValue = (String) data;
                        // use stringValue
                        imageList.add(stringValue);
                    }

//                    String data = (String) dataSnapshot.getValue();
//                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                yogaRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
//                progressBar.setVisibility(View.GONE);
                yogaRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFreshImages() {
        reference.child("ABHIUDYA").addValueEventListener(new ValueEventListener() {
            final List<String>imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Object data =dataSnapshot.getValue();
                    if (data instanceof String) {
                        String stringValue = (String) data;
                        // use stringValue
                        imageList.add(stringValue);
                    }

//                    String data = (String) dataSnapshot.getValue();
//                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                freshRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                progressBar.setVisibility(View.GONE);
                freshRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFestImages() {
        reference.child("Sports Fest").addValueEventListener(new ValueEventListener() {
            final List<String>imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Object data =dataSnapshot.getValue();
                    if (data instanceof String) {
                        String stringValue = (String) data;
                        // use stringValue
                        imageList.add(stringValue);
                    }

//                    String data = (String) dataSnapshot.getValue();
//                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                festRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
//                progressBar.setVisibility(View.GONE);
                festRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIndependenceDayImage() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {
            final List<String>imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Object data =dataSnapshot.getValue();
                    if (data instanceof String) {
                        String stringValue = (String) data;
                        // use stringValue
                        imageList.add(stringValue);
                    }

//                    String data = (String) dataSnapshot.getValue();
//                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                indeRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
//                progressBar.setVisibility(View.GONE);
                indeRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getOtherImages() {
        reference.child("Others Events").addValueEventListener(new ValueEventListener() {
            final List<String>imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Object data =dataSnapshot.getValue();
                    if (data instanceof String) {
                        String stringValue = (String) data;
                        // use stringValue
                        imageList.add(stringValue);
                    }

//                    String data = (String) dataSnapshot.getValue();
//                    imageList.add(data);

                }
                adapter=new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                progressBar.setVisibility(View.GONE);
                otherRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            final List<String>imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Object data =dataSnapshot.getValue();
                    if (data instanceof String) {
                        String stringValue = (String) data;
                        // use stringValue
                        imageList.add(stringValue);
                    }
//                    String data = (String) dataSnapshot.getValue();
//                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
//                progressBar.setVisibility(View.GONE);
                convoRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}