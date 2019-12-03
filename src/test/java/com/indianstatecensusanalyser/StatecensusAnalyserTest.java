package com.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StatecensusAnalyserTest {
       States states=new States();
       StateCensus stateCensus=new StateCensus();
    @Test
    public void checkToEnsure_NumberOfRecordsMatches() throws CustomException, IOException {
        StatecensusAnalyser statecensusAnalyser=new StatecensusAnalyser();
       int checkNumberOfRecords = statecensusAnalyser.readStateCensusData(states,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCode.csv");
        Assert.assertEquals(37, checkNumberOfRecords);
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectFileName_GivesCustomException() throws IOException{
        try {
            StatecensusAnalyser statecensusAnalyser=new StatecensusAnalyser();
                int checkNumberOfRecords = statecensusAnalyser.readStateCensusData(states,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCode11.csv");
                Assert.assertEquals(37, checkNumberOfRecords);
            } catch (CustomException e) {
                 System.out.println(e.getMessage());
                Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
            }
        }
        @Test
     public void givenMessage_WhenWrongFileType_ShouldThrowRunTimeException() throws IOException{
        try {
           StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser();
            int checkNumberOfRecords = statecensusAnalyser.readStateCensusData(states,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCode.json");
            Assert.assertEquals(37, checkNumberOfRecords);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMessage_WhenWrongDelimer_ShouldThrowRunTimeException() throws IOException{
        try {
            StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser();
            int checkNumberOfRecords = statecensusAnalyser.readStateCensusData(states,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCode.csv");
            Assert.assertEquals(37, checkNumberOfRecords);
        } catch (CustomException   e ) {
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.DATA_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenMessage_WhenWrongHeader_ShouldThrowRunTimeException() throws IOException {
        try {
            StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser();
            int checkNumberOfRecords = statecensusAnalyser.readStateCensusData(states,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCode.csv");
            Assert.assertEquals(37, checkNumberOfRecords);
        } catch (CustomException  e ) {
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.DATA_NOT_FOUND,e.type);
        }
    }
    /*----------------------------------------------------------------------------------------------*/
    @Test
    public void checkToEnsure_NumberOfRecordsMatchesInCensus_ShouldReturnrecords() throws IOException, CustomException {
        StatecensusAnalyser statecensusAnalyser = new StatecensusAnalyser();
        int NumberOfRecords = statecensusAnalyser.readStateCensusData(stateCensus,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
        Assert.assertEquals(29, NumberOfRecords);
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectFileName_InStateAnalyser_GivesCustomException() throws IOException {
        try {
            StatecensusAnalyser statecensusAnalyser=new StatecensusAnalyser ();
           Assert.assertEquals(29, statecensusAnalyser.readStateCensusData(stateCensus,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData11.csv"));
        } catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMessage_WhenWrongFileType_InStateCensus_ShouldThrowRunTimeException() {
        try {
            StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser();
            int NumberOfRecords = statecensusAnalyser.readStateCensusData(stateCensus,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCensusData.json");
            Assert.assertEquals(29, NumberOfRecords);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMessage_WhenWrongDelimer_InStateCensus_ShouldThrowRunTimeException() {
        try {
            StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser();
            int NumberOfRecords = statecensusAnalyser.readStateCensusData(stateCensus,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
            Assert.assertEquals(29, NumberOfRecords);

        } catch (CustomException   e ) {
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.DATA_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenMessage_WhenWrongHeader_InStateCensus_ShouldThrowRunTimeException() {
        try {
            StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser();
            int NumberOfRecords = statecensusAnalyser.readStateCensusData(stateCensus,"/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
            Assert.assertEquals(29,NumberOfRecords);
        } catch (CustomException   e ) {
            System.out.println(e.getMessage());
            Assert.assertEquals( CustomException.ExceptionType.DATA_NOT_FOUND,e.type);
        }
    }
}

