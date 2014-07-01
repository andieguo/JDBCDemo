package com.andieguo.jdbc;

import junit.framework.TestCase;

public class DBHelperTest extends TestCase {

	public void getConnectionTest(){
		System.out.println(DBConnection.getConnection());
	}
	
	public void queryAllByStatementTest(){
		DBHelper.queryAllByStatement();
	}
	
	public void queryAllByprepareStatementTest(){
		DBHelper.queryAllByprepareStatement();
	}
	
	public void queryByIdTest(){
		DBHelper.queryById(2);
	}
	
	public void queryByPrepareIdTest(){
		DBHelper.queryPrepareById(3);
	}
	
	public void queryByUserTest(){
		DBHelper.queryByUser("jack", "jack");
	}
	
	public void queryByUserInjectTest(){
		//DBHelper.queryByUser("hack", "' or '1'='1");
		DBHelper.queryByUser("hack", "' ; DROP TABLE user;select '0");
	}
	
	public void queryByPreparedUserTest(){
		DBHelper.queryPrepareByUser("jaxck", "jack");
	}
	
	public void queryByPreparedUserInjectTest(){
		DBHelper.queryPrepareByUser("hack", "' or '1'='1");
	}
}
