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
    private boolean isGameGoing = true;
    private int previousNs = 0;
    private int previousEw = 0;
    private boolean samaPreviosNs;
    private boolean samePreviousEw;

    private String team;
    private ArrayList<RoundPointsCalculator> list;
    private int currentGame;

    public GamePointsCalculator() {
        this.list = new ArrayList<>();
    }

    public int getBonus(String team1, String team2) {
        int bonus = 0;
        if (getWin(team1) == 2) {
            isGameGoing = false;
            bonus = 700;
            if (getWin(team2) == 1) {
                bonus = 500;
            }
        }
        return bonus;
    }

    public int getTotalPoints(String team1, String team2) {
        int sum = 0;

        for (RoundPointsCalculator rpc : list) {
            this.team = rpc.getTeam().toLowerCase();
            if (this.team.equals(team1)) {
                sum += rpc.countPointsOverLineWithConditions();
                sum += rpc.countPointsUnderLine();

            }
            if (this.team.equals(team2)) {
                sum += rpc.countLostPointsWithConditions();
            }

        }

        sum += getBonus(team1, team2);

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

        samePreviousEw = previousEw == overLineEw;
        previousEw = overLineEw;
    }

    public int getWin(String team) {
        if (team.equals("ns")) {
            return this.winNs;
        } else {
            return this.winEw;
        }
    }

    public boolean GameGoing() {
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
        if (overLineEw == 0 || samePreviousEw) {
            return "";
        }
        return String.valueOf(overLineEw);
    }

}
