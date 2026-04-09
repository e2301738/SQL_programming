package fi.christian;

public class Main {
    public static void main(String[] args) throws Exception {
        Database.connect();
        Database db = new Database();

        //db.insertParticipant("Timo", "Timo@koulu.fi");
        db.queryParticipants();

        db.updateParticipant(8, "Christian Updated");
        db.queryParticipants();
        db.deleteParticipant(9);
        System.out.println("removed Timo");
        db.queryParticipants();

    }
}
