package util;
import dao.DBConnection;
import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DBConnectionTest {
    public DBConnectionTest() {
    }   
    @BeforeAll
    public static void setUpClass() {
    }   
    @AfterAll
    public static void tearDownClass() {
    }   
    @BeforeEach
    public void setUp() {
    }   
    @AfterEach
    public void tearDown() {
    }
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DBConnection instance = new DBConnectionImpl();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    @Test
    public void testSetConnection() {
        System.out.println("setConnection");
        Connection connection = null;
        DBConnection instance = new DBConnectionImpl();
        instance.setConnection(connection);
        fail("The test case is a prototype.");
    }
    public class DBConnectionImpl extends DBConnection {
    }   
}
