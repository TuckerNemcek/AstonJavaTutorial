package com.astontech.bo;

import java.util.Date;

public class TrainingData extends BaseBo {
    // PARAMETERS
    private int TrainingDataId;
    private int TrainingId;
    private int EntityYpeId;
    private int TrainingDataValue;
    private Date CreateDate;

    //CONSTRUCTORS
    public TrainingData(){}
    public TrainingData(int trainingDataId, int trainingId, int entityYpeId, int trainingDataValue, Date createDate) {
        this.setTrainingDataId(trainingDataId);
        this.setTrainingId(trainingId);
        this.setEntityYpeId(entityYpeId);
        this.setTrainingDataValue(trainingDataValue);
        this.setCreateDate(createDate);
    }

    //SET AND GET
    public int getTrainingDataId() {
        return TrainingDataId;
    }

    public void setTrainingDataId(int trainingDataId) {
        TrainingDataId = trainingDataId;
    }

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public int getEntityYpeId() {
        return EntityYpeId;
    }

    public void setEntityYpeId(int entityYpeId) {
        EntityYpeId = entityYpeId;
    }

    public int getTrainingDataValue() {
        return TrainingDataValue;
    }

    public void setTrainingDataValue(int trainingDataValue) {
        TrainingDataValue = trainingDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
