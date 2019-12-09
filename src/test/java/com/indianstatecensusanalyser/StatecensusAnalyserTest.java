package com.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class StatecensusAnalyserTest {

    @Test
    public void givenMessage_ToEnsure_NumberOfRecordsMatchesInCensus_ShouldReturnrecords() {
        StateCensusAnalyser statecensusAnalyser = new  StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensus.json");
        int NumberOfRecords = 0;
        try {
            NumberOfRecords = statecensusAnalyser.readStateCensusData();
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(29, NumberOfRecords);
        }
    }

    @Test
    public void givenMessage_toCheckIncorrectFileName_InStateAnalyser_ShouldReturnException(){
        StateCensusAnalyser statecensusAnalyser = new StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData123.csv");
        int NumberOfRecords = 0;
        try {
            NumberOfRecords = statecensusAnalyser.readStateCensusData();
            Assert.assertEquals(29, NumberOfRecords);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenMessage_WhenWrongFileType_InStateCensus_ShouldReturnException() {
        StateCensusAnalyser statecensusAnalyser = new  StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCode.json");
        int NumberOfRecords = 0;
        try {
            NumberOfRecords = statecensusAnalyser.readStateCensusData();
            Assert.assertEquals(29, NumberOfRecords);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenMessage_WhenWrongDelimer_InStateCensus_ShouldThrowRunTimeException() {
        try {
            StateCensusAnalyser statecensusAnalyser = new  StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
            int numberOfRecords = statecensusAnalyser.readStateCensusData();
            Assert.assertEquals(29, numberOfRecords);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.DATA_NOT_FOUND, e.getMessage());
        }
    }

    @Test
    public void givenMessage_WhenWrongHeader_InStateCensus_ShouldThrowRunTimeException() {
        try {
            StateCensusAnalyser statecensusAnalyser = new StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
            int numberOfRecords = statecensusAnalyser.readStateCensusData();
            Assert.assertEquals(29, numberOfRecords);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.DATA_NOT_FOUND, e.getMessage());
        }
    }

    @Test
    public void givenMessage_ForStateName_ShouldReturnAlphabeticOrder() {
        StateCensusAnalyser stateCensusAnalyser = new  StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
        int numberOfRecords = 0;
        try {
            numberOfRecords = stateCensusAnalyser.readStateCensusData();
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(29, numberOfRecords);
        }
    }

    @Test
    public void givenMessage_ToSort_Population_ShoulsReturnMostPopulationState() {
        StateCensusAnalyser stateCensusAnalyser = new  StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
        int numberOfRecords = 0;
        try {
            numberOfRecords = stateCensusAnalyser.readStateCensusData();
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(29, numberOfRecords);
        }
    }

    @Test
    public void givenMessage_ToSort_PopulationDencity_ShoulsReturnPopulationDencity() {
        StateCensusAnalyser stateCensusAnalyser = new  StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
        int numberOfRecords = 0;
        try {
            numberOfRecords = stateCensusAnalyser.readStateCensusData();
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(29, numberOfRecords);
        }
    }

    @Test
    public void givenMessage_ToSort_AreaOfState_ShoulsReturnLargetStateToSmallest() {
        StateCensusAnalyser stateCensusAnalyser = new  StateCensusAnalyser("/home/admin1/IdeaProjects/IndianStateCensusAnalyser/src/test/resources/StateCensusData.csv");
        int numberOfRecords = 0;
        try {
            numberOfRecords = stateCensusAnalyser.readStateCensusData();
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(29, numberOfRecords);
        }
    }
}





