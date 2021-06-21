# TrainTicketingSystem
# SCIT
School of Computing and Information Technology
# Autumn 2021
# CSIT121/821 ⎯ Programming Fundamentals
Final Project (40 marks)
  Due Time and Date:
 • Individual Project
• Due by Sunday 20th June 2021 10 pm
General Requirements:
• You should create your programs with good programming style and form using proper blank spaces, indentation and braces to make your code easy to read and understand;
• You should create identifiers with sensible names;
• You should make comments to describe your code segments where they are necessary for readers to
understand what your code intends to achieve.
• Logical structures and statements are properly used for specific purposes.
• Read the assignment specification carefully, and make sure that you follow whatever directed in this
assignment. You must put the following information in the header of your program:
/*------------------------------------------------------ My name:
My student number:
My course code: CSIT121
My email address:
Assignment number: Final Project -------------------------------------------------------*/
Objectives
This project is the replacement of the final exam. You will be asked to design and complete a java program with all the skills and concepts learnt from CSIT121.

Background
South Coast Line Ticketing System
  You are required to design and implement a ticketing system for the South Coast Line (SCL). To simply the system, you only need to consider 10 stations in SCL. The index of each station is as follows:
Index 1 2 3 4 5 6 7 8 9 10 Station Kiama Shellharbour Dapto Wollongong North Thirroul Sutherland Hurstville Wolli Central
Wollongong Creek
The following table is used to calculate the train fares (round to 5c) between any two stations with Index i and Index j for three types of tickets (One-way, Return, Weekly) and three types of passengers (Adult, Children, Senior).
                                     Ticket Type
Return Weekly
Adult Children Adult price * 0.5
one-way price * 1.8 return price * 6
Senior Adult price * 0.1
N/A
   One-way
   𝑝𝑟𝑖𝑐𝑒 (𝑖, 𝑗) =
{ |𝑖 − 𝑗| ∗ 1.2, 𝑖𝑓 𝑖 ≠ 9 𝑎𝑛𝑑 𝑗 ≠ 9
|𝑖 − 𝑗| ∗ 1.2 + 15, 𝑖𝑓 𝑖 = 9 𝑜𝑟 𝑗 = 9
            For example, for the stations between Kiama and Central, the one-way adult ticket price is |10 – 1|*1.2 = $10.8. The return adult ticket price is $10.8 * 1.8 = $19.45. The weekly adult ticket price is $19.45 * 6 = $116.7. The one-way children ticket price is $10.8 * 0.5 = $5.4, the return children price is $19.45 * 0.5 = $9.75, and the weekly children ticket price is $116.7 * 0.5 = $58.35. The one-way senior ticket price is $10.8 * 0.1 = $1.05, the return senior ticket price is $19.45 * 0.1 = $1.95, and the weekly ticket for Senior is not available. Furthermore, if passengers trave to/from the airport (Wolli Creek Station), an extra $15 will be charged for the one-way ticket.
Program Design and Implementation Requirements
The requirements for the program design and implementation are as follows:
The system shall be design by using the object-oriented programming concepts introduced in CSIT121 and implement by using the Java programming language.
The OOP principles and techniques such as inheritance, polymorphism, abstract class/method, interface, and exception handling MUST be used in this project.
The system MUST have a Graphic User Interface (GUI). The GUI must be implemented by Java Swing. With the GUI, the user can purchase one or multiple ticket/s (with different ticket types and passengers) in one transaction for the same journey.
GUI MUST allow the user to choose the stations (from and to) for each transaction.
GUI MUST allow the user to choose the ticket type and the passenger type for each ticket.
The personal information (Full name and DOB) for each passenger must be provided and input via the GUI by the user.
The GUI MUST able to handle empty and/or invalid personal information inputs by the user.
The GUI MUST able to display the details for each ticket (ticket type, passenger type and personal information, and ticket price) and the whole transaction detail (from and to stations, total ticket numbers, and total ticket price) as the order summary on the GUI.

 The user shall be allowed to make the modification of the entire transaction or any particular ticket or cancel any ticket or the whole transaction before finally confirming the order. Any modification will immediately update the displayed information of the order summary on the GUI.
After the user confirms the purchase, the GUI shall export the order summary as a text-file named by the first passenger’s surname. The txt file must be created in the same folder as the program.
The GUI MUST be reset after the user either confirms or cancels the order.
The program MUST be terminated once the GUI is closed.
The GUI shall contain the following components, i.e., JLabel, JButton, JCheckBox (or JRadioButton), JList (or JCombBox), JTextField, JTextArea, JOptionalPane, JPanel, and JFrame.
This project contains several tasks:
1. UML class diagram: You shall draw (with a tool) a UML class diagram to illustrate the class design of your system. In the UML class diagram, you shall clearly specify the class names, field variable names and types, method signatures, associations and multiplicities between classes. The GUI class/es shall also be included in the class diagram. (10 marks)
2. Graphic User Interface (GUI): You shall design a GUI with Java Swing. The GUI design shall be compact and informative. The GUI shall able to handle all tasks specified in the requirements. (5 marks)
3. Coding: You shall implement the classes and GUI based on the above designs and make sure all the requirements are met. (20 marks)
4. Testing: You shall compile and test your system for all requirements to make sure the system is workable and tolerant to possible exceptions. You must test your program with two cases. Case one shall demonstrate the ticketing procedures and outputs for a journey not including the Wolli Creek. The transaction shall contain at least three types of passengers with different types and numbers of tickets. For example, you can assume the user purchase 1 adult ticket (return), 2 children tickets (weekly) and 1 senior ticket (one-way) in one transaction. Case two shall include the Wolli Creek in the journey and shall also consider different combinations of ticket types and numbrers and passenger types. (5 marks)
Submission:
• Please submit your solution to Moodle (Final Project). Email submission is NOT accepted.
• Please submit an individual PDF document (TicketingSystem.pdf), the primary Java program (TicketingSystem.java and other java files), and two order summaries for the two cases (two txt files)
created by your system.
• The PDF document shall contain
o 1) the UML class diagram with all details;
o 2) the GUI design and explanations (You must display a snapshot of your GUI and explain the
structure of your GUI, i.e., the layout managers for all containers and the Swing components used
on each container);
o 3)thesnapshotsclearlyshowthecompilation(viausing‘javac’)andtheexecution(viausing‘java’)
of your program through the command-line with two different testing cases. The testing cases must cover all requirements and match with the submitted txt files. The exception handling must be tested as well.
• Please DO NOT include the java program and txt file in the PDF document.
• Turnitin will be used for the plagiarism checking.
      Tasks (40 marks):
