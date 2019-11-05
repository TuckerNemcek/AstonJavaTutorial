package com.astontech.bo;

public class LoyaltyAccount extends BaseBo {
    //PARAMETERS
    private int LoyaltyAccountId;
    private int EmployeeId;
    private int LoyaltyCompanyId;
    private String MemberNumber;

    //CONSTRUCTORS
    public LoyaltyAccount(){}
    public LoyaltyAccount(int loyaltyAccountId, int employeeId, int loyaltyCompanyId, String memberNumber) {
        this.setLoyaltyAccountId(loyaltyAccountId);
        this.setEmployeeId(employeeId);
        this.setLoyaltyCompanyId(loyaltyCompanyId);
        this.setMemberNumber(memberNumber);

    }

    //GET AND SET
    public int getLoyaltyAccountId() {
        return LoyaltyAccountId;
    }

    public void setLoyaltyAccountId(int loyaltyAccountId) {
        LoyaltyAccountId = loyaltyAccountId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public String getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        MemberNumber = memberNumber;
    }
}
