package com.indianstatecensusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StatecensusAnalyser
{
    private static final String SAMPLE_CSV_FILE_PATH="/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCensusData.csv";
    public int readStateData() throws IOException, CustomException {
        int count = 0;
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
        } catch (NoSuchFileException e) {
            throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE, "please enter proper file name");

        } catch( RuntimeException e) {
            throw new CustomException(CustomException.ExceptionType.INCORRECT_TYPE, "please enter proper type of file");
        }
            return count;

        }
    }
