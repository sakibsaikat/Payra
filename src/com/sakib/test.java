package com.sakib;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

    public static void main(String[] args) {
        SwingModel ob = new SwingModel();

        String cmd = "SELECT * FROM hey";
        ResultSet r = ob.GetData(cmd);

        try {
            while(r.next()){
                String nm = r.getString("name");
                System.out.println(nm);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
