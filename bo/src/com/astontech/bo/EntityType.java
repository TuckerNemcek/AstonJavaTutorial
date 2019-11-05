package com.astontech.bo;

public class EntityType extends BaseBo {

    //region PROPERTIES

    private int EntityTypeId;
    private Entity entity;
    private String EntityName;

    //endregion

    //regionCONSTRUCTORS
    public EntityType(){};

    public EntityType(int entityTypeId, String entityName) {
        this.setEntityTypeId(entityTypeId);
        this.setEntityName(entityName);
    }

    // endregion

    //region GET AND SET
    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }
}
