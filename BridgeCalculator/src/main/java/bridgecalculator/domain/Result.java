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
public class Result {

    private int pointsNs;
    private int pointsEw;

    public Result(int totalPointsNs, int totalPointsEw) {
        this.pointsNs = totalPointsNs;
        this.pointsEw = totalPointsEw;

    }
    public String getWinner() {
        String winner = "";
        if (this.pointsNs > this.pointsEw) {
            winner = "NS";
        }
        if (this.pointsEw > this.pointsNs) {
            winner = "EW";
        }
        return winner;
    }

    @Override
    public String toString() {
        String print = "";
        if (getWinner().equals("NS")) {
            print += "NS:" + this.pointsNs + ":" + this.pointsEw + "\n";
        } else if (getWinner().equals("EW")) {
            print += "EW:" + this.pointsEw + ":" + this.pointsNs + "\n";
        }
        return print;
    }
}
