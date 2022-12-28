package com.crm.qa.base;
adding new lines

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {
	public static WebDriver driver;
	public static Properties prop;
	//static WebDriver driver;
	public static void main(String[] args) {
		try {

			prop = new Properties();
			File  file = new File(System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/config/config.properties");
			System.out.println(file.getAbsoluteFile());
			
			FileInputStream ip = new FileInputStream(file);
			
			try {
				prop.load(ip);
				System.out.println(prop.getProperty("browser"));
				System.out.println(prop.getProperty("url"));
				System.out.println(prop.getProperty("username"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("The  file is not there");

		}
		
	}
console.writeline("helloworld");

}
