package com.indianstatecensusanalyser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;

public class StatecensusAnalyser {
    private static String SAMPLE_CSV_FILE_PATH = "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCode.csv";


    public StatecensusAnalyser(String SAMPLE_CSV_FILE_PATH) {
        this.SAMPLE_CSV_FILE_PATH = SAMPLE_CSV_FILE_PATH;
    }

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
        } catch (RuntimeException e) {
            throw new CustomException(CustomException.ExceptionType.INCORRECT_HEADER, "please enter proper header of file");
        }
        return count;
    }



    public int readStateCensusData() throws IOException, CustomException {
        String SAMPLE_CSVCENSUS_FILE_PATH = "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCensusData.csv";
        int count = 0;

        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSVCENSUS_FILE_PATH));
            CsvToBean<StateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(StateCensus.class)
                    .build();

            Iterator<StateCensus> csvStateIterator = csvToBean.iterator();
            while(csvStateIterator.hasNext())
            {

                StateCensus censusData = csvStateIterator.next();
                System.out.println(censusData.getState());
                System.out.println(censusData.getDensityPerSqKm());
                count++;
            }
        }catch (NoSuchFileException e) {
            throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE, "please enter proper file name",e);
        }catch (RuntimeException e) {
            throw new CustomException(CustomException.ExceptionType.INCORRECT_HEADER, "please enter proper header of file");
        }
        return count;
    }
}