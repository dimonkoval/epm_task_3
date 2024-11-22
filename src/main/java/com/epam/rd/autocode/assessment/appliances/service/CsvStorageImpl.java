package com.epam.rd.autocode.assessment.appliances.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CsvStorageImpl implements CsvStorage{
    private final String valuesDelimiter;

    public CsvStorageImpl() {
        this.valuesDelimiter = ",";
    }

    public CsvStorageImpl(Map<String, String> props) {
        this.valuesDelimiter = props.getOrDefault("valuesDelimiter", ",");
    }

    @Override
    public <T> List<T> read(InputStream source, Function<String[], T> mapper) throws IOException {
        List<T> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(source))) {
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(valuesDelimiter, -1);

                   for (int i = 0; i < values.length; i++) {
                    if ("0".equals(values[i])) {
                        values[i] = null;
                    } else if (values[i].isEmpty()) {
                        values[i] = "";
                    }
                }

                T mappedObject = mapper.apply(values);
                if (mappedObject != null) {
                    resultList.add(mappedObject);
                }
            }
        }
        return resultList;
    }

    @Override
    public <T> void write(OutputStream dest, List<T> values, Function<T, String[]> mapper) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dest))) {
            for (T value : values) {
                if (value != null) {
                    String[] valueArray = mapper.apply(value);
                    if (valueArray != null) {
                        String line = String.join(valuesDelimiter, valueArray);
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        }
    }
}
