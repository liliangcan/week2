package com.atguigu.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.bean.User;

public class TestMybatis {

	@Test
	public void test() throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//getMapper():会通过动态代理动态生成UserMapper的代理实现类
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(mapper.getClass().getName());
		User user = mapper.getUserByUid("1");
		System.out.println(user);
		
	}

}
