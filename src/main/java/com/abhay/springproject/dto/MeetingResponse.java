package com.abhay.springproject.dto;

import java.util.Date;
import java.util.List;

import com.abhay.springproject.Entity.Member;

public class MeetingResponse {
	
	private int id;

	private String title;
	private Date start;
	private Date end;
	private String loc;
	private String organiser;
	private String link;
	private List<Member> members;

	public MeetingResponse() {
		super();
	}

	
	public MeetingResponse(int id, String title, Date start, Date end, String loc, String organiser, String link,
			List<Member> members) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.loc = loc;
		this.organiser = organiser;
		this.link = link;
		this.members = members;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getOrganiser() {
		return organiser;
	}

	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + ", loc=" + loc
				+ ", organiser=" + organiser + ", link=" + link + "]";
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}



