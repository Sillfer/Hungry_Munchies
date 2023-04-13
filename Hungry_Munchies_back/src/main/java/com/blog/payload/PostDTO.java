package com.blog.payload;

import com.blog.model.ECategory;
import com.blog.model.Status;

import java.util.Date;


public class PostDTO {
    private Long id;
    private String title;
    private String image;
    private String content;
    private Long authorId;
    private Date created_at;
    private Date updated_at;
    private ECategory category;
    private Status status;

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String image, String content, Long authorId, Date created_at, Date updated_at, ECategory category, Status status) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.authorId = authorId;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.category = category;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}

