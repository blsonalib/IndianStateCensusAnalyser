package com.indianstatecensusanalyser;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

class StateCensusAnalyser {
    private static String SAMPLE_GSON_FILE = "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensus.json";
    private static String SAMPLE_CSV_CENSUS_FILE_PATH = "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv";

    public StateCensusAnalyser(String SAMPLE_CSVCENSUS_FILE_PATH) {
        this.SAMPLE_CSV_CENSUS_FILE_PATH = SAMPLE_CSVCENSUS_FILE_PATH;
    }

    public int readStateCensusData() throws StateCensusAnalyserException {
        int count = 0;
        List<StateCensus> censusList = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_CENSUS_FILE_PATH));
        ) {
            CsvToBean<StateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<StateCensus> iterator = csvToBean.iterator();
            while (iterator.hasNext()) {
                count++;
                StateCensus StatesCensus = iterator.next();
                censusList.add(StatesCensus);
            }
            sortBYStatesName(censusList);
            writeToJson(censusList);
            sortBYPopulationsValue(censusList);
            writeToJson(censusList);
            sortBYPopulationDensity(censusList);
            writeToJson(censusList);
            sortBYLargestStateArea(censusList);
            writeToJson(censusList);
        } catch (NoSuchFileException e) {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE, "please enter proper file name");
        } catch (RuntimeException e) {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.ExceptionType.INCORRECT_HEADER, "please enter proper header of file");
        } catch (IOException e) {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.ExceptionType.IO_EXCEPTION, "no such file or data is present");
        }
        return count;
    }

    public void sortBYStatesName(List<StateCensus> censusList) {
        Comparator<StateCensus> comparator = Comparator.comparing(StateCensus::getPopulation);
        censusList.sort(comparator);
        System.out.println(censusList.toString());
    }

    public void sortBYPopulationsValue(List<StateCensus> censusList) {
        Comparator<StateCensus> comparator = Comparator.comparing(StateCensus::getPopulation).reversed();
        censusList.sort(comparator);
        System.out.println(censusList.toString());
    }

    public void sortBYPopulationDensity(List<StateCensus> censusList) {
        Comparator<StateCensus> comparator = Comparator.comparing(StateCensus::getDensityPerSqKm).reversed();
        censusList.sort(comparator);
        System.out.println(censusList.toString());
    }

    public void sortBYLargestStateArea(List<StateCensus> censusList) {
        Comparator<StateCensus> comparator = Comparator.comparing(StateCensus::getAreaInSqKm).reversed();
        censusList.sort(comparator);
        System.out.println(censusList.toString());
    }

    public void writeToJson(List<StateCensus> statesCensusList) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(statesCensusList);
        FileWriter fileWriter = new FileWriter(SAMPLE_GSON_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }
}


