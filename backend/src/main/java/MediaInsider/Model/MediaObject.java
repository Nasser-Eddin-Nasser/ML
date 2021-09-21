package MediaInsider.Model;

import java.util.Date;
import java.util.UUID;

public class MediaObject {
    private long id;
    private String name;
    private MediaType type;
    private String description;
    private Date uploadDate;
    private String uploadBy;
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

    public void setId(long id) {
        this.id = id;
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
