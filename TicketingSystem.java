
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;

public class TicketingSystem {
// Field members

    static String fileName = "confirmticketexport.txt";
    private static String stations[] = new String[]{"Kiama", "Shellharbour", "Dapto", "Wollongong", "North Wollongong", "Thirroul", "Sutherland", "Hurstville", "Wolli Creek", "Central"};

    public static List<Ticket> ticketBooks;
    public static float totalPrice;

    static JFrame frame;
    public static JPanel panel = new JPanel();
    public static Integer indexer = 1;
    static List<JLabel> pasengerTypeLabels;
    static List<JLabel> ticketTypeLabels;
    static List<JLabel> fromStationLabels;
    static List<JLabel> toStationLabels;
    static List<JLabel> passengerNameLabels;
    static List<JLabel> dobLabels;

    static List<JComboBox<String>> passengerTypeComboBoxes;
    static List<JComboBox<String>> ticketTypeComboBoxes;
    static List<JComboBox<String>> fromStationTypeComboBoxes;
    static List<JComboBox<String>> toStationComboBoxes;

    static List<JTextField> passengerNameTextFields;
    static List<JTextField> dobextFields;
    static List<JButton> cancelButtons;

    public static void reset() {
        pasengerTypeLabels = new ArrayList<JLabel>();
        ticketTypeLabels = new ArrayList<JLabel>();
        fromStationLabels = new ArrayList<JLabel>();
        toStationLabels = new ArrayList<JLabel>();
        passengerNameLabels = new ArrayList<JLabel>();
        dobLabels = new ArrayList<JLabel>();

        passengerTypeComboBoxes = new ArrayList<>();
        ticketTypeComboBoxes = new ArrayList<>();
        fromStationTypeComboBoxes = new ArrayList<>();
        toStationComboBoxes = new ArrayList<>();
        passengerNameTextFields = new ArrayList<JTextField>();
        dobextFields = new ArrayList<JTextField>();
        cancelButtons = new ArrayList<>();

    }

    public static void cancel(int row) {
        pasengerTypeLabels.remove(row);
        ticketTypeLabels.remove(row);
        fromStationLabels.remove(row);
        toStationLabels.remove(row);
        passengerNameLabels.remove(row);
        dobLabels.remove(row);

        passengerTypeComboBoxes.remove(row);
        ticketTypeComboBoxes.remove(row);
        fromStationTypeComboBoxes.remove(row);
        toStationComboBoxes.remove(row);
        passengerNameTextFields.remove(row);
        dobextFields.remove(row);
        cancelButtons.remove(row);

    }

    public static void main(String[] args) {
        ticketBooks = new ArrayList<>();
        reset();
        // Construct frame
        frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setPreferredSize(new Dimension(1450, 600));
        frame.setTitle("Train Ticketing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Frame constraints
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Add Passenger  button
        JButton addButton = new JButton("Add Passenger");
        addButton.addActionListener(new ButtonListener());

        JButton previewButton = new JButton("Preview Booking Details");
        previewButton.addActionListener(new PreviewButtonListener());

        // Add button to frame
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        frame.add(addButton, frameConstraints);

        // Construct panel
//    panel.setPreferredSize(new Dimension(1590, 870));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(LineBorder.createBlackLineBorder());

        // Add panel to frame
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 1;
        frameConstraints.weighty = 20;
        frame.add(panel, frameConstraints);

        frameConstraints.gridy = 2;
        frame.add(previewButton, frameConstraints);

        // Pack frame
        frame.pack();

        // Make frame visible
        frame.setVisible(true);
    }

    static class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            // Create label and text field
            JComboBox passengerType = new javax.swing.JComboBox<>();
            JComboBox ticketType = new javax.swing.JComboBox<>();
            passengerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Adult", "Children", "Senior"}));
            passengerType.addItemListener((e) -> {
                //System.out.println("Passenger type changed"+e.paramString()+" "+e.getStateChange());
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String sel = (String) e.getItem();

                    if (sel.equals("Senior")) {
                        ticketType.removeItemAt(2);
                    } else {
                        if (ticketType.getItemCount() == 2) {
                            ticketType.addItem("Weekly");
                        }
                    }
                }
            });
            passengerTypeComboBoxes.add(passengerType);

