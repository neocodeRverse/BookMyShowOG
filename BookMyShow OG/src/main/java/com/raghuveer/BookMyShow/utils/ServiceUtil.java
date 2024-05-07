package com.raghuveer.BookMyShow.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceUtil {
    public List<String[]> parseCsvData(String csvData) {
        List<String[]> data = new ArrayList<>();

        // Split the CSV data into lines
        String[] lines = csvData.split("\\r?\\n");

        for (String line : lines) {
            // Split each line into values based on comma separator
            String[] values = line.split(",");
            data.add(values);
        }

        return data;
    }
}

