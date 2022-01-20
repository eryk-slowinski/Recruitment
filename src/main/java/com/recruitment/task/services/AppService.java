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

    private TransactionsSummary createTransactionsSummary(String id) throws Exception {
        ArrayList<Transaction> transactions = (ArrayList<Transaction>) DataConverter.csvToArrayList(Transaction.class);
        ArrayList<FeeWage> feeWages = (ArrayList<FeeWage>) DataConverter.csvToArrayList(FeeWage.class);
        Transaction lastTransaction = new Transaction();

        ArrayList<Transaction> handledTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getCustomerId().equals(Long.valueOf(id))) {
                handledTransactions.add(t);
            }
        }
        Collections.sort(handledTransactions, new TransactionComparator().reversed());
        try {
            lastTransaction = handledTransactions.get(0);
        } catch (Exception e) {
            throw new Exception("There is no customer with id: " + id);
        }
        TransactionsSummary transactionsSummary = new TransactionsSummary(lastTransaction.getCustomerFirstName(), lastTransaction.getCustomerLastName(), lastTransaction.getCustomerId(), handledTransactions.size(), 0.0f, 0.0f, lastTransaction.getTransactionDate());
        for (Transaction t : handledTransactions) {
            transactionsSummary.setTotalValueOfTransactions(transactionsSummary.getTotalValueOfTransactions() + t.getTransactionAmount());
        }
        for (int i = 0; i < feeWages.size(); i++) {
            if (i > 0) {
                if (feeWages.get(i).getMaxValue() > transactionsSummary.getTotalValueOfTransactions() && feeWages.get(i - 1).getMaxValue() <= transactionsSummary.getTotalValueOfTransactions()) {
                    transactionsSummary.setTransactionsFeeValue(feeWages.get(i).getFeePercentageOfTransactionValue() / 100 * transactionsSummary.getTotalValueOfTransactions());
                    break;
                }
            } else {
                if (feeWages.get(i).getMaxValue() > transactionsSummary.getTotalValueOfTransactions()) {
                    transactionsSummary.setTransactionsFeeValue(feeWages.get(i).getFeePercentageOfTransactionValue() / 100 * transactionsSummary.getTotalValueOfTransactions());
                    break;
                }
            }
        }
        createCommissionObject(transactionsSummary);
        return transactionsSummary;
    }

    public List calculateTransactions(@RequestParam String customer_id) {
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
                try {
                    transactionsDetails.add(createTransactionsSummary(customerId + ""));
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        } else if (idParams.length == 1) {
            try {
                transactionsDetails.add(createTransactionsSummary(idParams[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            for (String customerId : idParams) {
                try {
                    transactionsDetails.add(createTransactionsSummary(customerId));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return transactionsDetails;
    }

    public List calculateTransactions() {
        ArrayList<Long> customersId = new ArrayList<>();
        ArrayList<TransactionsSummary> transactionsDetails = new ArrayList<>();

        ArrayList<Transaction> transactions = (ArrayList<Transaction>) DataConverter.csvToArrayList(Transaction.class);
        for (Transaction t : transactions) {
            if (!customersId.contains(t.getCustomerId())) {
                customersId.add(t.getCustomerId());
            }
        }
        for (Long customerId : customersId) {
            try {
                transactionsDetails.add(createTransactionsSummary(customerId + ""));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return transactionsDetails;
    }

    private void createCommissionObject(TransactionsSummary transactionsSummary) {
        CommissionObject commissionObject = new CommissionObject(null, transactionsSummary.getCustomerId(), transactionsSummary.getTransactionsFeeValue(), new Date());
        repository.save(commissionObject);
    }

}

