package de.cubeattack.boot;

import java.util.*;

public class Main {

    public static List<Team> usersList = new ArrayList<>();
    public static HashMap<String, Integer> sortTeam = new HashMap();

    public static void main(String[] args) {
        addTeams();
        sortTeams();
        //System.out.println(getTeamRankString("Team7"));
        //getTop(8);
        Team team = new Team("Team9", 10);
        System.out.println(team);
        double test = 50;
        for (int i = 0; i < 50 ; i++) {
            test = test*0.9;
        }
        System.out.println(test);
    }

    public static void addTeams(){
        if(usersList.isEmpty()) {
            usersList.add(new Team("Team1", 11));
            usersList.add(new Team("Team2", 1));
            usersList.add(new Team("Team3", 23));
            usersList.add(new Team("Team4", 7));
            usersList.add(new Team("Team5", 151));
            usersList.add(new Team("Team6", 151));
            usersList.add(new Team("Team7", 20));
            usersList.add(new Team("Team8", 6));
        }
    }

    public static void sortTeams(){
        Collections.sort(usersList, Collections.reverseOrder());
        int ranking = 1;
        sortTeam.clear();
        for (int i = ranking; i < (usersList.size()+1);i++) {
            if (i != 1 && usersList.get((i - 1)).points() == usersList.get((i - 2)).points()) {
                ranking--;
            }
            sortTeam.put(usersList.get(i-1).team(), (ranking));
            ranking++;
        }
    }
    public static void getTop(int amount) {
        String top = null;
        amount = amount + 1;
        int ranking = 1;
        for (int i = ranking; i < amount; i++) {
            if(top != null) {
                if (usersList.get((i - 1)).points() == usersList.get((i - 2)).points()) {
                    ranking--;
                }
                top = top + "#" + (ranking) + " " + usersList.get(i-1) + "\n";
            }else{
                top ="#" + (ranking) + " " + usersList.get(0) + "\n";
            }
            ranking++;
        }
        System.out.println(top);
    }

    public static String getTeamRankString(String teamName) {
        String team = teamName + " hat den Platzt #" + sortTeam.get(teamName);
        return team;
    }
    public static String getTeamRank(String teamName) {
        String team =  "#" + sortTeam.get(teamName);
        return team;
    }
}

