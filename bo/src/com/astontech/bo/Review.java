package com.astontech.bo;

import java.util.Date;

public class Review extends BaseBo {
    //PARAMETERS
    private int ReviewId;
    private Employee employee;
    private String ReviewName;
    private Date ReviewDate;

    //CONSTRUCTORS
    public Review(){}
    public Review(int reviewId, String reviewName, Date reviewDate) {
        this.setReviewId(reviewId);
        this.setReviewName(reviewName);
        this.setReviewDate(reviewDate);
    }

    //SET AND GET
    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getReviewName() {
        return ReviewName;
    }

    public void setReviewName(String reviewName) {
        ReviewName = reviewName;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        ReviewDate = reviewDate;
    }
}
