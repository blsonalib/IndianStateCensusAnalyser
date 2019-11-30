package com.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StatecensusAnalyserTest {
    @Test
   public void checkToEnsure_NumberOfRecordsMatches() throws IOException {
       StatecensusAnalyser stateCensusAnalyser=new StatecensusAnalyser ();
       Assert.assertEquals(37,stateCensusAnalyser.readStateData());
       }
   }

