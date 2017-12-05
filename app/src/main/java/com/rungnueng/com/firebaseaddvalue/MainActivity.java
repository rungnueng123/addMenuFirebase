package com.rungnueng.com.firebaseaddvalue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name,nameThai,description,ingredient,imgUrl;
    Button create,cancle,insert;
    FirebaseDatabase firebaseDatabase,database;
    DatabaseReference databaseReference,myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();
    }

    private void initInstance() {

        name = findViewById(R.id.edt_name);
        nameThai = findViewById(R.id.edt_name_thai);
        description = findViewById(R.id.edt_description);
        ingredient = findViewById(R.id.edt_ingredient);
        imgUrl = findViewById(R.id.edt_img_url);
        create = findViewById(R.id.btn_create);
        cancle = findViewById(R.id.btn_cancel);
        insert = findViewById(R.id.btn_insert);

        databaseReference = FirebaseDatabase.getInstance().getReference("menu");

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArrayList();

            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cleartxt();
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("message");

                myRef.setValue("Hello, World");

            }
        });
    }

    private void addArrayList() {

        String Name = name.getText().toString().trim();
        String NameThai = nameThai.getText().toString().trim();
        String Description = description.getText().toString().trim();
        String Ingredient = ingredient.getText().toString().trim();
        String ImgUrl = imgUrl.getText().toString().trim();

        if (TextUtils.isEmpty(Name)){
            Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(NameThai)){
            Toast.makeText(this,"Please Enter Your NameThai",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(Description)){
            Toast.makeText(this,"Please Enter Your Description",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(Ingredient)){
            Toast.makeText(this,"Please Enter Your Ingredient",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(ImgUrl)){
            Toast.makeText(this,"Please Enter Your ImgUrl",Toast.LENGTH_SHORT).show();
        }else{
            String id = databaseReference.push().getKey();
            Menu menu = new Menu();
            databaseReference.child(id).child("name").setValue(Name.toString());
            databaseReference.child(id).child("nameThai").setValue(NameThai.toString());
            databaseReference.child(id).child("description").setValue(Description.toString());
            databaseReference.child(id).child("ingredient").setValue(Ingredient.toString());
            databaseReference.child(id).child("imgUrl").setValue(ImgUrl.toString());
            Toast.makeText(this,"Menu is Add",Toast.LENGTH_SHORT).show();
            Cleartxt();

        }

    }

    private void Cleartxt() {
        name.setText("");
        nameThai.setText("");
        description.setText("");
        ingredient.setText("");
        imgUrl.setText("");
    }
}
