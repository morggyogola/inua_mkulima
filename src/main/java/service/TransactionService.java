package service;

import entity.Farmer;
import entity.Product;
import entity.Transaction;
import org.springframework.stereotype.Service;
import repository.FarmerRepository;
import repository.ProductRepository;
import repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final FarmerRepository farmerRepository;
    private final ProductRepository productRepository;
    private  final TransactionRepository transactionRepository;

    public TransactionService(FarmerRepository farmerRepository, ProductRepository productRepository, TransactionRepository transactionRepository) {
        this.farmerRepository = farmerRepository;
        this.productRepository = productRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction buyProduct(Long farmerId, Long productId) {

        Farmer farmer = farmerRepository.findById(farmerId).orElseThrow(() -> new RuntimeException("Farmer not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        BigDecimal newBalance = farmer.getAccountBalance().subtract(product.getProductPrice());
        farmer.setAccountBalance(newBalance);
        farmerRepository.save(farmer);

        Transaction transaction = new Transaction();
        transaction.setFarmer(farmer);
        transaction.setProduct(product);
        transaction.setAmount(product.getProductPrice());
        transaction.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

}
