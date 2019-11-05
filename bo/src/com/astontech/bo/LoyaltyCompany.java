package com.astontech.bo;

public class LoyaltyCompany extends BaseBo {
    //PARAMETERS
    private int LoyaltyCompanyId;
    private int EntityTypeId;
    private String CompanyName;

    //CONSTRUCTORS
    public LoyaltyCompany(){}
    public LoyaltyCompany(int loyaltyCompanyId, int entityTypeId, String companyName) {
        this.setLoyaltyCompanyId(loyaltyCompanyId);
        this.setEntityTypeId(entityTypeId);
        this.setCompanyName(companyName);
    }

    //SET AND GET
    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }
}
