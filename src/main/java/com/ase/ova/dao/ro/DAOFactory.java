package com.ase.ova.dao.ro;

public class DAOFactory {

  private static DAOFactory daoFac;



  static{

    daoFac = new DAOFactory();

  }



  private DAOFactory(){}



  public static DAOFactory getInstance(){

    return daoFac;

  }



  public IPersonDAO getEmployeeDAO(){

    return new PersonDAOImpl();

  }

}