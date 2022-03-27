package com.example.babymafia.first;

public class Player {
    public String Name="Unnamed";
    protected int Life = 0; //0-смерть 1-предположительная смерть 2 жив
    protected int Role=0;     //1-mafia,2-doctor etc..
    protected boolean Permission_to_act=false; // if player can kill/cure 1 else 0
    protected boolean Ability_to_chat=false; //if life=0  everything become 0
    protected boolean Ability_to_vote=false;
    int votes=0;
    int winner=0;


    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getWinner() {
        return winner;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }


    public void setRole(int role) {
        Role = role;
    }

    public int getRole() {//need to know who is he
        return Role;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getVotes() {
        return votes;
    }

    public void setPermission_to_act(boolean permission_to_act) {
        Permission_to_act = permission_to_act;
    }

    public void getPermission_to_act(boolean permission_to_act) {
        Permission_to_act = permission_to_act;
    }

    public void setLife(int life) {
        Life = life;
    }

    public int getLife() {
        return Life;
    }

    public void setAbility_to_chat(boolean ability_to_chat) {
        Ability_to_chat = ability_to_chat;
    }

    public void setAbility_to_vote(boolean ability_to_vote) {
        Ability_to_vote = ability_to_vote;
    }

    public void put_to_a_vote(Player a){

        //button which votes++
        //Player a.setVotes(votes++);
    }

}
