package com.yogsoft.visitor.bean;

import java.util.ArrayList;
import java.util.List;

public class Visitor {

	private int visitorId;
	private String name;
	private String purpose;
	private String inTime;
	private String outTime;
	private int roomNo;
	private String wing;
	private String floor;
	private String visitDate;
	private boolean resident;
	private int memberId;
	private String contatNumber;

	private List<Member> memberList = new ArrayList();

	public String getContatNumber() {
		return contatNumber;
	}

	public void setContatNumber(String contatNumber) {
		this.contatNumber = contatNumber;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public boolean isResident() {
		return resident;
	}

	public void setResident(boolean resident) {
		this.resident = resident;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

}
