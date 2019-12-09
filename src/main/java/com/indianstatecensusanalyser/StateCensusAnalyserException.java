package com.indianstatecensusanalyser;

public class StateCensusAnalyserException extends Exception{

    enum ExceptionType
    {
        ENTERED_NULL,DATA_NOT_FOUND,NO_SUCH_METHOD,NO_SUCH_FILE, INCORRECT_TYPE,INCORRECT_HEADER,FILE_NOT_FOUND,BINDING_OF_DATA,IO_EXCEPTION;
    }
    ExceptionType type;
    public StateCensusAnalyserException(ExceptionType type, String message)
    {
        super(message);
        this.type=type;
    }
    public StateCensusAnalyserException(ExceptionType type, Throwable cause){
        super(cause);
        this.type=type;
    }
    public StateCensusAnalyserException(ExceptionType type, String message, Throwable cause){
        super(message,cause);
        this.type=type;
    }
}

