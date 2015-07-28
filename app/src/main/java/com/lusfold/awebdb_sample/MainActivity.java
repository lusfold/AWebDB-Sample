package com.lusfold.awebdb_sample;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.lusfold.awebdb.AWebDB;

public class MainActivity extends AppCompatActivity {
    private static final String DBName = "awebdb";
    private TextView tvIPPort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDb();
        AWebDB.hook(this,DBName,8080);
        String ip=AWebDB.getLocalIPAddress();
        int port=AWebDB.getLocalServerPort();
        tvIPPort = (TextView) findViewById(R.id.tv_ip_port);
        tvIPPort.setText("IP:"+ip+" Port:"+port);
    }

    private void initDb(){
        String createTB = "CREATE TABLE IF NOT EXISTS USER(ID INT PRIMARY KEY ,NAME varchar(20))";
        SQLiteDatabase db = openOrCreateDatabase(DBName,MODE_PRIVATE, null);
        db.execSQL(createTB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
