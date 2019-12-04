package com.indianstatecensusanalyser;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class StateCensusAnalyser {
    private static String SAMPLE_GSON_FILE_PATH="/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.json";
    private static String SAMPLE_GSON_FILE="/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData1.json";
    private static String SAMPLE_CSVCENSUS_FILE_PATH = "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv";
    private static String SAMPLE_GSON_FILE_DENCITY="/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusForDencity.json";
    private static String SAMPLE_GSON_FILE_AREA="/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusDataLargestArea.json";
    public StateCensusAnalyser(String  SAMPLE_CSVCENSUS_FILE_PATH ) {
        this. SAMPLE_CSVCENSUS_FILE_PATH= SAMPLE_CSVCENSUS_FILE_PATH;
    }

    public int readStateCensusData() throws IOException, CustomException {

        int count = 0;

        List<StateCensus> list=new ArrayList<>();

        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSVCENSUS_FILE_PATH));

        ) {

            CsvToBean<StateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<StateCensus> iterator=csvToBean.iterator();
            while (iterator.hasNext()) {
                count++;

                StateCensus StatesCensus = iterator.next();

                list.add(StatesCensus);
            }
            sortBYStatesName(list);
            writeToJson(list,SAMPLE_GSON_FILE_PATH);
            sortBYPopulationsValue(list);
            writeToJson(list,SAMPLE_GSON_FILE);
            sortBYPopulationDensity(list);
            writeToJson(list,SAMPLE_GSON_FILE_DENCITY);
            sortBYLargestStateArea(list);
            writeToJson(list, SAMPLE_GSON_FILE_AREA);
        }   catch (NoSuchFileException e) {
        throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE, "please enter proper file name");
    }catch (RuntimeException e) {
        throw new CustomException(CustomException.ExceptionType.INCORRECT_HEADER, "please enter proper header of file");
    }
        return count;
    }

    public void sortBYStatesName(List<StateCensus> list)
    {
        Comparator<StateCensus> comparator=Comparator.comparing(StateCensus::getPopulation);
        list.sort(comparator);
        System.out.println(list.toString());
    }
    public void sortBYPopulationsValue(List<StateCensus> list)
    {
        Comparator<StateCensus> comparator=Comparator.comparing(StateCensus::getPopulation);
        list.sort(comparator);
        System.out.println(list.toString());
    }
    public void sortBYPopulationDensity(List<StateCensus> list)
    {
        Comparator<StateCensus> comparator=Comparator.comparing(StateCensus::getDensityPerSqKm);
        list.sort(comparator);
        System.out.println(list.toString());
    }
    public void sortBYLargestStateArea(List<StateCensus> list)
    {
        //Comparator<StateCensus> c = (s1,s2) -> (Integer.parseInt(s2.getAreaInSqKm())) - (Integer.parseInt(s1.getAreaInSqKm()));
        Comparator<StateCensus> comparator=Comparator.comparing(StateCensus::getAreaInSqKm);
        list.sort(comparator);
        System.out.println(list.toString());
    }
    public void writeToJson(List<StateCensus> statesCensusList,String SAMPLE_FILE_PATH) throws IOException{
        Gson gson=new Gson();
        String json=gson.toJson(statesCensusList);
        FileWriter fileWriter=new FileWriter(  SAMPLE_GSON_FILE_AREA);
        fileWriter.write(json);
        fileWriter.close();
    }
}

