package ru.netology.smart_home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int currentVolume;
    final int minVolume = 0;
    final int maxVolume = 100;

    private int currentStation;
    private int numberOfStations = 10;
    final int firstStation = 0;

    // Конструктор с указанием количества радиостанций
    public Radio(int numberOfStations) {
        this.numberOfStations = numberOfStations;
    }

    // Переключение радиостанций

    public int calculateLastStation() {
        return firstStation + numberOfStations - 1;
    }

    public void nextStation() {
        int lastStation = calculateLastStation();
        if (currentStation < lastStation) {
            currentStation++;
        } else {
            currentStation = firstStation;
        }
    }

    public void prevStation() {
        int lastStation = calculateLastStation();
        if (currentStation > firstStation) {
            currentStation--;
        } else {
            currentStation = lastStation;
        }
    }

    public void setCurrentStation(int currentStation) {
        int lastStation = calculateLastStation();
        if (currentStation < firstStation) {
            return;
        }
        if (currentStation > lastStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    // Переключение громкости звука

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }
}