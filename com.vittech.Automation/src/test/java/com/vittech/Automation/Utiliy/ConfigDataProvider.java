package com.vittech.Automation.Utiliy;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputFilter.Config;
import java.util.Properties;


public class ConfigDataProvider 
{
	public static Properties prop;
    public ConfigDataProvider(String fname) throws FileNotFoundException 
    {
    	try 
    	{
			
    	 File fs = new File("./Config/"+fname+".properties");
       	 FileInputStream fins = new FileInputStream(fs);
       	 prop=new Properties();
       	 prop.load(fins);
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
    }
    public String getUserId() 
    {
		return prop.getProperty("UserID");
    	 
    }
	public String getPassword() 
	{
		return prop.getProperty("PasswordId");
		
	}
	public String getApplicationUrl() 
	{
		return prop.getProperty("ApplUrl");
		
	}
	public String searchKey(String key) 
	{
		return prop.getProperty(key);
		
	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		ConfigDataProvider config =new ConfigDataProvider("Config");
		config.getUserId();
		config.getPassword();
		config.getApplicationUrl();
		config.searchKey("lptitle");
		config.searchKey("loginpage");
	}
}