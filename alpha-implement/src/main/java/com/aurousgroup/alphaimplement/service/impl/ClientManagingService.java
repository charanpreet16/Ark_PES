/**
 * 
 */
package com.aurousgroup.alphaimplement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurousgroup.alphaimplement.model.Client;
import com.aurousgroup.alphaimplement.model.Fund;
import com.aurousgroup.alphaimplement.model.Investor;
import com.aurousgroup.alphaimplement.repository.ClientRepository;
import com.aurousgroup.alphaimplement.repository.FundRepository;
import com.aurousgroup.alphaimplement.repository.InvestorRepository;
import com.aurousgroup.alphaimplement.service.IClientService;

/**
 * @author charan
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/")
@Service
public class ClientManagingService implements IClientService {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private InvestorRepository investorRepo;
	@Autowired
	private FundRepository fundRepo;

	@GetMapping("/clientlist")
	@Override
	public List<Client> getClientList() {
		List<Client> clientList = new ArrayList<>();
		clientList = (List<Client>) clientRepo.findAll();
		return clientList;
	}

	@GetMapping("/investorlist")
	@Override
	public List<Investor> getClientInvestors() {
		List<Investor> investorList = new ArrayList<>();
		investorList = (List<Investor>) investorRepo.findAll();
		return investorList;
	}

	@GetMapping("/fundlist")
	public List<Fund> getInvestorFunds() {
		List<Fund> fundList = new ArrayList<>();
		fundList = (List<Fund>) fundRepo.findAll();
		return fundList;
	}

	@PostMapping("/addclient")
	@Override
	public Client createNewClient(@Valid @RequestBody Client client) {
		client = clientRepo.save(client);
		return client;

	}

	@PutMapping("/updateclient")
	@Override
	public ResponseEntity<Client> updateClient(
			@Valid @RequestBody Client client) {

		Optional<Client> clientEntity = clientRepo
				.findById(client.getClientID());
		Client newClient = new Client();
		if (clientEntity.isPresent()) {
			newClient = clientEntity.get();
			newClient.setClientName(client.getClientName());
			newClient.setClientDescription(client.getClientDescription());

			newClient = clientRepo.save(newClient);
		}
		return ResponseEntity.ok(newClient);
	}

	@Override
	public List<Client> getClientByName(String clientName) {
		return null;
	}

}
