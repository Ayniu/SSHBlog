package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestTime {

	@Test
	public void printTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		String dateStr = dateFormat.format(date);
		String str = "今天是 " + dateStr;
		System.out.println(str);
	}

}
