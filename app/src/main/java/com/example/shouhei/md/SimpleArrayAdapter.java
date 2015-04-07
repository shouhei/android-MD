package com.example.shouhei.md;

import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.util.Log;

/**
 * Created by shouhei on 15/04/06.
 */

public class SimpleArrayAdapter extends ArrayAdapter<SimpleData> {
    private LayoutInflater layoutInflater_;

    public SimpleArrayAdapter(Context context, int textViewResourceId, List<SimpleData> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        final SimpleData item = (SimpleData)getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.simple_list, null);
        }

        TextView textView;
        textView = (TextView)convertView.findViewById(R.id.text);
        textView.setText(item.getTitle());
        textView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.shouhei.md", "com.example.shouhei.md.ShowActivity");
                intent.putExtra("content_id", item.getId());
                //SubActivity の起動
                v.getContext().startActivity(intent);
                //Toast.makeText(v.getContext(), String.valueOf(item.getId()), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}