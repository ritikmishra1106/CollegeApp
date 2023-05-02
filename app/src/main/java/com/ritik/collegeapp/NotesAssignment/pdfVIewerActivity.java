package com.ritik.collegeapp.NotesAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.ritik.collegeapp.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class pdfVIewerActivity extends AppCompatActivity {
    private String url;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Pdf Viewer");

        setContentView(R.layout.activity_pdf_viewer);
        url = getIntent().getStringExtra("pdfUrl");

        pdfView=findViewById(R.id.pdfView);
        new PdfDownload().execute(url);

    }

    private class PdfDownload extends AsyncTask<String,Void, InputStream>{
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(pdfVIewerActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
               if (urlConnection.getResponseCode()==200){
                   inputStream= new BufferedInputStream(urlConnection.getInputStream());
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            progressDialog.dismiss();
            pdfView.fromStream(inputStream)
                    .load();


        }


    }
}