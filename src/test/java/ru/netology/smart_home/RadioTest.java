package ru.netology.smart_home;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    Radio radio = new Radio();

    @Test
    public void shouldCreateDefaultRadio() {
        int expected = 9;
        int actual = radio.calculateLastStation(); // Получаем номер последней станции
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateCustomRadio() {
        Radio radio = new Radio(20); // Создаем радио с 20 радиостанциями
        int expected = 19;
        int actual = radio.calculateLastStation(); // Получаем номер последней станции
        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Middle station, 20, 5, 6",
            "Last station, 20, 19, 0"
    })
    public void shouldSetNextStation(String name, int numberOfStations, int currentStation, int expected) {
        Radio radio = new Radio(0, currentStation, numberOfStations);
        radio.nextStation(); // Переключаем на следующую станцию
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Middle station, 20, 5, 4",
            "First station, 20, 0, 19"
    })
    public void shouldSetPrevStation(String name, int numberOfStations, int currentStation, int expected) {
        Radio radio = new Radio(0, currentStation, numberOfStations);
        radio.prevStation(); // Переключаем на предыдущую станцию
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Middle station, 5, 5",
            "First station, 0, 0",
            "Last station, 9, 9",
            "Below Limit, -1, 0",
            "Over Limit, 10, 0",
    })
    public void shouldSetStation(String name, int currentStation, int expected) {
        radio.setCurrentStation(currentStation); // Переключаем на желаемую станцию
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Normal volume, 50, 51",
            "Maximum volume, 100, 100"
    })
    public void shouldIncreaseVolume(String name, int volume, int expected) {
        radio.setCurrentVolume(volume);
        radio.increaseVolume(); // Прибавляем громкость
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Normal volume, 50, 49",
            "Minimum volume, 0, 0"
    })
    public void shouldDecreaseVolume(String name, int volume, int expected) {
        radio.setCurrentVolume(volume);
        radio.decreaseVolume(); // Убавляем громкость
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }
}