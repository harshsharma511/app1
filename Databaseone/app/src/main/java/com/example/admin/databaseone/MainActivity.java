package com.example.admin.databaseone;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {

            SQLiteDatabase myDatabase= this.openOrCreateDatabase( "Users",MODE_PRIVATE,null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
            myDatabase.execSQL("UPDATE users SET age=2 WHERE name='Harsh'");

            Cursor c =myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%h%' ",null);

            int nameIndex =c.getColumnIndex("name");
            int ageIndex=c.getColumnIndex("age");
            c.moveToFirst();
            while (c!=null)
            {
                Log.i("name",c.getString(nameIndex));
                Log.i("age",Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
