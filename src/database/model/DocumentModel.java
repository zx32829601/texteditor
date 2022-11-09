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
public class DocumentModel implements Serializable,Cloneable  {

    @Id
    @GeneratedValue
    public int documentId;
    public Document document;
    public Date updateTime;
    public Date createTime;

    public DocumentModel(Document document) {
        this.document = document;
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
}
