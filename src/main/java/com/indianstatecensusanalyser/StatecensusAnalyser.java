package com.indianstatecensusanalyser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;

public class StatecensusAnalyser {



    public int readStateCensusData(Object className, String csvFile) throws CustomException{

        int counter=0;

        Object object=className;

        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFile));

        ) {

            CsvToBean<Object> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(object.getClass())
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();


            Iterator<Object> iterator = csvToBean.iterator();

            while (iterator.hasNext()) {

                Object statess= iterator.next();

                counter++;
            }

        }
        catch (NoSuchFileException e) {

            if (csvFile.contains(".csv"))

                throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE, "Please enter proper file name");

            else if (!csvFile.contains(".csv"))

                throw new CustomException(CustomException.ExceptionType.NO_SUCH_FILE, "Please enter proper file type");

        }
        catch (RuntimeException e) {

            throw new CustomException(CustomException.ExceptionType.DATA_NOT_FOUND, "Please enter proper delimeter and header");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return counter;

    }

}