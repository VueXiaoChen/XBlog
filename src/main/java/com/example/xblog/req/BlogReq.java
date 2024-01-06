package com.example.xblog.req;

public class BlogReq extends PageReq{
    private Integer id;

    private String title;

    private String descr;

    private String cover;

    private String tags;

    private Integer userId;

    private String date;

    private Integer readCount;

    private Integer categoryId;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogReq{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", cover='" + cover + '\'' +
                ", tags='" + tags + '\'' +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", readCount=" + readCount +
                ", categoryId=" + categoryId +
                ", content='" + content + '\'' +
                '}';
    }
}
