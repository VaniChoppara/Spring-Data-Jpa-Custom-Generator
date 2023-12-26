package com.app.generator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdCustomGenerator  implements IdentifierGenerator
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		String prefix="OD";
		String sufix="";
		
		try {
			JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
			Connection con = jdbcConnectionAccess.obtainConnection();
			Statement statement = con.createStatement();
			String query="select next_val from order_dtls_id_seq"; 
			ResultSet resultSet = statement.executeQuery(query);
			int idSufix=0;
			if(resultSet.next()){
				idSufix = resultSet.getInt(1);
				sufix=String.valueOf(idSufix);
			}
			String updatQuery="update order_dtls_id_seq set next_val = "+(idSufix +1);
			statement.executeUpdate(updatQuery);
			return prefix+sufix;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
