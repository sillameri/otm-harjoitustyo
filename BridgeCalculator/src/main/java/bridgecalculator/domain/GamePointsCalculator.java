/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.domain;

import java.util.ArrayList;

/**
 *
 * @author Meri
 */
public class GamePointsCalculator {

    private int overLineNs;
    private int overLineEw;
    private int underLineNs;
    private int underLineEw;
    private int winNs;
    private int winEw;
    private boolean isGameGoing = false;

    private String team;
    private ArrayList<RoundPointsCalculator> list;
    private int currentGame;

    public GamePointsCalculator() {
        this.list = new ArrayList<>();
    }

//    public int getTotalPoints(String team) {
//        int sum = 0;
//
//        for (RoundPointsCalculator rpc : list) {
//            this.team = rpc.getTeam().toLowerCase();
//            if (this.team.equals(team)) {
//                sum += rpc.countPointsOverLineWithConditions();
//                sum += rpc.countPointsUnderLine();
//                sum += rpc.countLostPointsWithConditions();
//            }
//
//        }
//        int bonus = 0;
//        if (team.equals("ns")) {
//            if (getWinNs() == 2) {
//                if (getWinEw() == 1) {
//                    bonus = 500;
//                } else {
//                    bonus = 700;
//                }
//            }
//        } else if (getWinEw() == 2) {
//            if (getWinNs() == 1) {
//                bonus = 500;
//            } else {
//                bonus = 700;
//            }
//        }
//        sum += bonus;
//
//        return sum;
//    }
    
     public int getTotalPoints(String team1, String team2) {
        int sum = 0;

        for (RoundPointsCalculator rpc : list) {
            this.team = rpc.getTeam().toLowerCase();
            if (this.team.equals(team1)) {
                sum += rpc.countPointsOverLineWithConditions();
                sum += rpc.countPointsUnderLine();
                
            }if(this.team.equals(team2)){
                sum += rpc.countLostPointsWithConditions();
            }

        }
        int bonus = 0;
        if (team.equals("ns")) {
            if (getWinNs() == 2) {
                isGameGoing = false;
                if (getWinEw() == 1) {
                    bonus = 500;
                } else {
                    bonus = 700;
                }
            }
        } else if (getWinEw() == 2) {
            isGameGoing = false;
            if (getWinNs() == 1) {
                bonus = 500;
            } else {
                bonus = 700;
            }
        }
        sum += bonus;

        return sum;
    }

    public void updateSumNsPoints() {
        this.overLineNs = 0;
        this.underLineNs = 0;

        for (RoundPointsCalculator rpc : list) {
            this.team = rpc.getTeam().toLowerCase();
            if (team.equals("ns")) {
                this.overLineNs += rpc.countPointsOverLineWithConditions();
                if (currentGame == rpc.getGame()) {
                    this.underLineNs += rpc.countPointsUnderLine();
                }
            }
            if (team.equals("ew")) {
                this.overLineNs += rpc.countLostPointsWithConditions();
            }

        }
        if (underLineNs >= 100) {
            winNs++;
        }
    }

    public void updateSumEwPoints() {
        this.overLineEw = 0;
        this.underLineEw = 0;
        for (RoundPointsCalculator rpc : list) {
            this.team = rpc.getTeam().toLowerCase();
            if (team.equals("ew")) {
                this.overLineEw += rpc.countPointsOverLineWithConditions();
                if (currentGame == rpc.getGame()) {
                    this.underLineEw += rpc.countPointsUnderLine();
                }
            }
            if (team.equals("ns")) {
                this.overLineEw += rpc.countLostPointsWithConditions();
            }
        }
        if (underLineEw >= 100) {
            winEw++;
        }
    }

    public int getWinNs() {
        return this.winNs;
    }

    public int getWinEw() {
        return this.winEw;
    }
    
    public boolean GameGoing(){
        return this.isGameGoing;
    }

    public void addrpc(RoundPointsCalculator roundPointsCalculator) {
        roundPointsCalculator.setGame(currentGame);
        list.add(roundPointsCalculator);

    }

    public void setCurrentGame(int currentGame) {
        this.currentGame = currentGame;
    }

    public int getUnderLineNs() {
        return underLineNs;
    }

    public int getUnderLineEw() {
        return underLineEw;
    }

    public String getOverLineNs() {
        if (overLineNs == 0) {
            return "";
        }
        return String.valueOf(overLineNs);
    }

    public String getOverLineEw() {
        if (overLineEw == 0) {
            return "";
        }
        return String.valueOf(overLineEw);
    }

}
