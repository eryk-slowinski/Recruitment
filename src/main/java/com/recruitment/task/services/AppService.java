package com.recruitment.task.services;

import com.recruitment.task.models.CommissionObject;
import com.recruitment.task.models.FeeWage;
import com.recruitment.task.models.Transaction;
import com.recruitment.task.models.TransactionsSummary;
import com.recruitment.task.repositories.CommissionObjectRepository;
import com.recruitment.task.utils.DataConverter;
import com.recruitment.task.utils.TransactionComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class AppService {

    @Autowired
    CommissionObjectRepository repository;

    private TransactionsSummary createTransactionsSummary(String id) {
        ArrayList<Transaction> transactions = (ArrayList<Transaction>) DataConverter.csvToArrayList(Transaction.class);
        ArrayList<FeeWage> feeWages = (ArrayList<FeeWage>) DataConverter.csvToArrayList(FeeWage.class);


        ArrayList<Transaction> handledTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getCustomerId().equals(Long.valueOf(id))) {
                handledTransactions.add(t);
            }
        }
        Collections.sort(handledTransactions, new TransactionComparator().reversed());
        Transaction lastTransaction = handledTransactions.get(0);
        TransactionsSummary transactionsSummary = new TransactionsSummary(lastTransaction.getCustomerFirstName(), lastTransaction.getCustomerLastName(), lastTransaction.getCustomerId(), handledTransactions.size(), 0.0f, 0.0f, lastTransaction.getTransactionDate());
        for (Transaction t : handledTransactions) {
            transactionsSummary.setTotalValueOfTransactions(transactionsSummary.getTotalValueOfTransactions() + t.getTransactionAmount());
        }
        for (FeeWage fw : feeWages) {
            if (fw.getTransactionValueLessThan() < transactionsSummary.getTotalValueOfTransactions()) {
                transactionsSummary.setTransactionsFeeValue(fw.getFeePercentageOfTransactionValue() / 100 * transactionsSummary.getTotalValueOfTransactions());
            }
        }
        createCommissionObject(transactionsSummary);
        return transactionsSummary;
    }

    public List getTransactionsDetails(@RequestParam String customer_id) {
        String[] idParams = customer_id.split(",");
        ArrayList<Long> customersId = new ArrayList<>();
        ArrayList<TransactionsSummary> transactionsDetails = new ArrayList<>();

        if (idParams[0].toLowerCase(Locale.ROOT).equals("all".toLowerCase(Locale.ROOT))) {
            ArrayList<Transaction> transactions = (ArrayList<Transaction>) DataConverter.csvToArrayList(Transaction.class);
            for (Transaction t : transactions) {
                if (!customersId.contains(t.getCustomerId())) {
                    customersId.add(t.getCustomerId());
                }
            }
            for (Long customerId : customersId) {
                transactionsDetails.add(createTransactionsSummary(customerId + ""));
            }
        } else if (idParams.length == 1) {
            transactionsDetails.add(createTransactionsSummary(idParams[0]));
        } else {
            for (String customerId : idParams) {
                transactionsDetails.add(createTransactionsSummary(customerId));
            }
        }
        return transactionsDetails;
    }

    public List getTransactionsDetails() {
        ArrayList<Long> customersId = new ArrayList<>();
        ArrayList<TransactionsSummary> transactionsDetails = new ArrayList<>();

        ArrayList<Transaction> transactions = (ArrayList<Transaction>) DataConverter.csvToArrayList(Transaction.class);
        for (Transaction t : transactions) {
            if (!customersId.contains(t.getCustomerId())) {
                customersId.add(t.getCustomerId());
            }
        }
        for (Long customerId : customersId) {
            transactionsDetails.add(createTransactionsSummary(customerId + ""));
        }
        return transactionsDetails;
    }

    private void createCommissionObject(TransactionsSummary transactionsSummary) {
        CommissionObject commisionObject = new CommissionObject(null, transactionsSummary.getCustomerId(), transactionsSummary.getTransactionsFeeValue(), new Date());
        repository.save(commisionObject);
    }

}

