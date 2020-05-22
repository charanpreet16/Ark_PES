package com.aurousgroup.alphaimplement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "FUND")
public class Fund implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7585708895367071787L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FUND_ID")
	private long fundID;

	@Column(name = "FUND_NAME")
	private String fundName;

	@JsonIgnoreProperties("fundSet")
	@ManyToOne(targetEntity = com.aurousgroup.alphaimplement.model.Investor.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "INVSTR_ID", nullable = false)
	private Investor investor;

	
	/**
	 * @return the investor
	 */
	public Investor getInvestor() {
		return investor;
	}
	/**
	 * @param investor the investor to set
	 */
	public void setInvestor(Investor investor) {
		this.investor = investor;
	}
	/**
	 * @return the fundID
	 */
	public long getFundID() {
		return fundID;
	}
	/**
	 * @param fundID
	 *            the fundID to set
	 */
	public void setFundID(long fundID) {
		this.fundID = fundID;
	}
	/**
	 * @return the fundName
	 */
	public String getFundName() {
		return fundName;
	}
	/**
	 * @param fundName
	 *            the fundName to set
	 */
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	

}
