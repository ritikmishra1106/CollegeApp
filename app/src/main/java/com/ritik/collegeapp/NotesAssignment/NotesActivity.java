package com.ritik.collegeapp.NotesAssignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ritik.collegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity {
    private RecyclerView notesRecycler;
    private DatabaseReference reference;
    List<NotesData>list;
    private NotesAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notes/Assignment");


        notesRecycler=findViewById(R.id.notesRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");
        shimmerFrameLayout=findViewById(R.id.shimmer_view_container);
        shimmerLayout=findViewById(R.id.shimmer_layout);

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
               for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                   NotesData data = dataSnapshot.getValue(NotesData.class);
                   list.add(data);
               }
               adapter=new NotesAdapter(NotesActivity.this,list);
               notesRecycler.setLayoutManager(new LinearLayoutManager(NotesActivity.this));
               notesRecycler.setAdapter(adapter);
               shimmerFrameLayout.stopShimmer();
               shimmerLayout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(NotesActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }
}