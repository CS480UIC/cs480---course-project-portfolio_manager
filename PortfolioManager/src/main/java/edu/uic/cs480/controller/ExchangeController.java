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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExchangeController {

	@Autowired
	private ExchangeService exchangeService;

	@PostMapping("/api/addNewExchange")
	public ResponseEntity<?> addExchange(@ModelAttribute("exchange") Exchange exchange) {
		int exchangeId = exchangeService.addNewExchange(exchange);
		return ResponseEntity.ok().body("New Exchange added with Id : " + exchangeId);
	}

	@GetMapping("/api/getAllExchanges")
	public ResponseEntity<List<Exchange>> listOfAllExchanges() {
		List<Exchange> exchangeList = exchangeService.getAllExchanges();
		return ResponseEntity.ok().body(exchangeList);
	}

	@PutMapping("/api/updateExchangeInfo/{exchangeId}/{exchangeName}/{numberOfStocks}")
	public ResponseEntity<?> updateExchangeInfo(@PathVariable("exchangeId") int exchangeId,
			@PathVariable("exchangeName") String exchangeName, @PathVariable("numberOfStocks") int numberOfStocks) {
		int id = exchangeService.updateExistingExchange(exchangeId, exchangeName, exchangeName);
		return ResponseEntity.ok().body("Exchange update with Exchange ID : " + id);
	}

	@DeleteMapping("/api/deleteExchange/{exchangeId}")
	public ResponseEntity<?> deleteExchange(@PathVariable("exchangeId") int exchangeId) {
		exchangeService.deleteExchange(exchangeId);
		return ResponseEntity.ok().body("Exchange deleted with ID : " + exchangeId);
	}
}
