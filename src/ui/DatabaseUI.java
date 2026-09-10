package ui;

import Utils.InputHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUI {
    private final Connection con;
    public DatabaseUI(Connection con) {
        this.con = con;
    }
    public void start() {
        while (true) {
            System.out.println("==== Welcome to DB Management ====");
            System.out.println("1. print Tables");
            System.out.println("2. Show values in the table");
            System.out.println("3. Advanced Search");
            int choice = InputHandler.getNumericValue("Enter your choice");
            switch (choice) {
                case 1:
                    getTable();
                    break;
                case 2:
                    showValuesFromTable();
                    break;
                case 3:
                    multipleQuery();
                    break;
                default:
                    return;
            }
        }
    }

    private void getTable() {
        System.out.println("Tables Available:");
        try {
            PreparedStatement statement = con.prepareStatement("SHOW TABLES;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showValuesFromTable() {
        System.out.println("Select Table");
        try {
            getTable();
            String tableName = InputHandler.getStringValue("Enter the TableName");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM "+tableName+";");
            ResultSet rs = ps.executeQuery();
            System.out.println("Name \t|Department\t|Salary");
            while (rs.next()) {
                System.out.println(rs.getString(2)+"\t|"+rs.getString(3)+"\t|"+rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private String selectTable() {
        try {
            getTable();
            return InputHandler.getStringValue("Enter the tableName:");
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        return null;
    }

    private String[] selectOperation() throws IllegalArgumentException{
        System.out.println("1. Equals");
        System.out.println("2. Not Equals");
        System.out.println("3. <");
        System.out.println("4. >");
        int choice = InputHandler.getNumericValue("Enter your choice:");
        return switch (choice) {
            case 1 -> new String[]{"1", "equals"};
            case 2 -> new String[]{"1", "not equals"};
            case 3 -> new String[]{"2", "<"};
            case 4 -> new String[]{"2", ">"};
            default -> throw new IllegalArgumentException("Error");
        };
    }
    private String[] selectColumns(String type, String tableName) throws SQLException{
        PreparedStatement ps = con.prepareStatement("SHOW COLUMNS FROM "+tableName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (type.equals("1") && rs.getString(2).contains("varchar")) {
                System.out.println(rs.getString(1));
            } else if (type.equals("2") && rs.getString(2).contains("int")) {
                System.out.println(rs.getString(1));
            }
        }
        String value;
        String columnName = InputHandler.getStringValue("Enter the column Name:");
        if (type.equals("1")) {
            value = InputHandler.getStringValue("Enter the corresponding value:");
        } else {
            value = String.valueOf(InputHandler.getNumericValue("Enter the corresponding value:"));
        }
        return new String[]{columnName,value};
    }

    private void performOperation(String tableName, String operation, String columnName, String value) throws SQLException{
        String commonStatement = "SELECT * FROM "+tableName+" WHERE "+columnName;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (operation.equals("equals")) {
            ps = con.prepareStatement(commonStatement+"=?;");
        }
        if (operation.equals("not equals")) {
            ps = con.prepareStatement(commonStatement+"!=?;");
        }
        if (operation.equals("<")) {
            ps = con.prepareStatement(commonStatement+"<?;");
        }
        if (operation.equals(">")) {
            ps = con.prepareStatement(commonStatement+">?;");
        }
        if (ps != null) {
            ps.setString(1, value);
            rs = ps.executeQuery();
        }
        if (rs != null) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
        }
    }

    private void multipleQuery() {
        try {
            String tableSelected = selectTable();
            String[] operation = selectOperation();
            String[] values = selectColumns(operation[0], tableSelected);
            performOperation(tableSelected, operation[1], values[0], values[1]);
        }catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}
