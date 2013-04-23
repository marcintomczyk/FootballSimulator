package com.tomczyk.football.base;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.internal.SessionImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Base class for other tests
 */
public class FootballBase {

	private static final Logger log = Logger.getLogger(FootballBase.class);

	protected static EntityManagerFactory emf;

	protected static EntityManager em;

	/*
	 * we want to invoke all tests which are in one class using the same
	 * transaction in case of any problems there will be rollback for everything
	 * 
	 * this is why the EntityManager is a static
	 */
	protected static EntityTransaction et;

	protected static IDatabaseConnection dbUnitConnection;
	private static IDataSet footballDataSet;

	@BeforeClass
	public static void setUpPredefinedData() throws SQLException,
			DatabaseUnitException, UnsupportedEncodingException {

		emf = Persistence.createEntityManagerFactory("footballLocalPU");

		em = emf.createEntityManager();

		dbUnitConnection = new DatabaseConnection(
				((SessionImpl) (em.getDelegate())).connection());

		
		// Loads the data set from a file named football-datasets.xml
		footballDataSet = new FlatXmlDataSetBuilder().build(Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("football-datasets.xml"));

	}

	@Before
	public void setUpEntityManager() throws DatabaseUnitException,
			SQLException, UnsupportedEncodingException {

		/*
		 * Set a database to a known state before each test
		 * The rule we follow is: tests should not rely on the success of previous ones
		 */

		log.info("Preparing the database");

		/*
		 * CLEAN_INSERT deletes existing data and inserts new ones
		 */
		DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, footballDataSet);

		log.info("Starting a new transaction for the test");
		et = em.getTransaction();

	}

	@AfterClass
	public static void tearDownPredefinedData() throws SQLException {

		dbUnitConnection.close();
		
		em.close();
		emf.close();

	}

}