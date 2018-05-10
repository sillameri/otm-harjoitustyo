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

    private int totalPointsNs;
    private int totalPointsEw;
    private int winnerPoints;
    private int loserPoints;
    private String team;

    public Winner(int totalPointsNs, int totalPointsEw) {
        this.totalPointsEw = totalPointsEw;
        this.totalPointsNs = totalPointsNs;
    }
    
   
    public Winner(String team, int points, int loserPoints){
        this.team = team;
        this.winnerPoints = points;
        this.loserPoints = loserPoints;
    }
    
    
    public int getPoints(){
        return this.winnerPoints;
    }
    
    public int getLoserPoints(){
        return this.loserPoints;
    }

    public String getWinner() {
        String winner = "";
        if (this.totalPointsEw > this.totalPointsNs) {
            winner = "EW";
        } else {
            winner = "NS";
        }
        return winner;
    }

    public void setWinnerAndLoserPoints() {
        if (getWinner().equals("NS")) {
            this.winnerPoints = this.totalPointsNs;
            this.loserPoints = this.totalPointsEw;
        } else {
            this.winnerPoints = this.totalPointsEw;
            this.loserPoints = this.totalPointsNs;
        }

    }
    
    

    @Override
    public String toString() {
        return getWinner() + ":" + this.winnerPoints + ":" + this.loserPoints +"\n";
    }

    
}
