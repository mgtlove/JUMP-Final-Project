package com.collabera.finalProject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.model.Client;
import com.collabera.finalProject.service.ClientService;


@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping(path = "/addClient")
	public @ResponseBody String addNewClient (@RequestBody @Valid Client aClient)
	{
		clientService.addClient(
				aClient.getImagePath(), 
				aClient.getName(), 
				aClient.getPhone(), 
				aClient.getDescription());
		
		return "Saved";
	}
	
	@GetMapping(path = "/allClients")
	public @ResponseBody Iterable<Client> getAllClients()
	{
		return clientService.findAll();
	}
	
	@GetMapping(path = "/getClient/{id}")
	public Optional<Client> getClientById(@PathVariable Long id)
	{
		return clientService.getClientById(id);
	}
	
	@PutMapping("/updateClient")
	public String updateClient(@RequestBody @Valid Client client)
	{
		System.out.println("Added Client");
		clientService.updateClient(client);
		return "Updated";
	}
	
	@DeleteMapping("/deleteClient/{id}")
	public void deleteClient(@PathVariable String id)
	{
		clientService.deleteClient(Long.parseLong(id));
	}
}
