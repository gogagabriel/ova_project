package com.ase.ova.dao.ro;

import java.util.List;

public interface IEmployeeBusinessService {
	 public String FIND_ALL_EMPLOYEE = "select * from EMPLOYEES";
	 public List<Person> findAllEmployee();
}
