package com.wipro.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.wipro.day6.projects.StringUtil;

class StringUtilTest {

	 @Test
	    public void testUpperCaseString() 
	 {
	        assertTrue(StringUtil.isUpperCase("HELLO"));  
	   }

	    @Test
	    public void testLowerCaseString() {
	        assertFalse(StringUtil.isUpperCase("hello"));  
	    }

	    @Test
	    public void testMixedCaseString() 
	    {
	        assertFalse(StringUtil.isUpperCase("Hello"));  
	    }

	    @Test
	    public void testEmptyString() 
	    {
	        assertFalse(StringUtil.isUpperCase(""));  
	    }

	    @Test
	    public void testNullString() 
	    {
	        assertFalse(StringUtil.isUpperCase(null));  
	    }
	    
	    @Test
	    public void testNullToUpperCaseThrowsException()
	    {
	        String input = null;

	        assertThrows(NullPointerException.class, () -> {
	            input.toUpperCase(); 
	        });
	    }
	    

	    @ParameterizedTest
	    @ValueSource(strings = {"hello", "world", "java", "testcase"})
	    public void testStringsAreLowerCase(String input) 
	    {
	        assertTrue(StringUtil.isLowerCase(input), "Expected lowercase but got: " + input);
	    }
}
