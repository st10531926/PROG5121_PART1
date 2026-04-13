import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    Login login = new Login();

    @Test
    public void testUsernameFormatting() {
        // Test 1: Incorrect format (kyle!!!!!!!)
        // Table says: False
        boolean actual1 = login.checkUserName("kyle!!!!!!!");
        assertEquals(false, actual1, "Username incorrectly formatted");

        // Test 2: Correct format (kyl_1)
        // Table says: True
        boolean actual2 = login.checkUserName("kyl_1");
        assertEquals(true, actual2, "Username successfully captured");
    }

    @Test
    public void testPasswordComplexity() {
        // Test 1: Incorrect format (password)
        // Table says: False
        boolean actual1 = login.checkPasswordComplexity("password");
        assertEquals(false, actual1, "Password does not meet complexity requirements");

        // Test 2: Correct format (Ch@ng3Me123)
        // Table says: True
        boolean actual2 = login.checkPasswordComplexity("Ch@ng3Me123");
        assertEquals(true, actual2, "Password successfully captured");
    }

    @Test
    public void testCellFormatting() {
        // Test 1: Correct format (+27838968976)
        // Table says: True
        boolean actual1 = login.checkCellPhoneNumber("+27838968976");
        assertEquals(true, actual1, "Cell number successfully captured");

        // Test 2: Incorrect format (08966553)
        // Table says: False
        boolean actual2 = login.checkCellPhoneNumber("08966553");
        assertEquals(false, actual2, "Cell number incorrectly formatted");
    }
}
