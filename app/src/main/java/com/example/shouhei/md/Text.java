package com.example.shouhei.md;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import java.util.Date;
/**
 * Created by shouhei on 15/04/03.
 */
@Table(name = "Text")
public class Text extends Model {

    @Column(name = "Content")
    public String content;
    @Column(name = "Created")
    public Date created;
    @Column(name = "Updated")
    public Date updated;

    public Text(){
        super();
    }

    public Text(String content) {
        super();
        this.content = content;
        this.created = new Date();
        this.updated = new Date();
    }
}