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

	@CreationTimestamp
	@Temporal(TemporalType.DATE) // or TIME or TIMESTAMP
	private Date createdDate;
	@CreationTimestamp

	private Timestamp ending_time;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Timestamp starting_time;

	private String work;

	public Date getCreatedDate() {
		return createdDate;
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

	public Timestamp getEnding_time() {
		return ending_time;
	}

	public Integer getId() {
		return id;
	}

	public Timestamp getStarting_time() {
		return starting_time;
	}

	public String getWork() {
		return work;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setEnding_time(Timestamp ending_time) {
		this.ending_time = ending_time;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStarting_time(Timestamp starting_time) {
		this.starting_time = starting_time;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Override
	public String toString() {
		return "CompleteTasks [id=" + id + ", work=" + work + ", starting_time=" + starting_time + ", ending_time="
				+ ending_time + ", createdDate=" + createdDate + "]";
	}

}
