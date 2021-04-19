package com.globant.test;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.EjercicioPage;

public class EjercicioFinal extends BaseTests {
    EjercicioPage page;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUppage(String browser) {
        initDriver(browser);
        page = new EjercicioPage(driver);
    }

    @AfterMethod
    public void cerrarPage() {
        page.dispose();
    }

    /**
     * select Login Espn
     */
    @Test(dataProvider = "testdata", priority = 0)
    public void loginLogOutEspn(String user,String password, String name) {
        page.login(user,password);
        Assert.assertEquals(page.getName(),name);
        page.logOut();
    }

    @Test(dataProvider = "testdata", priority = 1)
    public void cancelAccount(String user, String password, String name) {
       page.login(user, password);
       page.cancelAccount(user, password);
    }

    @DataProvider(name = "testdata")
    public Object[][] testUsers(){
        Object [][] users=new Object[1][3];
        users[0][0]="pilimeli@gmail.com";
        users[0][1]="12586pmmU";
        users[0][2]="Pilar!";
        return users;
    }
}




