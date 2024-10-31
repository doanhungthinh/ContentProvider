package com.example.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contentprovider.Model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {
    private static final  int REQUEST_CODE_ASK_PERMISSIONS = 1001;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_ba);
        addControl();
        showAllContactFromDevice();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void addControl(){
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);
    }
    private void showAllContactFromDevice(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while(cursor.moveToNext()){
            String tenCotname = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vitricotname = cursor.getColumnIndex(tenCotname);
            int vitricotphne = cursor.getColumnIndex(tenCotPhone);
            String name = cursor.getString(vitricotname);
            String phone = cursor.getString(vitricotphne);
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
             adapterDanhBa.notifyDataSetChanged();

        }
    }
}