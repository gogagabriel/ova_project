package com.ase.ova.dao.ro;

import com.ase.ova.ro.Person;

public interface IPersonDAO {
	 public String FIND_FIRST_EMPLOYEE = "select * from EMPLOYEES e where rownum < 2;";
	 public Person findFirstEmployee();
}
