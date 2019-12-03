package com.indianstatecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class StateCensus {
    public StateCensus() {
    }
    public StateCensus(String state, int population, int areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }
    @CsvBindByName(column = "State")
    private String state;
    @CsvBindByName(column = "Population")
    private int population;
    @CsvBindByName(column = "AreaInSqKm")
    private int areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm")
    private int densityPerSqKm;
    public String getState() {
        return state;
    }
    public int getPopulation() {
        return population;
    }
    public int getAreaInSqKm() {
        return areaInSqKm;
    }

    public int getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setState(String state) {

        this.state = state;
    }

    public void setPopulation(int population) {

        this.population = population;
    }

    public void setAreaInSqKm(int areaInSqKm) {

        areaInSqKm = areaInSqKm;
    }

    public void setDensityPerSqKm(int densityPerSqKm) {

        densityPerSqKm = densityPerSqKm;
    }
    @Override
    public String toString() {
        return "StateCensus{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
}
}


