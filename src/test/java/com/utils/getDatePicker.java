package com.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class getDatePicker {
	
	public static void main (String[] args) {

		WebDriver driver = null;
		Log.info("Trying to select date :");
		driver.findElement(By.xpath("//span[@class='calImgSpan calendars-trigger']//img[@class='trigger']")).click();
		String pattern = "dd-MM-yy";
		String dateInString =new SimpleDateFormat(pattern).format(new Date());
		//a[contains(@class,'calendars-today')]
		
		/*
	    public static String getCurrentDay() {
	        
	        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	       
	        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	        System.out.println("Today Int: " + todayInt + "\n");
	       
	        String todayStr = Integer.toString(todayInt);
	        System.out.println("Today Str: " + todayStr + "\n");
	        return todayStr;
	    }
	    
	    public static String getCurrentDayPlus(int days) {
	        LocalDate currentDate = LocalDate.now();
	        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
	        return Integer.toString(dayOfWeekPlus);
	    }

	    public static void clickGivenDay(List<WebElement> elementList, String day) {
	        //DatePicker is a table. Thus we can navigate to each cell
	        //and if a cell matches with the current date then we will click it.
	        /**Functional JAVA version of this method. 
	        elementList.stream()
	            .filter(element -> element.getText().contains(day))
	            .findFirst()
	            .ifPresent(WebElement::click);
	    }
	    */
	}
}
