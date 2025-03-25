package controller;

import entity.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.TransactionService;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("/buy")
    public ResponseEntity<Transaction> buyProduct(@RequestParam Long farmerId, @RequestParam Long productId) {
        Transaction transaction = transactionService.buyProduct(farmerId, productId);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
