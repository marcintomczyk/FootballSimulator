package com.tomczyk.football.arquillian.base;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.tomczyk.football.util.Resources;

public class FootballSimulatorDeployment {

	public static WebArchive deployment() {
		return ShrinkWrap
				.create(WebArchive.class, "FootballSimulatorTest.war")
				.addPackage(Resources.class.getPackage())
				.addAsResource("META-INF/persistence-arquillian.xml",
						"META-INF/persistence.xml").addAsResource("import.sql")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy the datasource
				.addAsWebInfResource("footballSimulatorTest-ds.xml");

	}
}