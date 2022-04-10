package com.example.babymafia.first;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Game {
    int role = 0;
    int number_of_players = 0;
    int count_of_mafias = 0;
    int count_of_doctor = 0;
    int count_of_sweeties = 0;
    int count_of_citizens = 0;
    int count_of_madmen = 0;
    int count_of_commissioners = 0;
    int player_with_max_vote;
    int time_of_day = 1;//1 means day
    int j = 0;
    int win=0;

    Vector<Player> players = new Vector<Player>();

    public void Number_of_players() {
        Scanner in = new Scanner(System.in);
        number_of_players = in.nextInt();
    }

    public int find_max_vote() {
        int max_votes = -100;
        for (int j = 0; j < count_of_mafias; j++) {
            if (players.get(j).getVotes() > max_votes) {
                max_votes = players.get(j).getVotes();
                player_with_max_vote = j;
            }
        }
        return player_with_max_vote;
    }

    public void Night() {
        time_of_day = 2;

        for (int i = 0; i < number_of_players; i++) {
            if (players.get(i).getRole() == 1) {//проститутка, мафия, маньяк, лекарь, комиссар
                players.get(i).setPermission_to_act(true);
                //push button with time
                visit();
                players.get(i).setPermission_to_act(false);
                break;
            }
        }

        for (int i = 0; i < number_of_players; i++) {
            if (players.get(i).getRole() == 2) {//проститутка, мафия, маньяк, лекарь, комиссар
                players.get(i).setPermission_to_act(true);
                put_to_a_vote();//на когото тыкнуть справа маленький кружечек votes
            }
            players.get(i).setPermission_to_act(false);
        }


        players.get(find_max_vote()).setLife(1);
//обнулить голоса

        for (int i = 0; i < number_of_players; i++) {
            if (players.get(i).getRole() == 3) {//проститутка, мафия, маньяк, лекарь, комиссар
                players.get(i).setPermission_to_act(true);
                //push button with time
                kill();
                players.get(i).setPermission_to_act(false);
                break;
            }
        }


        for (int i = 0; i < number_of_players; i++) {
            if (players.get(i).getRole() == 4) {//проститутка, мафия, маньяк, лекарь, комиссар
                players.get(i).setPermission_to_act(true);
                //push button with time
                cure();
                players.get(i).setPermission_to_act(false);
                break;
            }
        }

        for (int i = 0; i < number_of_players; i++) {
            if (players.get(i).getRole() == 5) {//проститутка, мафия, маньяк, лекарь, комиссар
                players.get(i).setPermission_to_act(true);
                //push button with time
                check();

                players.get(i).setPermission_to_act(false);
                break;
            }
        }


    }

    public void Day() {
        time_of_day = 1;
        for (int i = 0; i < number_of_players; i++) {
  //          if (players.get(i).getLife() == 1) {
 //               Player player = players.get(i);   // преобразование восходящие плэер плэер неправильно и вообще это не надо делать потому что нам нао показывать иконки и потом присуждать победу
  //              number_of_players--;/////не забыть
   //             players.get(i).setLife(0);//не забыть
     //       }
            switch (players.get(i).getRole()) {
                case 1:
                    count_of_sweeties--;
                    break;

                case 2:
                    count_of_mafias--;
                    break;
                case 3: {
                    count_of_madmen--;
                    break;
                }
                case 4: {
                    count_of_doctor--;
                    break;
                }
                case 5: {
                    count_of_commissioners--;
                    break;
                }
                case 6: {
                    count_of_citizens--;
                    break;
                }
                default:
                    break;///откуда выход?
            }

        }
        for (int i = 0; i < number_of_players; i++) {
            if (players.get(i).getLife() != 0) {
                players.get(i).setAbility_to_chat(true);
                players.get(i).setAbility_to_vote(true);
            }
        }

        for (int i = 0; i < number_of_players; i++) {
            vote();//button
        }

        players.get(find_max_vote()).setLife(0);

        for (int i = 0; i < number_of_players; i++) {
            players.get(i).setVotes(0);
        }

        for (int i = 0; i < number_of_players; i++) {
            players.get(i).setAbility_to_chat(false);
            players.get(i).setAbility_to_vote(false);
        }
    }

    public void check_who_win() {
        if ((count_of_mafias + count_of_sweeties) >= (count_of_citizens + count_of_madmen + count_of_commissioners + count_of_doctor)) {
            for (int i = 0; i < players.size(); i++) {
                if ((players.get(i).getRole() == 1) || (players.get(i).getRole() == 2)) {
                    players.get(i).setWinner(1);
                    win=1;
                } else {players.get(i).setWinner(2);}
            }
        } else if (count_of_mafias == 0) {
            for (int i = 0; i < players.size(); i++) {
                if (!((players.get(i).getRole() == 1) || (players.get(i).getRole() == 2))) {
                    players.get(i).setWinner(1);
                    win=1;
                } else players.get(i).setWinner(2);
            }

        }
    }


    public void Game() {
        if ((number_of_players >= 6) && (number_of_players <= 8)) {
            count_of_mafias = 1;
            count_of_doctor = 1;
            count_of_sweeties = 1;
            count_of_citizens = number_of_players - count_of_mafias - count_of_doctor - count_of_sweeties;
        } else if ((number_of_players == 9) || (number_of_players == 10)) {
            count_of_mafias = 3;
            count_of_doctor = 1;
            count_of_sweeties = 1;
            count_of_commissioners = 1;
            count_of_citizens = number_of_players - count_of_mafias - count_of_doctor - count_of_sweeties - count_of_commissioners;

        } else if ((number_of_players >= 11) && (number_of_players <= 14)) {
            count_of_mafias = 4;
            count_of_doctor = 1;
            count_of_madmen = 1;
            count_of_sweeties = 1;
            count_of_commissioners = 1;
            count_of_citizens = number_of_players - count_of_mafias - count_of_madmen - count_of_doctor - count_of_sweeties - count_of_commissioners;

        } else if ((number_of_players == 15) && (number_of_players == 16)) {
            count_of_mafias = 5;
            count_of_doctor = 1;
            count_of_madmen = 1;
            count_of_sweeties = 1;
            count_of_commissioners = 1;
            count_of_citizens = number_of_players - count_of_madmen - count_of_mafias - count_of_doctor - count_of_sweeties - count_of_commissioners;
        }


        for (int i = 0; i < number_of_players; i++) {
            Player player = new Player();
            players.add(i, player);
        }


        while (j != count_of_mafias) {
            for (int i = 0; i < number_of_players; i++) { //для каждого грока создаем роль
                Random random = new Random();
                role = random.nextInt(2);// рандомно выбирается 0 или единиица мафия или нет пока же не станет два
                if (role == 1) {//if dude is mafia
                    j++;//count mafias++
// нисходящее преобразование от Player к типу Mafia
                    Mafia mafia = (Mafia) players.get(i);//transforming into mafia
                    players.get(i).setRole(2);
                }
                if (j == count_of_mafias) {
                    j = 0;
                    break;
                }
            }
        }

        while (j != count_of_doctor) {
            for (int i = 0; i < number_of_players; i++) {
                Random random = new Random();
                role = random.nextInt(2);
                if ((role == 1) && (players.get(i).getRole() == 0)) {
                    j++;
                    Doctor doctor = (Doctor) players.get(i);
                    players.get(i).setRole(4);
                }
                if (j == count_of_doctor) {
                    j = 0;
                    break;
                }
            }
        }

        while (j != count_of_sweeties) {
            for (int i = 0; i < number_of_players; i++) {
                Random random = new Random();
                role = random.nextInt(2);
                if ((role == 1) && (players.get(i).getRole() == 0)) {
                    j++;
                    Sweety sweety = (Sweety) players.get(i);
                    players.get(i).setRole(1);
                }
                if (j == count_of_sweeties) {
                    j = 0;
                    break;
                }
            }
        }

        while (j != count_of_commissioners) {
            for (int i = 0; i < number_of_players; i++) {
                Random random = new Random();
                role = random.nextInt(2);
                if ((role == 1) && (players.get(i).getRole() == 0)) {
                    j++;
                    Commissioner commissioner = (Commissioner) players.get(i);
                    players.get(i).setRole(5);
                }
                if (j == count_of_commissioners) {
                    j = 0;
                    break;
                }
            }
        }

        while (j != count_of_madmen) {
            for (int i = 0; i < number_of_players; i++) {
                Random random = new Random();
                role = random.nextInt(2);
                if ((role == 1) && (players.get(i).getRole() == 0)) {
                    j++;
                    Madman madman = (Madman) players.get(i);
                    players.get(i).setRole(3);
                }
                if (j == count_of_madmen) {
                    j = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < number_of_players; i++) {
            if (players.get(i).getRole() == 0) {
                Citizen citizen = (Citizen) players.get(i);
                players.get(i).setRole(6);
            }
        }

        while (win==0){
            Day();
            Night();
            check_who_win();
        }

    }



}






