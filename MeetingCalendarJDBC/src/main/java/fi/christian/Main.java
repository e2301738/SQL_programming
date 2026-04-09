package fi.christian;

public class Main {
    public static void main(String[] args) throws Exception {
        Database.connect();
        Database db = new Database();

        db.insertParticipant("Christian", "christian@koulu.fi");
        db.queryParticipants();

        db.updateParticipant(1, "Christian Pro");
        db.queryParticipants();

        //db.deleteParticipant();
    }
}
