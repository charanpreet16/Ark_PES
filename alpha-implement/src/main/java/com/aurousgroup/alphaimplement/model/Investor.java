package com.aurousgroup.alphaimplement.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "INVESTOR")
public class Investor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7072860904093418147L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVSTR_ID")
	private long investorID;

	@Column(name = "INVESTR_NAME")
	private String investorName;

	@JsonIgnoreProperties("investorList")
	@ManyToOne(targetEntity = com.aurousgroup.alphaimplement.model.Client.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENT_ID", nullable = false)
	private Client client;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "investor")
	private Set<Fund> fundSet = new HashSet<>();

	/**
	 * @return the investorID
	 */
	public long getInvestorID() {
		return investorID;
	}

	/**
	 * @param investorID
	 *            the investorID to set
	 */
	public void setInvestorID(long investorID) {
		this.investorID = investorID;
	}

	/**
	 * @return the investorName
	 */
	public String getInvestorName() {
		return investorName;
	}

	/**
	 * @param investorName
	 *            the investorName to set
	 */
	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the fundSet
	 */
	public Set<Fund> getFundSet() {
		return fundSet;
	}

	/**
	 * @param fundSet
	 *            the fundSet to set
	 **/
	public void setFundSet(Set<Fund> fundSet) {
		this.fundSet = fundSet;
	}

}
