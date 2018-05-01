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
public class RoundPoints {

    private String team;
    private String suit;
    private int contractTrick;
    private int resultTrick;
    private String resultOption;
    private String normalOption;
    private String vulnerableOption;

    public RoundPoints(String team, String suit, int contractTrick, int resultTrick, String resultOption, String normalOption, String vulnerableOption) {
        this.team = team;
        this.suit = suit;
        this.contractTrick = contractTrick;
        this.resultTrick = resultTrick;
        this.resultOption = resultOption;
        this.normalOption = normalOption;
        this.vulnerableOption = vulnerableOption;

    }

    public int getContractTrick() {
        return this.contractTrick;
    }

    public int getResultTrick() {
        return this.resultTrick;
    }

    public String getTeam() {
        return this.team;
    }

    public String getNormal() {
        return this.normalOption;
    }

    public String getVulnerable() {
        return this.vulnerableOption;
    }

    public int getSuitCoefficient() {
        int coefficient = 0;
        if (suit.equals("Pata") || suit.equals("Hertta")) {
            coefficient = 30;
        }
        if (suit.equals("Ruutu") || suit.equals("Risti")) {
            coefficient = 20;
        }
        return coefficient;
    }

    public int countNoTrumpPointsUnderLine() {
        int points = 0;
        if (suit.equals("Valtiton")) {
            if (getContractTrick() == 1) {
                points = 40;
            }
            points = 40;
            for (int i = 0; i < getContractTrick() - 1; i++) {
                points += 30;
            }
        }
        return points;
    }

    public int countNoTrumpPointsOverLine() {
        int points = 0;
        if (suit.equals("Valtiton")) {
            if (getResultTrick() == 1) {
                points = 40;
            }
            points = 40;
            for (int i = 0; i < getResultTrick() - 1; i++) {
                points += 30;
            }
            if (getResultTrick() == 0) {
                points = 0;
            }
        }
        return points;
    }

    public int countPointsUnderLine() {
        int points = 0;

        if (resultOption.equals("Yli")) {
            if (suit.equals("Valtiton")) {
                points = countNoTrumpPointsUnderLine();
            } else {
                points = getContractTrick() * getSuitCoefficient();
            }
        }
        return points;
    }

    public int countPointsOverLine() {
        int points = 0;
        if (resultOption.equals("Yli")) {
            if (suit.equals("Valtiton")) {
                points = countNoTrumpPointsOverLine();
            } else {
                points = getResultTrick() * getSuitCoefficient();
            }
        }
        return points;
    }

    public int countPointsOverLineWithConditions() {
        int points = 0;
        if (resultOption.equals("Yli")) {
            if (normalOption.equals("Normaali")) {
                points = countPointsOverLine();
            }
            if (normalOption.equals("Kahdennettu")) {
                if (vulnerableOption.equals("Vaaraton")) {
                    points = 100 * getResultTrick();
                }
                if (vulnerableOption.equals("Vaarassa")) {
                    points = 200 * getResultTrick();
                }
            }
            if (normalOption.equals("Vastakahdennettu")) {
                if (vulnerableOption.equals("Vaaraton")) {
                    points = 200 * getResultTrick();
                }
                if (vulnerableOption.equals("Vaarassa")) {
                    points = 400 * getResultTrick();
                }
            }
        }
        return points;
    }

    public int countUnVulnerableLostPoints() {
        int points = 0;
        if (resultOption.equals("Ali")) {
            for (int i = 1; i <= getResultTrick(); i++) {
                if (i == 1) {
                    points += 100;
                }
                if (i == 2 || i == 3) {
                    points += 200;
                }
                if (i >= 4) {
                    points += 300;
                }
            }
        }
        return points;
    }

    public int countVulnerableLostPoints() {
        int points = 0;
        if (resultOption.equals("Ali")) {
            for (int i = 1; i <= getResultTrick(); i++) {
                if (i == 1) {
                    points += 200;
                }
                if (i >= 2) {
                    points += 300;
                }
            }

        }
        return points;
    }

    public int countLostPointsWithConditions() {
        int points = 0;
        if (resultOption.equals("Ali")) {
            if (vulnerableOption.equals("Vaaraton")) {
                if (normalOption.equals("Normaali")) {
                    points = 50 * getResultTrick();
                }
                if (normalOption.equals("Kahdennettu")) {
                    points = countUnVulnerableLostPoints();
                }
                if (normalOption.equals("Vastakahdennettu")) {
                    points = 2 * countUnVulnerableLostPoints();
                }

            }
            if (vulnerableOption.equals("Vaarassa")) {
                if (normalOption.equals("Normaali")) {
                    points = 100 * getResultTrick();
                }
                if (normalOption.equals("Kahdennettu")) {
                    points = countVulnerableLostPoints();
                }
                if (normalOption.equals("Vastakahdennettu")) {
                    points = 2 * countVulnerableLostPoints();
                }
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return "Tarjous: " + contractTrick + " " + suit + " joukkue: " + team + ". Tulos: " + resultTrick + " " + resultOption + "\n"
                + "Voitetut pisteet alle linjan: " + countPointsUnderLine() + "\n"
                + "Voitetut pisteet linjan päälle: " + countPointsOverLineWithConditions() + "\n"
                + "Hävityt pisteet: " + countLostPointsWithConditions();

    }

}
