package com.ase.ova.dao.ro;

public class PersonBusinessServiceImpl implements 

                                       IEmployeeBusinessService {



  public Person findFirstEmployee(){

    IPersonDAO empDAO = DAOFactory.getInstance()

                                    .getEmployeeDAO();

    Person empList = empDAO.findFirstEmployee();
	

    return empList;

  }
}