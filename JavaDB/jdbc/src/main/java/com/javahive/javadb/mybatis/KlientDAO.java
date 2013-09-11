package com.javahive.javadb.mybatis;

import org.apache.ibatis.annotations.Select;

public interface KlientDAO {
	String GET_PERSON_BY_ID = "SELECT * FROM klienci WHERE id = #{id}";
	@Select(GET_PERSON_BY_ID)
	public Klient selectKlient(long id);

}
