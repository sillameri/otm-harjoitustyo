/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.domain;

/**
 *
 * @author Meri
 */
public class GamePointsCalculator {

    private int overLine;
    private int underLine;
    private int lostPoints;
    private String team;

    public GamePointsCalculator(String team, int overLine, int underLine, int lostPoints) {
        this.overLine = overLine;
        this.underLine = underLine;
        this.team = team;
        this.lostPoints = lostPoints;
    }

    public String PointsNsUnderLine() {
        String points = " ";
        if (team.equals("ns")) {
            points = String.valueOf(underLine);
        }
        return points;
    }

    public String PointsEwUnderLine() {
        String points = " ";
        if (team.equals("ew")) {
            points = String.valueOf(underLine);
        }
        return points;
    }

    public String PointsNsOverLine() {
        String points = " ";
        if (team.equals("ns")) {
            points = String.valueOf(overLine);
        }
        if (team.equals("ew")) {
            points = String.valueOf(lostPoints);
        }
        return points;
    }

    public String PointsEwOverLine() {
        String points = " ";
        if (team.equals("ew")) {
            points = String.valueOf(overLine);
        }
        if (team.equals("ns")) {
            points = String.valueOf(lostPoints);
        }
        return points;
    }

}
