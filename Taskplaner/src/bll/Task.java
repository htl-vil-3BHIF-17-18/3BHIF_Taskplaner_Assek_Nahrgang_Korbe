package bll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class Task {
	private String subject;
	private String text;
	private Date date;
	private TaskTypEnum typ;
	//private String space = "                                                       ";
	int anzahl_space = 55; 
	public Task(String subject, String text, Date datum, TaskTypEnum typ) {
		super();
		this.subject = subject;
		this.text = text;
		this.date = datum;
		this.typ = typ;
	}

	public Task() {
		this.subject = "";
		this.text = "";
		try {
			this.date = new SimpleDateFormat("yyyy-mm-dd").parse(LocalDate.now().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.typ = TaskTypEnum.Hausuebung;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String fach) {
		this.subject = fach;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDatum() {
		return date;
	}
	
	public java.sql.Date getDatumSQL()
	{
		
		return convertJavaDateToSqlDate(date);
	}

	public void setDatum(Date datum) {
		this.date = datum;
	}

	public TaskTypEnum getTyp() {
		return typ;
	}

	public void setTyp(TaskTypEnum typ) {
		this.typ = typ;
	}
	
	//convert util to sql
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
	public static TaskTypEnum getTypFromString(String s) {
		TaskTypEnum rgw = null;
		switch(s) {
		case "Hausuebung":
			rgw=TaskTypEnum.Hausuebung;
			break;
		case "Schularbeit":
			rgw=TaskTypEnum.Schularbeit;
			break;
		case "GLF":
			rgw=TaskTypEnum.GLF;
			break;
		case "Pruefung":
			rgw=TaskTypEnum.Pruefung;
			break;
		case "MAK":
			rgw=TaskTypEnum.MAK;
			break;
		}
		return rgw;
	}

	@Override
	public String toString() {	
	
		
		
		return subject.trim() + getSpaces(subject.trim().length())+"|  " + text + getSpaces(text.length())+"|  " + date + getSpaces(date.toString().length())+"|  " + typ;
	}
	
	public String getSpaces(int length)
	{
		String spaces = "";
		int spaceHelper = this.anzahl_space-length;	
		for(int i = 0; i<spaceHelper;i++)
		{
			spaces += " ";
		}

		return spaces;
	}
	
	
	
}