package com.indianstatecensusanalyser;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class StateCensusAnalyser <T extends Comparable<T>> {
    List<StateCensus> csvDataList = new ArrayList<>();
    public int readStateCensusData(String FilePath,String methodname) throws CustomException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        int statesCounter = 0;
        Reader reader = null;
        try
        {
            reader = Files.newBufferedReader(Paths.get(FilePath));
            CsvToBean<StateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(StateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true).build();
            Iterator<StateCensus> CsvStateIterator = csvToBean.iterator();

            while (CsvStateIterator.hasNext())
            {
                statesCounter++;
                StateCensus csvUser = CsvStateIterator.next();
                csvDataList.add(csvUser);
            }
           sortByCasvFile(csvDataList,methodname);
            writeToJason(csvDataList);

        }   catch (NoSuchFileException e) {
        throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE, "please enter proper file name");
    }catch (RuntimeException  e) {
            throw new CustomException(CustomException.ExceptionType.DATA_NOT_FOUND, "please enter proper header of file");
    }
        return statesCounter;
    }

    public void sortByCasvFile(List<StateCensus>gsonData, String methodname) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException
    {
        for(int i = 0; i< csvDataList.size()-1; i++) {
            for (int j = 0; j < csvDataList.size() - i - 1; j++) {

                Class aClass = csvDataList.get(j).getClass();
                Method callMethod1 = aClass.getDeclaredMethod(methodname);
                T csvValue1 = (T) callMethod1.invoke(csvDataList.get(j));

                Class aClass1 = csvDataList.get(j).getClass();
                Method callMethod2 = aClass1.getDeclaredMethod(methodname);
                T csvValue2 = (T) callMethod2.invoke(csvDataList.get(j+1));
                if ((csvValue1).compareTo(csvValue2) >= 0) {
                    StateCensus temp = csvDataList.get(j);
                    csvDataList.set(j, csvDataList.get(j + 1));
                    csvDataList.set(j + 1, temp);
                }
            }
        }
        for(int k = 0; k< csvDataList.size(); k++){
            System.out.println(csvDataList.get(k).getState());
        }
    }
    public void writeToJason(List<StateCensus> csvDataList)
    {
        String FilePath="/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StatescensusData.json";
        Gson gson = new Gson();
        String json = gson.toJson(csvDataList);
        FileWriter writer = null;
        try {
            writer = new FileWriter(FilePath);
            writer.write(json);
            writer.close();
        }catch(Exception e) {

            e.printStackTrace();
        }
    }
}