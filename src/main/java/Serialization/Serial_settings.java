package Serialization;

import Interface.Settings.Settings;

import java.io.Serializable;

public class Serial_settings implements Serializable {

    private String t;
    private String i;
    private Double f;
    private Double b;


    public Serial_settings() {
        t = Settings.theme;
        i = Settings.icon_color;
        f = Settings.fx_volume;
        b = Settings.bg_volume;
    }

    public Double getBg_volume() {
        return b;
    }

    public Double getFx_volume() {
        return f;
    }

    public String getIcon_color() {
        return i;
    }

    public String getTheme() {
        return t;
    }

}
