package edu.njust.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory==null){
            try {
                reader = Resources.getResourceAsReader("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                return sqlSessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else{
            return sqlSessionFactory;
        }
    }
}