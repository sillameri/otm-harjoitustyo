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
    private int underLineNs2;
    private int underLineEw2;
    private boolean round2;

    private String team;
    private ArrayList<RoundPointsCalculator> list;

    public GamePointsCalculator() {
        this.list = new ArrayList<>();
        round2 = false;
    }

    public void updateSumNsPoints() {
        this.overLineNs = 0;
        this.underLineNs = 0;
        this.underLineNs2 = 0;
        for (RoundPointsCalculator rpc : list) {
            this.team = rpc.getTeam().toLowerCase();
            if (team.equals("ns")) {
                this.overLineNs += rpc.countPointsOverLineWithConditions();
                if (this.underLineNs >= 100 || round2 == true) {
                    round2 = true;
                    this.underLineNs2 += rpc.countPointsUnderLine();
                } else {
                    this.underLineNs += rpc.countPointsUnderLine();
                }
            }
            if (team.equals("ew")) {
                this.overLineNs += rpc.countLostPointsWithConditions();
            }
        }
    }

    public void updateSumEwPoints() {
        this.overLineEw = 0;
        this.underLineEw = 0;
        this.underLineEw2 = 0;
        for (RoundPointsCalculator rpc : list) {
            this.team = rpc.getTeam().toLowerCase();
            if (team.equals("ew")) {
                this.overLineEw += rpc.countPointsOverLineWithConditions();
                if (this.underLineEw >= 100 || round2 == true) {
                    round2 = true;
                    this.underLineEw2 += rpc.countPointsUnderLine();
                } else {
                    this.underLineEw += rpc.countPointsUnderLine();
                }
            }
            if (team.equals("ns")) {
                this.overLineEw += rpc.countLostPointsWithConditions();
            }
        }
    }

    public void addrpc(RoundPointsCalculator roundPointsCalculator) {
        list.add(roundPointsCalculator);

    }

    public String getUnderLineNs() {
        if (underLineNs == 0) {
            return "";
        }
        return String.valueOf(underLineNs);
    }

    public String getUnderLineEw() {
        if (underLineEw == 0) {
            return "";
        }
        return String.valueOf(underLineEw);
    }

    public String getUnderLineNs2() {
        if (underLineNs2 == 0) {
            return "";
        }
        return String.valueOf(underLineNs2);
    }

    public String getUnderLineEw2() {
        if (underLineEw2 == 0) {
            return "";
        }
        return String.valueOf(underLineEw2);
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
