package com.ritik.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeveloperActivity extends AppCompatActivity {
    private CircleImageView gmailIcon,instIcon,callIcon,msgIcon;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);


        getSupportActionBar().setTitle("Developer");

        gmailIcon=findViewById(R.id.gmailIcon);
        instIcon=findViewById(R.id.instaIcon);
        callIcon=findViewById(R.id.callIcon);
        msgIcon=findViewById(R.id.msgIcon);

        gmailIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"ritikmishra680@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please solve this queries");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });
        instIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/hrithik_mishra_/"));
                startActivity(browserIntent);
            }
        });

        callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +917860477740"));
                startActivity(iDial);
            }
        });
        msgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+917860477740")));
                iMsg.putExtra("sms_body","Please solve this issue ASAP");

                startActivity(iMsg);
            }
        });
    }
}