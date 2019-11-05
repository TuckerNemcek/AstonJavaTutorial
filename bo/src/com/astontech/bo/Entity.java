package com.astontech.bo;

public class Entity extends BaseBo {
    //PARAMETERS
    private int EntityId;
    private String EntityName;
    private EntityType entityType;

    //CONSTRUCTORS
    public Entity(){

    }


    public Entity(int entityId, String entityName) {
        this.setEntityId(entityId);
        this.setEntityName(entityName);
        this.entityType = new EntityType();
    }

    // GET AND SET


    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }
}
