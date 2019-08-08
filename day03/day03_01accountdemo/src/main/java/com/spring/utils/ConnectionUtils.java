package com.spring.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 链接工具类，它用于从数据源中获取一个链接
 * 并且实现和线程的绑定
 */
public class ConnectionUtils {


    private ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的链接
     * @return
     */
    public Connection getThreadConnection(){
        try{
            //1.先从ThreadLocal获取
            Connection connection=threadLocal.get();
            //2.判断当前线程上是否有链接
            if (connection==null){
                //3.从数据源中获取一个链接并且存入ThreadLocal中
                connection=dataSource.getConnection();
                threadLocal.set(connection);
            }
            //4.返回当前线程上的链接
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    /**
     * 把链接和线程解绑
     */
    public  void removeConnection(){
        threadLocal.remove();
    }
}
