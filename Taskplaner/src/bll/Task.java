package bll;

import java.sql.Date;

public class Task {
	private String fach;
	private String text;
	private Date datum;
	private TaskTyp typ;
	
	public Task(String fach, String text, Date datum, TaskTyp typ) {
		super();
		this.fach = fach;
		this.text = text;
		this.datum = datum;
		this.typ = typ;
	}

	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public TaskTyp getTyp() {
		return typ;
	}

	public void setTyp(TaskTyp typ) {
		this.typ = typ;
	}
}