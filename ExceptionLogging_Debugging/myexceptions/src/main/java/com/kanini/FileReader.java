package com.kanini;
import org.apache.commons.csv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileReader {

    private static final Logger log = LoggerFactory.getLogger(FileReader.class);

    public List<Users> readCsv(String filePath) throws FileException {

        Path path = Path.of(filePath);

        if (!Files.exists(path)) {
            String msg = "CSV file not found: " + filePath;
            log.error(msg);
            throw new FileException(msg);
        }

        try (Reader reader = Files.newBufferedReader(path);
             CSVParser parser = CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
                     .withIgnoreEmptyLines(true)
                     .withTrim()
                     .parse(reader)) {

            List<Users> records = new ArrayList<>();

            for (CSVRecord row : parser) {
                processRow(row, records);
            }

            log.info("Successfully read records from ", records.size(), filePath);
            return records;

        } catch (IOException e) {
            String msg = "IO error reading CSV: " + e.getMessage();
            log.error(msg);
            throw new FileException(msg, e);
        }
    }

    private void processRow(CSVRecord row, List<Users> output) {
        try {
            String id = row.get("id");
            String name = row.get("name");
            String ageStr = row.get("age");

            if (isBlank(id) || isBlank(name)) {
                log.warn("Skipping row : missing id or name", row.getRecordNumber());
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                log.warn("Skipping row  due to invalid age ", row.getRecordNumber(), ageStr);
                return;
            }

            output.add(new Users(id, name, age));

        } catch (Exception e) {
            log.error("Unexpected error in row : ", row.getRecordNumber(), e.getMessage());
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}

