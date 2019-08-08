package com.spring.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 */

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {

        /**
         * 1.注册驱动
         * 2.获取链接
         * 3.获取操作数据库的预处理对象
         * 4.执行SQL,得到结果集
         * 5.遍历结果集
         * 6.释放资源
         */

        //注册驱动
//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?useSSL=false","root","root");

        //获取操作数据库的预处理对象
        PreparedStatement preparedStatement=connection.prepareStatement("select * from account;");

        //执行SQL,得到结果集
        ResultSet resultSet=preparedStatement.executeQuery();

        //遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));

        }

        //释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();


    }
}
