package com.recruitment.task.utils;

import com.recruitment.task.globals.Globals;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVHandler {
    private static final HashMap<String, File> pathMap = new HashMap<String, File>();
    public static HashMap<String, ArrayList<String[]>> filesContent = new HashMap();

    public static void loadFromDir(String path) {
        final String commaOutQuotes = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        File dir = new File(path);
        BufferedReader bufferedReader;
        String row = "";

        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.getPath().contains("transactions.csv")) {
                    pathMap.put(Globals.TRANSACTIONS_KEY, file);
                } else if (file.getPath().contains("fee_wages.csv")) {
                    pathMap.put(Globals.FEE_WAGES_KEY, file);
                }
            }
        }

        for (File file : pathMap.values()) {
            ArrayList<String[]> rows = new ArrayList<>();
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                bufferedReader.readLine();
                while ((row = bufferedReader.readLine()) != null) {
                    rows.add(row.split(commaOutQuotes));
                }
                if (file.getPath().contains("transactions.csv")) {
                    filesContent.put(Globals.TRANSACTIONS_KEY, rows);
                } else if (file.getPath().contains("fee_wages.csv")) {
                    filesContent.put(Globals.FEE_WAGES_KEY, rows);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
