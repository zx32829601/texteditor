package model;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.text.Document;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TextEnitity implements Serializable,Cloneable  {

    @Id
    @GeneratedValue
    public int documentId;
    public String text;
    public Date updateTime;
    public Date createTime;

    public TextEnitity(String t) {
        this.text = t;
    }
    @PrePersist
    void updateCreateDates(){
        updateTime=new Date();
        createTime=updateTime;


    }
    @PreUpdate
    void updateDates(){
        updateTime=new Date();
    }

    public void setText(String text) {
        this.text = text;
        updateDates();
    }
}