            ticketType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"One-way", "Return", "Weekly"}));
            ticketTypeComboBoxes.add(ticketType);

            JComboBox fromStation = new javax.swing.JComboBox<>();
            fromStation.setModel(new javax.swing.DefaultComboBoxModel<>(stations));
            fromStationTypeComboBoxes.add(fromStation);

            JComboBox toStation = new javax.swing.JComboBox<>();
            toStation.setModel(new javax.swing.DefaultComboBoxModel<>(stations));
            toStationComboBoxes.add(toStation);

            JTextField passengerName = new javax.swing.JTextField("");
            passengerName.setPreferredSize(new java.awt.Dimension(115, 27));
            passengerName.setSize(65, 27);
            passengerNameTextFields.add(passengerName);

            JTextField dob = new javax.swing.JTextField("");
            dob.setPreferredSize(new java.awt.Dimension(95, 27));
            dobextFields.add(dob);
            // Labels

            pasengerTypeLabels.add(new JLabel("Passenger Type"));
            ticketTypeLabels.add(new JLabel("Ticket Type"));
            fromStationLabels.add(new JLabel("From Station"));
            toStationLabels.add(new JLabel("To Station"));
            passengerNameLabels.add(new JLabel("Name"));
            dobLabels.add(new JLabel("Date Of Birth"));

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setActionCommand("" + indexer);
            cancelButton.addActionListener((e) -> {
                System.out.println("Cancel button clicket " + e.getActionCommand());
                cancel(Integer.parseInt(e.getActionCommand()) - 1);
                indexer -= 2;
                addComponentToPanel();
            });
            cancelButtons.add(cancelButton);

            addComponentToPanel();

        }

        public static void addComponentToPanel() {
            // Clear panel
            panel.removeAll();
            // Create constraints
            GridBagConstraints cbConstraints = new GridBagConstraints();
            GridBagConstraints labelConstraints = new GridBagConstraints();

            // Add labels and text fields
            for (int i = 0; i < pasengerTypeLabels.size(); i++) {
                // Text field constraints
                //textFieldConstraints.gridx = 20;
                cbConstraints.gridy = i;

                // Label constraints
                //labelConstraints.gridx = 1;
                labelConstraints.gridy = i;

                // Add them to panel
                panel.add(pasengerTypeLabels.get(i), labelConstraints);
                panel.add(passengerTypeComboBoxes.get(i), cbConstraints);

                panel.add(ticketTypeLabels.get(i), labelConstraints);
                panel.add(ticketTypeComboBoxes.get(i), cbConstraints);

                panel.add(fromStationLabels.get(i), labelConstraints);
                panel.add(fromStationTypeComboBoxes.get(i), cbConstraints);

                panel.add(toStationLabels.get(i), labelConstraints);
                panel.add(toStationComboBoxes.get(i), cbConstraints);

                GridBagConstraints tfConstraints = new GridBagConstraints();
                tfConstraints.fill = GridBagConstraints.HORIZONTAL;
                tfConstraints.gridwidth = 3;
                tfConstraints.weightx = 5.0;

                tfConstraints.gridy = i;

                panel.add(passengerNameLabels.get(i), labelConstraints);
                panel.add(passengerNameTextFields.get(i), tfConstraints);

                panel.add(dobLabels.get(i), labelConstraints);
                panel.add(dobextFields.get(i), tfConstraints);
                panel.add(cancelButtons.get(i), tfConstraints);

            }

            // Increment indexer
            indexer++;
            frame.pack();
        }
    }

    static class PreviewButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("Preview button clicket");
            // Clear ticker books
            ticketBooks.clear();
            for (int i = 0; i < indexer - 1; i++) {
                String name = passengerNameTextFields.get(i).getText();
                String dob = dobextFields.get(i).getText();
                String pasType = passengerTypeComboBoxes.get(i).getSelectedItem().toString();
                String tktType = ticketTypeComboBoxes.get(i).getSelectedItem().toString();
                int fromStation = fromStationTypeComboBoxes.get(i).getSelectedIndex();
                int toStation = toStationComboBoxes.get(i).getSelectedIndex();

                // empty validation
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Passenger name is empty");
                    return;
                }
                if (!((!name.equals("")) && (name.matches("^[a-zA-Z ]*$")))) {
                    JOptionPane.showMessageDialog(null, "Passenger name should contains only alphabates");
                    return;
                }
                if (dob.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Date Of Birth is empty");
                    return;
                }
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                    sdf.parse(dob);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Date Of Birth is invalid");
                    return;
                }

                if (fromStation == toStation) {
                    JOptionPane.showMessageDialog(null, "From station and To Sation is same");
                    return;
                }

                // Caculate Fair
                float fare = 0;
                if (pasType.equals("Adult")) {
                    fare = FareCalculator.adultTicketPrice(fromStation, toStation, tktType);
                } else if (pasType.equals("Children")) {
                    fare = FareCalculator.childTicketPrice(fromStation, toStation, tktType);
                } else if (pasType.equals("Senior")) {
                    fare = FareCalculator.seniorTicketPrice(fromStation, toStation, tktType);
                }

                totalPrice += fare;

                Ticket ticket = new Ticket(name, dob, stations[fromStation], stations[toStation], tktType, pasType, fare);
                ticketBooks.add(ticket);
                if (i == 0) {
                    try{
                    fileName = name.split(" ")[1]+".txt";
                    }catch(Exception ex){
                         JOptionPane.showMessageDialog(null, "Passenger name missing sur name");
                    return;
                    }
                }
            }

            JPanel previewPanel = new JPanel();
            previewPanel.setLayout(new GridBagLayout());
            previewPanel.setBorder(LineBorder.createBlackLineBorder());

            TicketPreviewTableModel tptm = new TicketPreviewTableModel(ticketBooks);
            JTable previewTable = new JTable(tptm);
            previewTable.setBounds(30, 40, 300, 300);

            TableColumnModel jColumns = previewTable.getColumnModel();
            jColumns.getColumn(0).setPreferredWidth(165);
            jColumns.getColumn(1).setPreferredWidth(130);
            jColumns.getColumn(2).setPreferredWidth(160);
            jColumns.getColumn(3).setPreferredWidth(160);
            jColumns.getColumn(4).setPreferredWidth(160);
            jColumns.getColumn(5).setPreferredWidth(160);
            jColumns.getColumn(6).setPreferredWidth(110);

            GridBagConstraints gbConstraints = new GridBagConstraints();
            gbConstraints.gridy = 0;
            previewPanel.add(new JScrollPane(previewTable), gbConstraints);

            JLabel ticketCountJLabel = new JLabel("Total Ticket Count " + indexer);
            JLabel totJLabel = new JLabel("Total Fare $" + totalPrice);
            gbConstraints.gridy = 1;
            previewPanel.add(ticketCountJLabel, gbConstraints);
            gbConstraints.gridy = 2;
            previewPanel.add(totJLabel, gbConstraints);

            String[] buttons = {"Confirm", "Edit",};
            int returnValue = JOptionPane.showOptionDialog(null, previewPanel, "Ticket Booking Preview", JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[0]);

            System.out.println("Button clicked " + returnValue);
            switch (returnValue) {
                case 0:  // Confirm button
                    //  Write to text file
                    try {
                    FileExporter.exportToFile(ticketBooks, fileName);
                    JOptionPane.showMessageDialog(null, "Ticket detai exported successfully to file");
                } catch (IOException iex) {
                    JOptionPane.showMessageDialog(null, iex.getMessage());
                }
                // Reset component
                indexer = 1;
                ticketBooks.clear();
                // Reset input cmponnet
                reset();
                panel.removeAll();
                frame.pack();
                break;
                case 1:     // Edit button , Close this preview dialog
                    System.out.println("Edit Button clicked");
                    break;
                default:
                    System.out.println("Something else  clicked");
                    break;
            }

        }

    }
}
