package com.example.shouhei.md;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.EditText;



public class EditActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.menu_save:
                saveText();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveText(){
        EditText content = (EditText)findViewById(R.id.edited_content);
        Text tx = new Text(content.getText().toString());
        tx.save();
        Toast.makeText(this, "保存しました", Toast.LENGTH_SHORT).show();
    }
}
