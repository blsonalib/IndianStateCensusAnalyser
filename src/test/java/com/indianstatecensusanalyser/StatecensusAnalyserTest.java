package com.indianstatecensusanalyser;

import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class StatecensusAnalyserTest {
          @Test
    public void checkToEnsure_NumberOfRecordsMatchesInCensus_ShouldReturnrecords() throws IOException, CustomException {
       StateCensusAnalyser statecensusAnalyser = new StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
        int NumberOfRecords = statecensusAnalyser.readStateCensusData();
        Assert.assertEquals(29, NumberOfRecords);
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectFileName_InStateAnalyser_GivesCustomException() throws IOException {
        try {
           StateCensusAnalyser statecensusAnalyser=new StateCensusAnalyser ("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData11.csv");
            int NumberOfRecords = statecensusAnalyser.readStateCensusData();
           Assert.assertEquals(29,NumberOfRecords);
        } catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMessage_WhenWrongFileType_InStateCensus_ShouldThrowRunTimeException() throws IOException {

            try {
                StateCensusAnalyser statecensusAnalyser = new StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCode.json");
                int  NumberOfRecords = statecensusAnalyser.readStateCensusData();
                Assert.assertEquals(29, NumberOfRecords);
            } catch (CustomException e) {
                System.out.println(e.getMessage());
                Assert.assertEquals( CustomException.ExceptionType.NO_SUCH_FILE,e.type);

            }

        }
        @Test
        public void givenMessage_WhenWrongDelimer_InStateCensus_ShouldThrowRunTimeException () throws IOException{
            try {
                StateCensusAnalyser statecensusAnalyser = new StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
                int NumberOfRecords = statecensusAnalyser.readStateCensusData();
                Assert.assertEquals(29, NumberOfRecords);

            } catch (CustomException  e) {
                System.out.println(e.getMessage());
                Assert.assertEquals(CustomException.ExceptionType.DATA_NOT_FOUND, e.getMessage());
            }
        }
        @Test
        public void givenMessage_WhenWrongHeader_InStateCensus_ShouldThrowRunTimeException () throws IOException{
            try {
                StateCensusAnalyser statecensusAnalyser = new StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
                int NumberOfRecords = statecensusAnalyser.readStateCensusData();
                Assert.assertEquals(29, NumberOfRecords);
            } catch (CustomException  e) {
                System.out.println(e.getMessage());
                Assert.assertEquals(CustomException.ExceptionType.DATA_NOT_FOUND, e.getMessage());
            }
        }
        @Test
    public void ForStates() throws IOException, CustomException {
              StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
              int NumberOfRecords = stateCensusAnalyser.readStateCensusData();

            Assert.assertEquals(29,NumberOfRecords);
        }

    }
