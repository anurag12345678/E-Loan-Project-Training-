package com.cts.dao;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;


//NOTE: do not use @Repository or @Service  or @Component Annotation
abstract public class BaseDao extends NamedParameterJdbcDaoSupport {
	@Autowired
	public void setDataSource2(DataSource ds){
		
		super.setDataSource(ds);
	}

}
