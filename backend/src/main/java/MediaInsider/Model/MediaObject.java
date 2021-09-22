package MediaInsider.Model;

import javax.persistence.*;


import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "media")
public class MediaObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private MediaType type;
    @Column(name = "description")
    private String description;
    @Column(name = "uploadDate")
    private Date uploadDate;
    @Column(name = "uploadBy")
    private String uploadBy;
    @Column(name = "author")
    private String author;


    public MediaObject() {
    }

    public MediaObject(long id, String name, MediaType type, String description, Date uploadDate, String uploadBy, String author) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.uploadDate = uploadDate;
        this.uploadBy = uploadBy;
        this.author = author;
    }

    public MediaObject(String name, MediaType type, String description, Date uploadDate, String uploadBy, String author) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.uploadDate = uploadDate;
        this.uploadBy = uploadBy;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(String uploadBy) {
        this.uploadBy = uploadBy;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s , Type: %s ,Description: %s , UploadBy: %s , UploadDate: %s , Author: %s ", id, name, type, description, uploadBy, uploadDate, author);
    }
}
