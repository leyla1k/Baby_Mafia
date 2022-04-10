package com.example.babymafia.first;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Game {
    int role=0;
    int number_of_players=0;
    int count_of_mafias=0;
    int count_of_doctor=0;
    int count_of_sweeties=0;
    int count_of_citizens=0;
    int count_of_madmen=0;
    int count_of_commissioners=0;
    int time_of_day=1;//1 means day
    int j=0;
    Vector <Player> players = new Vector<Player>();

    public void Number_of_players() {
        Scanner in = new Scanner(System.in);
        number_of_players = in.nextInt();
    }
    public void Night(){
        time_of_day==2;
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
        // как я себе это представляю забивается количество игроков создается ну пусть 9 объектов класса Player
        //затем вот в таких циклах определяется роль и вызываем деструктор i Player и конструктор мафии/доктора для игрока i
        //имя можно в стринг перевести


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
                    players.get(i).setRole(1);
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
                    players.get(i).setRole(2);
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
                    players.get(i).setRole(3);
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
                    players.get(i).setRole(4);
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
                    players.get(i).setRole(5);
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







}
}
