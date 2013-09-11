package com.javahive.javadb.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface KlientDAO {
	@Select("SELECT * FROM klienci WHERE id = #{id}")
	public Klient selectKlient(long id);

	@Select("SELECT * FROM klienci")
	public List<Klient> selectKlienci();
}
