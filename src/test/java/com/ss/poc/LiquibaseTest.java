package com.ss.poc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.test.IntegrationTest;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.FileSystemResourceAccessor;

@Category(IntegrationTest.class)
public class LiquibaseTest {

	private static Connection connection;
	private static Liquibase liquibase;
	private static final String CHANGE_LOG_FILE = "src/main/resources/liquibase/master/db.changelog-master.xml";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class.forName("org.h2.Driver");
		connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

		Database database = DatabaseFactory.getInstance()
				.findCorrectDatabaseImplementation(new JdbcConnection(connection));
		liquibase = new Liquibase(CHANGE_LOG_FILE, new FileSystemResourceAccessor(), database);
		liquibase.update("");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_apm_tag_details_entry() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select count(*) as payment_schem_count from apm_tag_details");
			rs = ps.executeQuery();
			rs.next();
			int numberOfUsers = rs.getInt("payment_schem_count");
			assertThat("Number of schem is equal", 1, is(numberOfUsers));
		} finally {
			rs.close();
			ps.close();
		}
	}

}
