
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileExporter {

    public static void exportToFile(List<Ticket> ticketBooks, String fileName) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Ticket ticketBook : ticketBooks) {
            writer.write(ticketBook.toString());
            writer.newLine();
        }

        writer.write("Total Ticket Count " + TicketingSystem.indexer);
        writer.newLine();
        writer.write("Total Fare $" + TicketingSystem.totalPrice);
        
        writer.flush();
        writer.close();
    }

}
