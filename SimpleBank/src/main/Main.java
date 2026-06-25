package main;

import angestellte.Angesteller;
import bank.Bank;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Angesteller a1 = new Angesteller(bank, 0,1,20);
        Angesteller a2 = new Angesteller(bank ,1,2,20);
        Angesteller a3 = new Angesteller(bank ,2,0,20);

        System.out.println("Kontostand vorher: ");
        bank.kontostand();

        a1.start();
        a2.start();
        a3.start();
    }
}
