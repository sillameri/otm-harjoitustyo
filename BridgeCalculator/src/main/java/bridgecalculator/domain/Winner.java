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
public class Winner {

    private int winnerPoints;
    private int loserPoints;
    private String team;


    public Winner(String team, int points1, int points2) {
        this.team = team;
        this.winnerPoints = points1;
        this.loserPoints = points2;
    }

    public int getWinnerPoints() {
        return this.winnerPoints;
    }

    public int getLoserPoints() {
        return this.loserPoints;
    }
    
    public String getWinner(){
        return this.team;
    }

    @Override
    public String toString() {
        return this.team + ":" + this.winnerPoints + ":" + this.loserPoints + "\n";
    }

}
