package bank;

public class Bank {

    private int [] konten = {10,50, 100};

    public void kontostand() {
        for (int i = 0; i < konten.length; i++) {
            System.out.printf("Saldo von Konto %s ist %s!\n", i, konten[i]);
        }
        System.out.println("-".repeat(50));
    }
    public synchronized void uberweisung(int von, int nach, int betrag) {

            try {

                int zettel = konten[von];
                zettel -= betrag;
                Thread.sleep((long) Math.random()*2000);
                konten[von] = zettel;
                konten[nach] += betrag;
                kontostand();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


    }
}
