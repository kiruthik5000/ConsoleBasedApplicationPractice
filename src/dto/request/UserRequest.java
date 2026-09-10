package dto.request;

import model.Designation;

public class UserRequest {
    private String userName;
    private String password;
    private String designation;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public UserRequest(String userName, String password, String designation) {
        this.userName = userName;
        this.password = password;
        this.designation = designation;
    }
}
