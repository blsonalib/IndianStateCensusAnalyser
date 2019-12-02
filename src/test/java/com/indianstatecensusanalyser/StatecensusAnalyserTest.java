package com.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StatecensusAnalyserTest {
    @Test
    public void checkToEnsure_NumberOfRecordsMatches() throws CustomException, IOException {
        StatecensusAnalyser statecensusAnalyser = new StatecensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCode.csv");
        int checkNumberOfRecords = statecensusAnalyser.readStateData();
        Assert.assertEquals(37, checkNumberOfRecords);
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectFileName_GivesCustomException() {
        try {
                StatecensusAnalyser stateCensusAnalyser=new StatecensusAnalyser ("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCode11.csv");
                int checkNumberOfRecords = stateCensusAnalyser.readStateData();
                Assert.assertEquals(37, checkNumberOfRecords);
            } catch (CustomException | IOException e) {
                Assert.assertEquals("please enter proper file name",e.getMessage());
            }
        }
        @Test
     public void givenMessage_WhenWrongFileType_ShouldThrowRunTimeException() {
        try {
           StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCensusData.csv");
            int checkNumberOfRecords = statecensusAnalyser.readStateData();
            Assert.assertEquals(37, checkNumberOfRecords);
        } catch (CustomException | IOException e) {
            System.out.println("Wrong file path");
            Assert.assertEquals("please enter proper type of file", e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenWrongDelimer_ShouldThrowRunTimeException() {
        try {
            StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCode.csv");
            int checkNumberOfRecords = statecensusAnalyser.readStateData();
            Assert.assertEquals(37, checkNumberOfRecords);
        }catch (IOException e){
        } catch (CustomException   e ) {
            System.out.println(e.getMessage());
            Assert.assertEquals( "please enter proper delimeter of file", e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenWrongHeader_ShouldThrowRunTimeException() {
        try {
            StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/main/java/com/indianstatecensusanalyser/StateCodeIndia.csv");
            int checkNumberOfRecords = statecensusAnalyser.readStateData();
            Assert.assertEquals(37, checkNumberOfRecords);
        }catch (IOException e){
        } catch (CustomException   e ) {
            Assert.assertEquals( "please enter proper header of file", e.getMessage());
        }
    }
    /*----------------------------------------------------------------------------------------------*/
    @Test
    public void checkToEnsure_NumberOfRecordsMatchesInCensus_ShouldReturnrecords() throws CustomException, IOException {
        StatecensusAnalyser statecensus = new StatecensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCensusData.csv");
        Assert.assertEquals(29, statecensus.readStateCensusData());
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectFileName_InStateAnalyser_GivesCustomException() throws IOException {
        try {
            StatecensusAnalyser stateCensus=new StatecensusAnalyser ("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCensusData11.csv");
           Assert.assertEquals(29, stateCensus.readStateCensusData());
        } catch (CustomException e){
            System.out.println("Wrong file");
            Assert.assertEquals( "please enter proper file name",e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenWrongFileType_InStateCensus_ShouldThrowRunTimeException() {
        try {
            StatecensusAnalyser statecensus= new StatecensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCode.csv");
            int NumberOfRecords = statecensus.readStateCensusData();
            Assert.assertEquals(29, NumberOfRecords);
        } catch (CustomException | IOException e) {
            System.out.println("Wrong file type");
            Assert.assertEquals("please enter proper type of file", e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenWrongDelimer_InStateCensus_ShouldThrowRunTimeException() {
        try {
            StatecensusAnalyser statecensus= new StatecensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/StateCensusData.csv");
            Assert.assertEquals(29, statecensus.readStateCensusData());
        }catch (IOException e){
        } catch (CustomException   e ) {
            System.out.println(e.getMessage());
            Assert.assertEquals( "please enter proper delimeter of file", e.getMessage());
        }
    }
}

