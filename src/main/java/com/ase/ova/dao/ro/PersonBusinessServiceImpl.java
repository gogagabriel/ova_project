package com.ase.ova.dao.ro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonBusinessServiceImpl implements 

                                       IEmployeeBusinessService {

DAOFactory oraclDAO;
	
	
//	@Override
//	public Person findAllEmployee() {
//		registerDriver();
//		openConnection();
//		closeConnection();
//		return null;
//	}
//	
	
  public PersonBusinessServiceImpl(DAOFactory oraclDAO) {
		this.oraclDAO = oraclDAO;
	}

@Override
  public List<Person> findAllEmployee(){

    List<Person> empList = this.oraclDAO.getEmployeesDAO();

    //Person empList = empDAO.findAllEmployee();
	

    return empList;

  }
}