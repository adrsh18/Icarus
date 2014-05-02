package com.icarus.pojo;

import java.io.Serializable;
import java.util.Date;

public class Transaction extends PersistentPojo implements Serializable {

	private long transactionId;
	private long sourceId;
	private long destinationId;
	private String sourceLatitude;
	private String sourceLongitude;
	private String destinationLatitude;
	private String destinationLongitude;
	private Date startTime;
	private Date endTime;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}
	public long getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}
	public String getSourceLatitude() {
		return sourceLatitude;
	}
	public void setSourceLatitude(String sourceLatitude) {
		this.sourceLatitude = sourceLatitude;
	}
	public String getSourceLongitude() {
		return sourceLongitude;
	}
	public void setSourceLongitude(String sourceLongitude) {
		this.sourceLongitude = sourceLongitude;
	}
	public String getDestinationLatitude() {
		return destinationLatitude;
	}
	public void setDestinationLatitude(String destinationLatitude) {
		this.destinationLatitude = destinationLatitude;
	}
	public String getDestinationLongitude() {
		return destinationLongitude;
	}
	public void setDestinationLongitude(String destinationLongitude) {
		this.destinationLongitude = destinationLongitude;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
