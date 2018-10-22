package com.crm.qa.testcases;

public class testconcat {

	public static void main(String[] args) {
		testconcat.concat();

	}
	
	public static void concat()
	{
		StringBuilder sb= new StringBuilder(14);
		String sb1="//td[contains(text(),'";
		String sb2="Mr.";
		String sb3="test";
		String sb4="testeste";
		String sb6="')]";
		
		StringBuilder sb5 = sb.append(sb1).append(sb2).append(" ").append(sb3).append(" ").append(sb4).append(sb6);
		
		//"//*[@id='" + recordId + "_ACTION_COLUMN']/a[2]/span";
		
		System.out.println("\""+sb5+"\"");
		//System.out.println(""sb5);
	}

}

//td[contains(text(),'Mr. test testeste')]
//td[contains(text(),'Mr. test')]