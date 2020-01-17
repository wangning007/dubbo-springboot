package com.inspur.mybatis.mapper;


import com.inspur.domain.model.SysRole;
import com.inspur.domain.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

/**
 * @author wang.ning
 * @create 2020-01-15 12:07
 */
public class UserMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){
        try{
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            List<User> list = sqlSession.selectList("findAll");
            for(User user:list){
                System.out.println(user.getIntId()+":"+user.getUsername()+":"+user.getAddress());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<User> userList = sysUserMapper.findAll();
            System.out.println("人员数量:"+userList.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testFindUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            User user = sysUserMapper.findUserById(123L);
            System.out.println("人员信息:" + user.getIntId() + ":" + user.getUsername() + ":");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findRolesByUserId(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysRole> roleList = sysUserMapper.findRolesByUserId(123L);
            System.out.println(roleList.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
