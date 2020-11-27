package com.hasan.i170272_i170322;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class Second extends AppCompatActivity {
    EditText name,phno,email;
    Button ok;

    ImageView dp;
    Uri selection;
//    FirebaseDatabase db;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dbref=FirebaseDatabase.getInstance()
                .getReference("contacts");

        dp=findViewById(R.id.dp);
        name=findViewById(R.id.name);
        phno=findViewById(R.id.phno);
        email=findViewById(R.id.email);
        ok=findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StorageReference stoRef= FirebaseStorage.getInstance().getReference();
                stoRef=stoRef.child("dps/"+name.getText().toString()+"dp.jpg");
                stoRef.putFile(selection).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> task=taskSnapshot.getStorage().getDownloadUrl();

                        task.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String dp=uri.toString();
                                dbref.push().setValue(
                                        new Contact(
                                                name.getText().toString(),
                                                phno.getText().toString(),
                                                email.getText().toString(),
                                                dp
                                        )
                                );
                                finish();
                            }
                        });
                    }
                });
            }
        });

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 200);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            selection=data.getData();
            dp.setImageURI(selection);
        }
    }
}