package com.ase.ova.dao.ro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOFactory {

	private static DAOFactory daoFac;

	static String URL = "jdbc:oracle:thin:@37.120.250.20:1521:oracle";
	static String USER = "MS_DBA";
	static String PASS = "oracle";
	static Connection conn;
	static Statement stmt;
	static String Sql;

	private void registerDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void getConnection() {
		try {
			System.out.println("Conexiunea a fost deschisa");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void executeStatement(String sql) {
		System.out.println("Se va executa query " + sql);
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;

		System.out.println("Creare query...");

		try {
			pstmt = conn.prepareStatement(sql);
			cstmt = conn.prepareCall(sql);
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Eroare la crearea query");
		}

	}

	static {

		daoFac = new DAOFactory();

	}

	public DAOFactory() {
		registerDriver();
	}

	public static DAOFactory getInstance() {

		getConnection();

		return daoFac;

	}

	public List<Person> getEmployeesDAO() {
		List<Person> listPerson = new ArrayList<Person>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			this.stmt = stmt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery(IEmployeeBusinessService.FIND_ALL_EMPLOYEE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int contor =1;
		try {
			while (rs.next()) {
				Person person = null;
				String nume = rs.getString("last_name");
				String prenume = rs.getString("first_name");
				String sex = rs.getString("gender");
				person = new Person(String.valueOf(contor), nume, prenume, sex);
				listPerson.add(person);
				contor ++ ;
				System.out.println(nume + " " + prenume + " " + sex + " " + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPerson;// new PersonBusinessServiceImpl(daoFac.conn);

	}
}