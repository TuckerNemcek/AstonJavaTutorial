package com.astontech.bo;

import java.util.Date;

public class ReviewData extends BaseBo {
    //PARAMETERS
    private int ReviewDataId;
    private int ReviewId;
    private int EntityTypeId;
    private int ReviewDateValue;
    private Date CreateDate;

    //CONSTRUCTORS
    public ReviewData(){}
    public ReviewData(int reviewDataId, int reviewId, int entityTypeId, int reviewDateValue, Date createDate) {
        this.setReviewDataId(reviewDataId);
        this.setReviewId(reviewId);
        this.setEntityTypeId(entityTypeId);
        this.setReviewDateValue(reviewDateValue);
        this.setCreateDate(createDate);
    }

    // SET AND GET
    public int getReviewDataId() {
        return ReviewDataId;
    }

    public void setReviewDataId(int reviewDataId) {
        ReviewDataId = reviewDataId;
    }

    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getReviewDateValue() {
        return ReviewDateValue;
    }

    public void setReviewDateValue(int reviewDateValue) {
        ReviewDateValue = reviewDateValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
