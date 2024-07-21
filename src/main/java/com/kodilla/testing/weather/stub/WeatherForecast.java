package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0.0;
        int count = 0;
        for (double temperature : temperatures.getTemperatures().values()) {
            sum += temperature;
            count++;
        }
        return count > 0 ? sum / count : 0;
    }

    public double calculateMedianTemperature() {
        List<Double> temperatureList = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperatureList);
        int size = temperatureList.size();
        if (size == 0) {
            return 0;
        } else if (size % 2 == 1) {
            return temperatureList.get(size / 2);
        } else {
            return (temperatureList.get((size / 2) - 1) + temperatureList.get(size / 2)) / 2.0;
        }
    }
}