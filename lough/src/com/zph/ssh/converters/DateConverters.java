package com.zph.ssh.converters;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverters extends StrutsTypeConverter {

	private DateFormat dateFormat;

	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Override
	public Object convertFromString(Map arg0, String[] values, Class toClass) {

		if (toClass == Date.class) {

			try {
				return dateFormat.parse(values[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		System.out.println(o.getClass()+"o.getClass()=====================");
		if (o instanceof Date) {
			try {
				System.out.println("dateFormat.format((Date) o)"
						+ dateFormat.format((Date) o));
				return dateFormat.format((Date) o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
