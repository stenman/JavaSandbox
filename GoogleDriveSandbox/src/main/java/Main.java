import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String FOLDER_NAME = "EconoStats";
    private static final String JSON_NAME = "transactions.json";

    static GoogleDriveDao gdd = new GoogleDriveDao();

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        theCode();
    }

    private static void theCode() throws IOException, GeneralSecurityException {
        GoogleDriveDao gdd = new GoogleDriveDao();

        // *** read csv file ***

        String folderId = searchFile(FOLDER_NAME, gdd.APPLICATION_VND_GOOGLE_APPS_FOLDER);

        if (folderId == null) {
            //TODO: Log this
            System.out.println("Folder " + FOLDER_NAME + " did not exist, creating folder...");
            folderId = gdd.createFolder(FOLDER_NAME); //save ID!!
        }
        String fileId = searchFile(JSON_NAME, gdd.APPLICATION_VND_GOOGLE_APPS_FILE);
        if (fileId == null) {
            // *** convert csv to List<AT> to json ***
            // *** do all the spreadsheet magic! ***
            // *** NOTE: exclude from odf: all objects that do not exist in premade configuration list of names ***
            gdd.createFile(Arrays.asList(folderId));
            // save recurringTransactions.odf to Drive
        } else {
            // download file from Drive
            System.out.println(gdd.getFile(fileId));

            // *** convert csv to List<AT> to json ***
            // *** read transaction.json ***
            // *** do some "merge magic" with the two jsons or convert them both to lists and compare/merge... ***
            // *** NOTE: exclude from odf: all objects that do not exist in premade configuration list of names ***
            gdd.updateFile(fileId);
            // "overwrite" recurringTransactions.odf on Drive
        }

    }

    //TODO: make optional
    private static String searchFile(String name, String mimeType) throws IOException, GeneralSecurityException {
        List<String> items = gdd.searchForFile(name, mimeType);

        if (items.isEmpty()) {
            System.out.println("No match!");
            return null;
        } else if (items.size() > 1) {
            //TODO: Log this properly
            //TODO: Throw a sensible exception here!
            System.out.println("Inconsistency in file/folder structure. More than one item found! Please check folder/file structure!");
            throw new IOException();
        }
        return items.get(0);
    }

}
