package com.recruitment.task.utils;

import com.recruitment.task.globals.Globals;
import com.recruitment.task.models.FeeWage;
import com.recruitment.task.models.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataConverter {

    public static Date convertToDate(String valueToConvert) {
        Date convertedDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            convertedDate = formatter.parse(valueToConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

    public static float convertToFloat(String valueToConvert) {
        return Float.valueOf(valueToConvert.replace(",", ".").replaceAll("\"", ""));
    }

    public static Long convertToLong(String valueToConvert) {
        return Long.valueOf(valueToConvert);
    }

    public static ArrayList csvToArrayList(Class clazz) {
        ArrayList<Object> convertedCSV = new ArrayList<>();
        ArrayList<String[]> rows = null;
        if (clazz.equals(Transaction.class)) {
            rows = CSVHandler.filesContent.get(Globals.TRANSACTIONS_KEY);
            for (String[] row : rows) {
                convertedCSV.add(new Transaction(row));
            }
        } else if (clazz.equals(FeeWage.class)) {
            rows = CSVHandler.filesContent.get(Globals.FEE_WAGES_KEY);
            for (String[] row : rows) {
                convertedCSV.add(new FeeWage(row));
            }
        }
        return convertedCSV;
    }

}

