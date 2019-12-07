package com.indianstatecensusanalyser;

import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.*;

public class StatecensusAnalyserTest {
    StateCensusAnalyser statecensusAnalyser = new StateCensusAnalyser();
     @Test
     public void checkToEnsure_NumberOfRecordsMatchesInCensus_ShouldReturnrecords() throws IOException, CustomException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
              try {
                  Assert.assertEquals(29, statecensusAnalyser.readStateCensusData("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv", ""));
              } catch (CustomException e) {
                  e.printStackTrace();
              }
          }
     @Test
     public void whenReadCSVFile_toCheckIncorrectFileName_InStateAnalyser_GivesCustomException() throws InvocationTargetException, NoSuchMethodException, IOException, IllegalAccessException {
        try {
            int NumberOfRecords = statecensusAnalyser.readStateCensusData( "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData1.csv",null);
           Assert.assertEquals(29,NumberOfRecords);
        } catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.NO_SUCH_FILE,e.type);
         }
       }
     @Test
     public void givenMessage_WhenWrongFileType_InStateCensus_ShouldThrowRunTimeException() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

            try {

                int  NumberOfRecords = statecensusAnalyser.readStateCensusData("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.jsonS","");
                Assert.assertEquals(29, NumberOfRecords);
            } catch (CustomException e) {
                System.out.println(e.getMessage());
                Assert.assertEquals( CustomException.ExceptionType.NO_SUCH_FILE,e.type);

            }
           }
        @Test
        public void givenMessage_WhenWrongDelimer_InStateCensus_ShouldThrowRunTimeException () throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            try {

                int NumberOfRecords = statecensusAnalyser.readStateCensusData( "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv","");
                Assert.assertEquals(29, NumberOfRecords);

            } catch (CustomException  e) {
                System.out.println(e.getMessage());
                Assert.assertEquals(CustomException.ExceptionType.DATA_NOT_FOUND, e.type);
            }
          }
        @Test
        public void givenMessage_WhenWrongHeader_InStateCensus_ShouldThrowRunTimeException () throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            try {

                int NumberOfRecords = statecensusAnalyser.readStateCensusData( "/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv","");
                Assert.assertEquals(29, NumberOfRecords);
            } catch (CustomException  e) {
                System.out.println(e.getMessage());
                Assert.assertEquals(CustomException.ExceptionType.DATA_NOT_FOUND, e.type);
            }
         }
        @Test
        public void givenMessage_ForStateName_ShouldReturnAllAphabeticOrder() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CustomException {

               int NumberOfRecords = statecensusAnalyser.readStateCensusData("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv","getState");
                Assert.assertEquals(29,NumberOfRecords);
          }
      @Test
      public void givenMessage_ForPopulation_ShoulsReturnMostPopulationState() throws IOException, CustomException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        int NumberOfRecords = statecensusAnalyser.readStateCensusData("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv","getPopulation");
        Assert.assertEquals(29,NumberOfRecords);
        }
      @Test
      public void givenMessage_ForPopulationDencity_ShoulsReturnPopulationDencity() throws IOException, CustomException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        int NumberOfRecords =statecensusAnalyser.readStateCensusData("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv","getDensityPerSqKm");
        Assert.assertEquals(29,NumberOfRecords);
        }
      @Test
      public void givenMessage_ForArea_ShouldReturnlargetStateToSmallest() throws IOException, CustomException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        int NumberOfRecords = statecensusAnalyser.readStateCensusData("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv","AreaInSqKm");
        Assert.assertEquals(29,NumberOfRecords);
       }
}
