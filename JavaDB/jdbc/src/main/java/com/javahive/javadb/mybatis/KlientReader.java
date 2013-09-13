package com.javahive.javadb.mybatis;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import static com.javahive.javadb.jdbc.ConnectionData.*;

public class KlientReader {

	public void read() {

		SqlSession session = setupFactory();
		
		KlientDAO kd=session.getMapper(KlientDAO.class);
		Klient k= kd.selectKlient(1);
		System.out.println(k);
		System.out.println(k.getNazwisko());
		System.out.println(kd.selectKlienci().size());
		session.close();

	}

	private SqlSession setupFactory() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USER);
		dataSource.setPassword(DB_PASS);

		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(KlientDAO.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(configuration);
		
		sqlSessionFactory.openSession();
		
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}


}
