package com.dnu.check.health.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class DBUtility {
	
	public static boolean tableExists(final Session hsess, final String tableName) throws HibernateException, SQLException {
	      Boolean result = false;
	      Connection connection = hsess.getSessionFactory().getSessionFactoryOptions().getServiceRegistry().
	                getService(ConnectionProvider.class).getConnection();
	      if(connection != null)
	      {
	          ResultSet tables = connection.getMetaData().getTables(null,null,tableName,null);
	          while(tables.next())
	          {
	              String currentTableName = tables.getString("TABLE_NAME");
	              if(currentTableName.equals(tableName))
	              {
	                  result = true;
	              }
	          }
	          tables.close();
	      }
	      return result;
	  }
}
