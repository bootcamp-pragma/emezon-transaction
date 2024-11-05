package com.emezon.transaction.domain.models;

import java.time.LocalDateTime;

public class Supply {

    private String id;
    private int quantity;
    private String articleId;
    private String suppliedById;
    private String comments;
    private Double cost;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Supply() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getSuppliedById() {
        return suppliedById;
    }

    public void setSuppliedById(String suppliedById) {
        this.suppliedById = suppliedById;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
