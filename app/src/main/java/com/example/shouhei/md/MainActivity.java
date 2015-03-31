package com.example.shouhei.md;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.menu_add:
                contentAdd();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void contentAdd(){
        Toast.makeText(MainActivity.this,"追加", Toast.LENGTH_LONG).show();
        LinearLayout ll = (LinearLayout)this.findViewById(R.id.content);
        TextView str = new TextView(this);
        str.setText("added content");
        ll.addView(str);
    }
}
