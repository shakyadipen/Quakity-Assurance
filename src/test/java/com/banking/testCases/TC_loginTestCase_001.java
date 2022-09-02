package com.banking.testCases;

import com.banking.pageObjects.LoginPage;
import com.banking.testCases.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
//Since every common url,username,password,driver which is used frequenetly in base class so ypu must extend baseclass
public class TC_loginTestCase_001 extends BaseClass {
    //private static final Logger logger= LogManager.getLogger(TC_loginTestCase_001.class);
    @Test
    public void loginTest(){

        logger.info("URL Opened");
        LoginPage lp=new LoginPage(driver);
        lp.setUsername(username);
        logger.info("Username provided");
        lp.setPassword(password);
        logger.info("Password entered");
        lp.clickButton();
        logger.info("Button Clicked");
        //logger.trace("login jsut happemd");
        if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login Passed Successfully");
            System.out.println("Login Successful ");
        }
        else{
            Assert.assertTrue(false);
            logger.info("Login Failed");
        }





    }
}
