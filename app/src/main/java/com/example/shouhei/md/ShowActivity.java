package com.example.shouhei.md;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.util.Log;

import com.activeandroid.query.Select;

import java.util.List;

import com.commonsware.cwac.anddown.AndDown;

public class ShowActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Bundle extras = getIntent().getExtras();
        List<Text> texts = new Select().from(Text.class).where("id = ?", extras.getLong("content_id")).orderBy("id DESC").execute();
        for(Text text : texts){
            WebView lv = (WebView)this.findViewById(R.id.show);
            AndDown prs = new AndDown();
            lv.loadData(prs.markdownToHtml(text.content), "text/html", null);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show, menu);
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
