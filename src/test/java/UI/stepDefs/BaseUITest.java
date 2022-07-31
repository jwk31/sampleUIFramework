package UI.stepDefs;

import com.obtaincare.UI.asserts.AssertClass;
import com.obtaincare.UI.helperMethods.Helper;
import com.obtaincare.UI.pageObject.HomePage;
import com.obtaincare.UI.pageObject.LoginPage;

public class BaseUITest {

   protected static AssertClass assertClass = new AssertClass();
    protected static Helper helper = new Helper();
    protected static LoginPage loginPage = new LoginPage();
    protected static HomePage homePage = new HomePage();

}
