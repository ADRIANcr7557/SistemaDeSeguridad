package Models;

public class Estadisticas {
    private String lastUpdate;
    private String country;
    private int confirmed;
    private int deaths;
    private int recovered;
    private int enable;

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getCountry() {
        return country;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getEnable() {
        return enable;
    }
}
