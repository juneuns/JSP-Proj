package com.increpas.www.vo;

public class Review {
    Integer id;
    String text;
    Integer rating; // 평점을 위한 필드추가    
    Integer bookId;
    Integer userId;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "Review [id=" + id + ", text=" + text + ", rating=" + rating + ", bookId=" + bookId + ", userId="
                + userId + "]";
    }
}

