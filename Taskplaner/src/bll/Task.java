package bll;

import java.util.Date;

public class Task {
	private String subject;
	private String text;
	private Date date;
	private TaskTyp typ;
	
	public Task(String subject, String text, Date datum, TaskTyp typ) {
		super();
		this.subject = subject;
		this.text = text;
		this.date = datum;
		this.typ = typ;
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

	public void setDatum(Date datum) {
		this.date = datum;
	}

	public TaskTyp getTyp() {
		return typ;
	}

	public void setTyp(TaskTyp typ) {
		this.typ = typ;
	}
	
	public static TaskTyp getTypFromString(String s) {
		TaskTyp rgw = null;
		switch(s) {
		case "Hausübung":
			rgw=TaskTyp.Hausuebung;
			break;
		case "Schularbeit":
			rgw=TaskTyp.Schularbeit;
			break;
		case "GLF":
			rgw=TaskTyp.GLF;
			break;
		case "Prüfung":
			rgw=TaskTyp.Pruefung;
			break;
		case "MAK":
			rgw=TaskTyp.MAK;
			break;
		}
		return rgw;
	}
}