package com.indianstatecensusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StatecensusAnalyser
{
    private static final String SAMPLE_CSV_FILE_PATH="/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCode.csv";
    public int readStateData() throws IOException {
            int count=0;
            try {
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CsvToBean<States> csvToBean = new CsvToBeanBuilder(reader)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withType(States.class)
                        .build();

                Iterator<States> statesIterator = csvToBean.iterator();

                while (statesIterator.hasNext()) {
                    States state = statesIterator.next();
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return count;
        }
}