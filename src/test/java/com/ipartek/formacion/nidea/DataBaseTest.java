package com.ipartek.formacion.nidea;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DataBaseTest {

	@Test
	public void testDriver() {
		// @Test es necesario para que lo ejecute
		// comprobar si tienes los driver cargados
		try {
			Class.forName("com.mysql.jdbc.Driver");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("No existe driver para mysql, ¿Tienes el .JAR?");
		}
	}

	@Test
	public void testConexion() {
		// @Test es necesario para que lo ejecute
		// comprobar si tienes los driver cargados
		// https://fernando-gaitan.com.ar/conectar-java-con-mysql-en-netbeans/
		final String URL = "jdbc:mysql://192.168.0.42/spoty";
		try {
			// Connection con =
			// DriverManager.getConnection("jdbc:mysql://localhost/java_mysql", "root", "");
			Connection con = DriverManager.getConnection(URL, "alumno", "alumno");
			assertTrue(con != null);
		} catch (Exception e) {
			e.printStackTrace();
			fail("No se pudo establecer  conexion " + URL);
		}
	}
}
