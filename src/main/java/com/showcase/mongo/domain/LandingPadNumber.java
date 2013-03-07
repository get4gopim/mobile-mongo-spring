package com.showcase.mongo.domain;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

@SpaceClass
public class LandingPadNumber {

	private String landingPadNumber;
	
	private String dnis;
	
	private String callId;
	
	private String id;
	
	public LandingPadNumber() {
		
	}

	public LandingPadNumber(String landingPadNumber, String dnis, String callId) {
		super();
		this.landingPadNumber = landingPadNumber;
		this.dnis = dnis;
		this.callId = callId;
	}

	public String getLandingPadNumber() {
		return landingPadNumber;
	}

	public void setLandingPadNumber(String landingPadNumber) {
		this.landingPadNumber = landingPadNumber;
	}

	public String getDnis() {
		return dnis;
	}

	public void setDnis(String dnis) {
		this.dnis = dnis;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	@SpaceId(autoGenerate=true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LandingPadNumber [landingPadNumber=" + landingPadNumber
				+ ", dnis=" + dnis + ", callId=" + callId + ", id=" + id + "]";
	}
	
	
	
}
