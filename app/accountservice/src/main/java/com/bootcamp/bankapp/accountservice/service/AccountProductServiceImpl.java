package com.bootcamp.bankapp.accountservice.service;

import com.bootcamp.bankapp.accountservice.model.AccountProduct;
import com.bootcamp.bankapp.accountservice.repository.AccountProductRepository;
import com.bootcamp.bankapp.accountservice.utils.AdapterExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class define a Service to implement the business rules for this microservice
 */
@Service
public class AccountProductServiceImpl  {

    /**
     *  Fields of Class
     */
    @Autowired
    private AccountProductRepository accountproductRepository;

    /**
     * Method that return data related to all Documents on the Collection
     */
    public Flux<AccountProduct> findAll() {
        return accountproductRepository.findAll();
    }

    /**
     * Method that return one Document by ID
     */
    public Mono<AccountProduct> findById(String id) {
        return accountproductRepository.findById(id);
    }

    /**
     * Method that creates one Document and return it including ID
     */
    public Mono<AccountProduct> save(AccountProduct customer) {
        return accountproductRepository.save(customer);
    }

    /**
     * Method that delete one Document
     */
    public void deleteById(String id) {
        accountproductRepository.deleteById(id);
    }

    /**
     * Method that create a Document by specific rule, this rule consist on allow one account of any type (SAVINGS, CHECKING, FIX DEPOSIT) to Holder Client
     */
    public Mono<AccountProduct> createBankAccountPersonalType(AccountProduct bankAccount) {
        String idCliente="6733cf6af54bb00c395ac98e";
        return  accountproductRepository.findByHoldersContainsAndType(idCliente, bankAccount.getType())
                        .hasElements()
                        .flatMap(exists -> {
                            if (exists) {
                                return Mono.error(new AdapterExceptionHandler("El cliente ya tiene una cuenta bancaria de tipo " + bankAccount.getType()));
                            } else {
                                return accountproductRepository.save(bankAccount);
                            }
                        });
    }

    /**
     * Performs a withdrawal from an account, and returns updated account
     */
    public Mono<AccountProduct> withdraw(String accountId, double amount) {
        return accountproductRepository.findById(accountId)
                .flatMap(account -> {
                    if (account.getBalance() >= amount) {
                        account.setBalance(account.getBalance() - amount);
                        return accountproductRepository.save(account);
                    } else {
                        return Mono.error(new AdapterExceptionHandler("Fondos insuficientes para la cuenta: " + accountId));
                    }
                });
    }

    /**
     * Performs a deposit for an account, and returns updated account.
     */
    public Mono<AccountProduct> deposit(String accountId, double amount) {
        return accountproductRepository.findById(accountId)
                .flatMap(account -> {
                    account.setBalance(account.getBalance() + amount);
                    return accountproductRepository.save(account);
                });
    }

    /**
     * Performs an account balance
     */
    public Mono<Double> getBalance(String accountId) {
        return accountproductRepository.findById(accountId)
                .map(AccountProduct::getBalance);
    }



}
