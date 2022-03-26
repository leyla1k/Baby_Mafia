package com.example.babymafia.first;

import java.util.Scanner;
import java.util.Vector;

public class Game {
    int role;
    int number_of_players;
    int count_of_mafias;
    int count_of_doctor;
    int count_of_sweeties;
    int count_of_citizens;
    int count_of_commissioners;
    Vector <Player> players = new Vector<Player>();

    Scanner in = new Scanner(System.in);
    number_of_players = in.nextInt();

    if((number_of_players>=6)&&(number_of_players<=8)){
        count_of_mafias=1;
        count_of_doctor= 1;
        count_of_sweeties=1;
        count_of_citizens=number_of_players-count_of_mafias-count_of_doctor-count_of_sweeties;
    }
    //else if((number_of_players==9)||(number_of_players==10)){
        count_of_mafias=3;
        count_of_doctor= 1;
        count_of_sweeties=1;
        count_of_commissioners=1;
        count_of_citizens=number_of_players-count_of_mafias-count_of_doctor-count_of_sweeties-count_of_commissioners;

    }
    if((number_of_players>=11)&&(number_of_players<=14)){
        count_of_mafias=4;
        count_of_doctor= 1;
        count_of_sweeties=1;
        count_of_commissioners=1;
        count_of_citizens=number_of_players-count_of_mafias-count_of_doctor-count_of_sweeties-count_of_commissioners;

    }
    if((number_of_players==15)&&(number_of_players==16)){
        count_of_mafias=5;
        count_of_doctor= 1;
        count_of_sweeties=1;
        count_of_commissioners=1;
        count_of_citizens=number_of_players-count_of_mafias-count_of_doctor-count_of_sweeties-count_of_commissioners;
    }
    // как я себе это представляю забивается количество игроков создается ну пусть 9 объектов класса Player
    //затем вот в таких циклах определяется роль и вызываем деструктор i Player и конструктор мафии/доктора для игрока i
    //имя можно в стринг перевести

    for (int i=0;i<number_of_players;i++) {
        Player i=new Player;
    }

    for (int i=0;i<number_of_players;i++){ //для каждого грока создаем роль
        int j=0;

        Random random = new Random();
        role = random.nextInt(2) ;// рандомно выбирается 0 или единиица мафия или нет пока же не станет два

        if (role==1){
            j++;
            Mafia j=new Mafia();
        }

        if (j==count_of_mafias) {break;}

    }



    for (int i=0;i<number_of_players;i++){ //для каждого грока создаем роль
        int j=0;

        Random random = new Random();
        role = random.nextInt(2) ;// рандомно выбирается 0 или единиица мафия или нет пока же не станет два

        if ((role==1)&&()){
            j++;
            Mafia j=new Mafia();
        }

        if (j==count_of_mafias) {break;}

    }












    Random random = new Random();
    role = random.nextInt(6) + 1;// give role

        switch (role){
        case 1:
            Mafia a = new Mafia();//only mafia has constructor in metods
            break;
        case 2:
            Doctor b = new Doctor();
            break;
        case 3:
            Commissioner c = new Commissioner();
            break;
        case 4:
            Sweety d = new Sweety();
            break;
        case 5:
            Madman e = new Madman();
            break;
        case 6:
            Citizen f=new Citizen();
            break;
        default:
    }




}
}
