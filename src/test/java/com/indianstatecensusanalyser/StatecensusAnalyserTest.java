package com.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StatecensusAnalyserTest {
    @Test
   public void checkToEnsure_NumberOfRecordsMatches() throws IOException, CustomException {
       StatecensusAnalyser stateCensusAnalyser=new StatecensusAnalyser ();
            Assert.assertEquals(37,stateCensusAnalyser.readStateData());
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectFileName_GivesCustomException() throws IOException, CustomException {
        StatecensusAnalyser stateCensusAnalyser=new StatecensusAnalyser ();
        try {
               Assert.assertEquals(37,stateCensusAnalyser.readStateData());
        } catch (CustomException e) {
            Assert.assertEquals(e.type, CustomException.ExceptionType.NO_SUCH_FILE);
        }
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectFileType_GivesCustomException() throws IOException {
        StatecensusAnalyser stateCensusAnalyser=new StatecensusAnalyser ();
        try {
            Assert.assertEquals(37,stateCensusAnalyser.readStateData());
        } catch (CustomException e) {
            Assert.assertEquals(e.type, CustomException.ExceptionType.INCORRECT_TYPE);
        }
    }
    @Test
    public void whenReadCSVFile_toCheckIncorrectDelimeter_GivesCustomException() throws IOException {
        StatecensusAnalyser stateCensusAnalyser=new StatecensusAnalyser ();
        try {
            Assert.assertEquals(37,stateCensusAnalyser.readStateData());
        } catch (CustomException e) {
            Assert.assertEquals(e.type, CustomException.ExceptionType.DATA_NOT_FOUND);
        }
    }
}

