/**
 * 
 */
package com.aurousgroup.alphaimplement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurousgroup.alphaimplement.model.Client;
import com.aurousgroup.alphaimplement.model.Investor;

/**
 * @author chara
 *
 */
public interface IClientService {

	public List<Client> getClientList();

	public List<Client> getClientByName(String clientName);

	public Client createNewClient(Client client);
	
	public ResponseEntity<Client> updateClient(Client client);

	List<Investor> getClientInvestors();

}
