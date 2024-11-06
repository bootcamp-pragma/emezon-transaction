package com.emezon.transaction.domain.models;

import java.time.LocalDateTime;

public class Supply {

    private String id;
    private int quantity;
    private String articleId;
    private String suppliedById;
    private String comments;
    private Double cost;
    private LocalDateTime restockDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Supply() { }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getArticleId() {
        return articleId;
    }

    public String getSuppliedById() {
        return suppliedById;
    }


    public String getComments() {
        return comments;
    }


    public Double getCost() {
        return cost;
    }

    public LocalDateTime getRestockDate() {
        return restockDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static SupplyBuilder builder() {
        return new SupplyBuilder();
    }

    public static class SupplyBuilder {
        private String id;
        private int quantity;
        private String articleId;
        private String suppliedById;
        private String comments;
        private Double cost;
        private LocalDateTime restockDate;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public SupplyBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SupplyBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public SupplyBuilder articleId(String articleId) {
            this.articleId = articleId;
            return this;
        }

        public SupplyBuilder suppliedById(String suppliedById) {
            this.suppliedById = suppliedById;
            return this;
        }

        public SupplyBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public SupplyBuilder cost(Double cost) {
            this.cost = cost;
            return this;
        }

        public SupplyBuilder restockDate(LocalDateTime restockDate) {
            this.restockDate = restockDate;
            return this;
        }

        public SupplyBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public SupplyBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Supply build() {
            Supply supply = new Supply();
            supply.id = this.id;
            supply.quantity = this.quantity;
            supply.articleId = this.articleId;
            supply.suppliedById = this.suppliedById;
            supply.comments = this.comments;
            supply.cost = this.cost;
            supply.restockDate = this.restockDate;
            supply.createdAt = this.createdAt;
            supply.updatedAt = this.updatedAt;
            return supply;
        }
    }

}
