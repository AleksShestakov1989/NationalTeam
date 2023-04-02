package org.example;

import java.util.Arrays;

public class Main {
    public static int[][] regionalTeams = {
            {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
            {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
            {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
    };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(national_team(regionalTeams)));
    }

    public static int[] merge(int[] team, int[] regionalTeam) {
        int[] newTeam = new int[10];
        int countTeam = 0;
        int countRegionalTeam = 0;
        int countNewTeam = 0;
        while (countNewTeam < 10) {
            if (team[countTeam] >= regionalTeam[countRegionalTeam]) {
                newTeam[countNewTeam] = team[countTeam];
                countTeam += 1;
            } else {
                newTeam[countNewTeam] = regionalTeam[countRegionalTeam];
                countRegionalTeam += 1;
            }
            countNewTeam += 1;
        }
        return newTeam;
    }

    public static int[] national_team(int[][] regionalTeams) {
        int[] team = regionalTeams[0];
        for (int i = 1; i < regionalTeams.length; i++) {
            team = merge(team, regionalTeams[i]);
        }
        return team;
    }
}