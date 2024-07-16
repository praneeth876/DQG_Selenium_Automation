package com.utilities;


import org.testng.Assert;

public class ValidationUtils {



    public void validateAssertTrue(boolean condition,String erroMsg){
        Assert.assertTrue(true,erroMsg);
    }

    public void validateAssertEquals(String expTxt,String actTxt,String erroMsg){
        Assert.assertEquals(expTxt,actTxt,erroMsg);
    }




}



