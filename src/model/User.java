package model;

public class User {
    private String name;
    private String password;
    private int UId;

    public String getPassword() {
        return password;
    }

    public Designation getDesignation() {
        return designation;
    }

    private final Designation designation;
    private double pendingAmt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }

    public double getPendingAmt() {
        return pendingAmt;
    }

    public void setPendingAmt(double pendingAmt) {
        this.pendingAmt = pendingAmt;
    }

    public User(String name, int UId, String password, double pendingAmt, Designation designation) {
        this.name = name;
        this.password = password;
        this.UId = UId;
        this.designation = designation;
        this.pendingAmt = pendingAmt;
    }
    @Override
    public String toString() {
        return "Unique Id: "+this.UId+"\nName: "+this.name+"\nDesignation: "+this.designation.name()+"\nPending Amount: "+this.pendingAmt;
    }
}
