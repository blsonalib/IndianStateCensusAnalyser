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
    public void when_Read_CSV_File_Count_Records_Should_Return_True() throws IOException, CustomException {
        StatecensusAnalyser stateCensusAnalyser=new StatecensusAnalyser ();
        try {
               Assert.assertEquals(37,stateCensusAnalyser.readStateData());
        } catch (CustomException e) {
            Assert.assertEquals(e.type, CustomException.ExceptionType.NO_SUCH_FILE);
        }
    }
}
