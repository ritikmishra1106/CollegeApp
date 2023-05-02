package com.ritik.collegeapp.NotesAssignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ritik.collegeapp.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private Context context;
    private List<NotesData>list;

    public NotesAdapter(Context context, List<NotesData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_item_layout,parent,false);

        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, @SuppressLint("RecyclerView") int position) {
     holder.pdfTitle.setText(list.get(position).getPdfTitle());

     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent  intent= new Intent(context,pdfVIewerActivity.class);
             intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
             context.startActivity(intent);
         }
     });
     holder.notesDownload.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(Intent.ACTION_VIEW);
             intent.setData(Uri.parse(list.get(position).getPdfUrl()));
             context.startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        private final TextView pdfTitle;
        private final ImageView notesDownload;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            pdfTitle=itemView.findViewById(R.id.notesName);
            notesDownload=itemView.findViewById(R.id.notesDownload);

        }
    }
}
