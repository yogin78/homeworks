package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeEach
    public void setUp() {
        temperaturesMock = Mockito.mock(Temperatures.class);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        Mockito.when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    @DisplayName("Test calculateForecast")
    public void testCalculateForecast() {
        // When
        Map<String, Double> resultMap = weatherForecast.calculateForecast();

        // Then
        assertEquals(26.5, resultMap.get("Rzeszow"));
        assertEquals(27.2, resultMap.get("Krakow"));
        assertEquals(25.8, resultMap.get("Wroclaw"));
        assertEquals(26.2, resultMap.get("Warszawa"));
        assertEquals(27.1, resultMap.get("Gdansk"));
    }

    @Test
    @DisplayName("Test calculateAverageTemperature")
    public void testCalculateAverageTemperature() {
        // When
        double averageTemperature = weatherForecast.calculateAverageTemperature();

        // Then
        assertEquals(25.56, averageTemperature, 0.01);
    }

    @Test
    @DisplayName("Test calculateMedianTemperature")
    public void testCalculateMedianTemperature() {
        // When
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        // Then
        assertEquals(25.5, medianTemperature);
    }
}
