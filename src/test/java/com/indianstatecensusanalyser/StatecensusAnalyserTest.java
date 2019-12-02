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
           StatecensusAnalyser statecensusAnalyser= new StatecensusAnalyser("/home/admin1/Desktop/helo.java");
            int checkNumberOfRecords = statecensusAnalyser.readStateData();
            Assert.assertEquals(37, checkNumberOfRecords);
        } catch (CustomException | IOException e) {
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
}

