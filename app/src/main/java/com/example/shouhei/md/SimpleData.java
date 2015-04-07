package com.example.shouhei.md;

import java.lang.Long;
import java.lang.String;
/**
 * Created by shouhei on 15/04/06.
 */
public class SimpleData {

    private Long id;
    private String title;


    SimpleData(Long id, String title){
        this.id = id;
        this.title = title;
    }

    public long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

}
