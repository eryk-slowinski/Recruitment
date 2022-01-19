package com.recruitment.task.utils;

import com.recruitment.task.models.Transaction;
import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {
        return o1.getTransactionDate().compareTo(o2.getTransactionDate());
    }
}
