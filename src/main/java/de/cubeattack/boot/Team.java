package de.cubeattack.boot;

public class Team implements Comparable<Team> {
    private final String team;
    private int points;

    public Team(String team, int points) {
        this.team = team;
        this.points = points;
    }

    public String team() {
        return team;
    }

    public int points() {
        return points;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Team person))
            return false;
        return person.team.equals(team) && person.points == points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public String toString(){
        return "Name: " + team +", points = " + points;
    }

    public String getName(){
        return "Name: " + team;
    }

    public int compareTo(Team person) {
        return Integer.compare(points, person.points);
    }
}
