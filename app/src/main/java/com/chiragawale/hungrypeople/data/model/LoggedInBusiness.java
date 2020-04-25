package com.chiragawale.hungrypeople.data.model;

/**
 * Data class that captures user information for logged in Business retrieved from LoginRepository
 */
public class LoggedInBusiness {

    private String businessId;
    private String displayName;

    public LoggedInBusiness(String userId, String displayName) {
        this.businessId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return businessId;
    }

    public String getDisplayName() {
        return displayName;
    }
}
