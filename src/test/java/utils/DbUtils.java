package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    public  static List<Map<String,String>>fetch(String query){
        /*String dbUrl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";*/
        String dbUrl = ConfigReader.read("dbUrl");
        String userName =ConfigReader.read("dbUserName");
        String password = ConfigReader.read("dbPassword");

        List<Map<String,String>> tableData = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            )
        {ResultSetMetaData rsm = resultSet.getMetaData();

            while (resultSet.next()){
                Map<String,String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= rsm.getColumnCount() ; i++) {
                    String key = rsm.getColumnLabel(i);
                    String value =resultSet.getString(i);
                    rowMap.put(key,value);

                }
                tableData.add(rowMap);
            }
        } catch (SQLException sqlException){

        }


        return tableData;

    }
}
