import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {

    public static void main(String[] args) throws IOException, GeneralSecurityException {

        GoogleDriveDao gdd = new GoogleDriveDao();

        // read csv file

        String folderId = gdd.searchFile("EconoStats").stream().findFirst().orElse(null);

        if (folderId == null) {
            System.out.println("EconoStats folder did not exist, creating folder...");
            gdd.createFolder("EconoStats"); //save ID!!
        }
        System.out.println("EconoStats folder already exists, continuing execution...");
        String fileId = gdd.searchFile("transaction.json").stream().findFirst().orElse(null);
        // find transactions.json (inside EconoStats folder)
        if (fileId == null) {
            // *** convert csv to List<AT> to json ***
            // *** do all the spreadsheet magic! ***
            // *** NOTE: exclude from odf: all objects that do not exist in premade configuration list of names ***
            // save transactions.json to Drive
            // save recurringTransactions.odf to Drive
        } else {
            // *** convert csv to List<AT> to json ***
            // *** read transaction.json ***
            // *** do some "merge magic" with the two jsons or convert them both to lists and compare/merge... ***
            // *** NOTE: exclude from odf: all objects that do not exist in premade configuration list of names ***
            // "overwrite" transactions.json on Drive
            // "overwrite" recurringTransactions.odf on Drive
        }
    }
}
