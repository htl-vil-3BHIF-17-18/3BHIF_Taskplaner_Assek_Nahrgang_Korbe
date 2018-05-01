package bll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class Task {
	private TaskSubjectEnum subject;
	private String text;
	private Date date;
	private TaskTypEnum typ;
	//private String space = "                                                       ";
	int anzahl_space = 35; 
	public Task(TaskSubjectEnum subject, String text, Date datum, TaskTypEnum typ) {
		super();
		this.subject = subject;
		this.text = text;
		this.date = datum;
		this.typ = typ;
	}

	public Task() {
		this.subject = TaskSubjectEnum.AM;
		this.subject = TaskSubjectEnum.unkown;
		this.text = "";
		
		try {
			this.date = new SimpleDateFormat("yyyy-mm-dd").parse(LocalDate.now().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.typ = TaskTypEnum.Hausuebung;
	}
	
	public TaskSubjectEnum getSubject() {
		return subject;
	}

	public void setSubject(TaskSubjectEnum fach) {
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
	
	public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
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

	public static TaskSubjectEnum getSubjectFromString(String sub) {
		TaskSubjectEnum rgw = null;
		switch(sub) {
		case "AM":
			rgw=TaskSubjectEnum.AM;
			break;
		case "E":
			rgw=TaskSubjectEnum.E;
			break;
		case "D":
			rgw=TaskSubjectEnum.D;
			break;
		case "POS":
			rgw=TaskSubjectEnum.POS;
			break;
		case "GGP":
			rgw=TaskSubjectEnum.GGP;
			break;
		case "NVS":
			rgw=TaskSubjectEnum.NVS;
			break;
		case "TINF":
			rgw=TaskSubjectEnum.TINF;
			break;
		case "BSPK":
			rgw=TaskSubjectEnum.BSPK;
			break;
		case "NW":
			rgw=TaskSubjectEnum.NW;
			break;
		case "BWM1":
			rgw=TaskSubjectEnum.BWM1;
			break;
		case "BWM2":
			rgw=TaskSubjectEnum.BWM2;
			break;
		case "DBI":
			rgw=TaskSubjectEnum.DBI;
			break;
		case "RK":
			rgw=TaskSubjectEnum.RK;
			break;
		case "SOPK":
			rgw=TaskSubjectEnum.SOPK;
			break;
		default:
			rgw=TaskSubjectEnum.unkown;
			break;
		}
		return rgw;
	}

	@Override
	public String toString() {	
		return subject.toString().trim() + getSpaces(subject.toString().trim().length())+"|  " + 
		text + getSpaces(text.length())+"|  " + Task.convertJavaDateToSqlDate(date) + getSpaces(date.toString().length())+"|  " + typ;
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