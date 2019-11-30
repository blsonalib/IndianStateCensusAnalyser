package com.indianstatecensusanalyser;

public class CustomException extends Exception{

    enum ExceptionType
    {
        ENTERED_NULL, ENTERED_EMPTY,  NO_SUCH_METHOD,NO_SUCH_FILE, NO_SUCH_CLASS,
        OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE
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

