package com.indianstatecensusanalyser;

public class CustomException extends Exception{

    enum ExceptionType
    {
        ENTERED_NULL,DATA_NOT_FOUND,NO_SUCH_METHOD,NO_SUCH_FILE, INCORRECT_TYPE,
    }
    ExceptionType type;
    public CustomException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
    public CustomException (ExceptionType type,Throwable cause){
        super(cause);
        this.type=type;
    }
    public CustomException(ExceptionType type,String message,Throwable cause){
        super(message,cause);
        this.type=type;
    }
}

