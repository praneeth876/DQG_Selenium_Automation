package com.utilities;


import org.testng.Assert;

public class ValidationUtils {

    /*
     * method to validate Assert True by giving Condition
     * @param-condition
     */
    public void validateAssertTrue(boolean condition,String erroMsg){
        Assert.assertTrue(condition,erroMsg);

    }
    /*
     * method to validate Assert Equals by providing Expected, Actual value
     * @param-condition
     */
    public void validateAssertEquals(String expTxt,String actTxt,String erroMsg){
        Assert.assertEquals(expTxt,actTxt,erroMsg);
    }




}



