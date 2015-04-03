package com.example.shouhei.md;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;

import com.activeandroid.query.From;
import com.activeandroid.query.Select;

import java.util.List;




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

    @Override
    public void onResume() {
        super.onResume();
        List<Text> texts = new Select().from(Text.class).execute();
        LinearLayout ll = (LinearLayout)this.findViewById(R.id.content);
        ll.removeAllViews();
        for (Text text : texts) {
            // 更新
            TextView str = new TextView(this);
            String[] lines = text.content.split("\n");
            str.setText(lines[0]);
            ll.addView(str);
        }

    }

    private void contentAdd(){
        Intent intent = new Intent();
        intent.setClassName("com.example.shouhei.md", "com.example.shouhei.md.EditActivity");

        // SubActivity の起動
        startActivity(intent);
    }
}
