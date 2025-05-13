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
        if (temperatures.getTemperatures().isEmpty()) {
            return 0;
        }
        Collection<Double> values = temperatures.getTemperatures().values();
        double sum = 0.0;
        for (Double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    public double calculateMedianTemperature() {
        if (temperatures.getTemperatures().isEmpty()) {
            return 0.0;
        }
        List<Double> values = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(values);
        int size = values.size();
        if (size % 2 == 1) {
            return values.get(size / 2);
        }
        else {
            int middle = size / 2;
            return (values.get(middle - 1) + values.get(middle)) / 2.0;
        }
    }
}