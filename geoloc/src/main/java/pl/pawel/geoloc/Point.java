package pl.pawel.geoloc;

import org.springframework.stereotype.Component;

@Component
public class Point {

    private double x;
    private double y;
    private String text;

    public Point(double x, double y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public Point() {
    }
}
