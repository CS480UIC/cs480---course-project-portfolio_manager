package edu.uic.cs480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uic.cs480.model.Exchange;
import edu.uic.cs480.service.ExchangeService;

/**
 * implemented to provide APIs for exchanges table.
 * 
 * @author Arvind Gupta
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExchangeController {

	@Autowired
	private ExchangeService exchangeService;

	/**
	 * API to add new exchange to exchanges table.
	 * 
	 * @param exchange
	 * @return
	 */
	@PostMapping("/api/addNewExchange")
	public ResponseEntity<?> addExchange(@ModelAttribute("exchange") Exchange exchange) {
		int exchangeId = exchangeService.addNewExchange(exchange);
		return ResponseEntity.ok().body("New Exchange added with Id : " + exchangeId);
	}

	/**
	 * implemented to get list of all exchanges.
	 * 
	 * @return
	 */
	@GetMapping("/api/getAllExchanges")
	public ResponseEntity<List<Exchange>> listOfAllExchanges() {
		List<Exchange> exchangeList = exchangeService.getAllExchanges();
		return ResponseEntity.ok().body(exchangeList);
	}
	
	/**
	 * implemented to get list of all exchanges sorted by name.
	 * 
	 * @return
	 */
	@GetMapping("/api/getAllExchangesSortedByName")
	public ResponseEntity<List<Exchange>> listOfAllExchangesSortedByName() {
		List<Exchange> exchangeList = exchangeService.getAllExchangesSortedByName();
		return ResponseEntity.ok().body(exchangeList);
	}

	/**
	 * implemented to update number of stocks in an existing exchange.
	 * 
	 * @param exchangeId
	 * @param numberOfStocks
	 * @return
	 */
	@PutMapping("/api/updateExchangeInfo/{exchangeId}/{numberOfStocks}")
	public ResponseEntity<?> updateExchangeInfo(@PathVariable("exchangeId") int exchangeId,
			@PathVariable("numberOfStocks") int numberOfStocks) {
		int id = exchangeService.updateExistingExchange(exchangeId, numberOfStocks);
		return ResponseEntity.ok().body("Exchange update with Exchange ID : " + id);
	}

	/**
	 * implemented to delete an existing exchange according to the exchange ID.
	 * 
	 * @param exchangeId
	 * @return
	 */
	@DeleteMapping("/api/deleteExchange/{exchangeId}")
	public ResponseEntity<?> deleteExchange(@PathVariable("exchangeId") int exchangeId) {
		exchangeService.deleteExchange(exchangeId);
		return ResponseEntity.ok().body("Exchange deleted with ID : " + exchangeId);
	}
}
