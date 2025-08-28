package com.demo.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
public class CompleteTasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String work;

	private Timestamp starting_time;
	@CreationTimestamp

	private Timestamp ending_time;

	@CreationTimestamp
	@Temporal(TemporalType.DATE) // or TIME or TIMESTAMP
	private Date createdDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Timestamp getStarting_time() {
		return starting_time;
	}

	public void setStarting_time(Timestamp starting_time) {
		this.starting_time = starting_time;
	}

	public Timestamp getEnding_time() {
		return ending_time;
	}

	public void setEnding_time(Timestamp ending_time) {
		this.ending_time = ending_time;
	}

	@Transient
	public String getDuration() {
		if (starting_time == null || ending_time == null)
			return "N/A";

		long seconds = (ending_time.getTime() - starting_time.getTime()) / 1000;

		long hrs = seconds / 3600;
		long mins = (seconds % 3600) / 60;
		long secs = seconds % 60;

		return String.format("%02dh %02dm %02ds", hrs, mins, secs);
	}

	@Override
	public String toString() {
		return "CompleteTasks [id=" + id + ", work=" + work + ", starting_time=" + starting_time + ", ending_time="
				+ ending_time + ", createdDate=" + createdDate + "]";
	}

}
