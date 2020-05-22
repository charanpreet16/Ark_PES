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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1727715170821454377L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID")
	private long clientID;

	@Column(name = "CLIENT_NAME")
	private String clientName;

	@Column(name = "CLIENT_DESC")
	private String clientDescription;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
	private Set<Investor> investorList = new HashSet<>();

	/**
	 * @return the clientID
	 */
	public long getClientID() {
		return clientID;
	}

	/**
	 * @param clientID
	 *            the clientID to set
	 */
	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName
	 *            the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientDescription
	 */
	public String getClientDescription() {
		return clientDescription;
	}
	/**
	 * @param clientDescription
	 *            the clientDescription to set
	 */
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	/**
	 * @return the investorList
	 *
	 **/
	public Set<Investor> getInvestorList() {
		return investorList;
	}

	/**
	 * @param investorList
	 *            the investorList to set
	 *
	 **/
	public void setInvestorList(Set<Investor> investorList) {
		this.investorList = investorList;
	}

}
