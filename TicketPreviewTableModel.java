
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TicketPreviewTableModel extends AbstractTableModel {

    String[] columnNames = {"Passenger Name", "Date of Birth", "Passenger Type", "Ticket Type", "From Station", "To Station", "Fair"};

    List<Ticket> ticketBooks;

    public TicketPreviewTableModel(List<Ticket> ticketBooks) {
        this.ticketBooks = ticketBooks;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return ticketBooks.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Ticket l = ticketBooks.get(row);
        switch (column) {
            case 0:
                return l.getName();
            case 1:
                return l.getDob();
            case 2:
                return l.getPassengerType();
            case 3:
                return l.getTicketType();
            case 4:
                return l.getFromStation();
            case 5:
                return l.getToStation();
            case 6:
                return l.getFair();
            default:
                return null;
        }
    }

}
