package com.indianstatecensusanalyser;

public class States {
    private String SrNo;
    private String StateName;
    private String TIN;
    private  String StateCode;
    public States()
    {

    }
    public String getSrNo() {

        return SrNo;
    }

    public void setSrNo(String srNo) {

        SrNo = srNo;
    }

    public String getStateName() {

        return StateName;
    }

    public void setStateName(String stateName) {

        StateName = stateName;
    }

    public String getTIN() {

        return TIN;
    }

    public void setTIN(String TIN) {

        this.TIN = TIN;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {

        StateCode = stateCode;
    }

    @Override
    public String toString() {
        return "State{" +
                "SrNo='" + SrNo + '\'' +
                ", StateName='" + StateName + '\'' +
                ", TIN='" + TIN + '\'' +
                ", StateCode='" + StateCode + '\'' +
                '}';
    }
}

