package com.zy.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import com.zy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test1 {

    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        /*String statement = "com.zy.mapping.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);*/
        /*String statement = "com.zy.mapping.userMapper.addUser";
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        int user2 = session.insert(statement, user);
        session.commit();
        session.close();
        System.out.println(user2);*/
        //updateUser(session);
        //deleteUser(session);
        queryList(session);
    }
    
    public static void insertUser(SqlSession session){
    	String statement = "com.zy.mapping.userMapper.addUser";
    	User user = session.selectOne(statement, 1);
        System.out.println(user);
    }
    
    public static void selectUser(SqlSession session){
    	String statement = "com.zy.mapping.userMapper.getUser";
        User user = new User();
        user.setId(1);
        int user2 = session.insert(statement, user);
        session.commit();
        session.close();
        System.out.println(user2);
    }
    
    public static void updateUser(SqlSession session){
    	String statement = "com.zy.mapping.userMapper.updateUser";
    	User user = new User();
    	user.setId(6);
        user.setName("李四");
        user.setAge(20);
        int user2 = session.update(statement, user);
        session.commit();
        session.close();
        System.out.println(user2);
    }
    
    public static void deleteUser(SqlSession session){
    	String statement = "com.zy.mapping.userMapper.deleteUser";
    	User user = new User();
    	user.setId(6);
        int user2 = session.delete(statement, user);
        session.commit();
        session.close();
        System.out.println(user2);
    }
    
    public static void queryList(SqlSession session){
    	String statement = "com.zy.mapping.userMapper.queryForList";
    	List<Object> resultList = session.selectList(statement);
    	System.out.println(resultList);
    }
}