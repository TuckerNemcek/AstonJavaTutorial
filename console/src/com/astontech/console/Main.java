package com.astontech.console;

import com.astontech.bo.*;
import com.astontech.bo.interfaces.Home;
import com.astontech.bo.interfaces.IFeelings;
import com.astontech.bo.interfaces.ILocation;
import com.astontech.bo.interfaces.Site;
import com.astontech.dao.PersonDAO;
import com.astontech.dao.mysql.PersonDAOImpl;
import common.helpers.MathHelper;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;
import java.util.Date;


public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
    DatabaseConnectionLab();

    }
    private static Connection DatabaseConnectionLab(){
        String dbHost = "localhost";
        String dbName = "connlab";
        String dbUser = "tucker";
        String dbPass = "Dingodog,21!";


        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex){
            logger.error("SSMS Driver not found!" + ex);
        }
        logger.info("SSMS Driver Registered");
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/connlab?user=tucker&password=qwe123$!&ssl=false");
        } catch(SQLException ex) {
            logger.error("Connection failed!" + ex);
            return null;
        }
        if(connection != null){
            logger.info("Successfully connected to SSMS database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }


    private static void LessonDAO(){
        //region CREATE MENU
        PersonDAO personDAO = new PersonDAOImpl();
        List<Person> personList = personDAO.getPersonList();

        System.out.println("==============================");

        for(Person person : personList){
            System.out.println(person.getPersonId() + ") " + person.getLastName() + ", " + person.getFirstName());
        }
        System.out.println("==============================");

        //endregion

        //region PROMPT USER
        Scanner reader = new Scanner(System.in);
        System.out.println("Please Select a Person from list: ");
        String personId = reader.nextLine();
        //endregion

        //region GET PERSON DETAILS
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));

        System.out.println("-----PERSON DETAILS -----");
        System.out.println("Full Name: " + personDetail.getFirstName() + " " + personDetail.getLastName());
        System.out.println("DOB: " + personDetail.getBirthDate());
        System.out.println("SSN: " + personDetail.getSSN());

        //endregion
    };
    private static void LessonExecQuery(){
        Connection conn = LessonDBConnection();
        try {
            Statement statement = conn.createStatement();
            String sql = "select PersonId, FirstName, LastName from Person";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                logger.info(personId + ": "+ firstName + " " + lastName);
            }
            conn.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }
    private static Connection LessonDBConnection(){
        String dbHost = "localhost";
        String dbName = "db2";
        String dbUser = "consoleUser";
        String dbPass = "qwe123$!";
        String useSSL = "false";
        String procBod = "true";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            logger.error("MySQL Driver not found!" + ex);
            return null;
        }

        logger.info("MySQL Driver Registered");
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://" +dbHost+":3306/" +dbName +"?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPass);
        } catch(SQLException ex) {
            logger.error("Connection failed!" + ex);
            return null;
        }
        if(connection != null){
            logger.info("Successfully connected to MySQL database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }
    private static void LessonLogging(){
        //notes:    levels of logging
        logger.debug("This is a DEBUG log message");
        logger.info("This is a INFO log message");
        //notes:    production levels
        logger.warn("This is a WARN log message");
        logger.error("This is a ERROR log message");
        logger.fatal("This is a FATAL log message");

        //notes:    log an exception
        try{
            int i = 10 / 0;
        } catch (ArithmeticException ex){
            logger.error("An exception occurred: " + ex);
        }
    }
    private static void LessonInterfacesTest() {
        Site MN010 = new Site();
        MN010.setSiteName("MN010");
        MN010.setCoffeeMachines(2);
        MN010.setConferenceRooms(1);
        MN010.setCubicles(8);
        MN010.setOffices(6);
        MN010.setTrainingDesks(36);

        Home BipsHouse = new Home();
        BipsHouse.setAddress("1 Main St.");
        BipsHouse.setOwner(new Employee("Bipin", "Butala"));

        LessonInterfaces(MN010);
        LessonInterfaces(BipsHouse);
    }
    private static void LessonInterfaces(ILocation Ilocation){
        System.out.println("=======================");
        System.out.println("Location Name: " + Ilocation.getLocationName());
        System.out.println("Can Have Meetings: " + Ilocation.canHaveMeetings());
        System.out.println("Number of Workspaces: " + Ilocation.numberOfWorkspaces());
        System.out.println("Has Coffee! : " + Ilocation.hasCoffee());
    };
    private static void LessonValueVsRef(){
        System.out.println(MathHelper.PI);
    }
    private static void OOPPrincipalsLab04(){
        // region 1
/*        Instance is one example of many. I am an instance of a person. You would not want to make an instance of something
          you are going to be making a lot of. Static is something you are going to make a lot of. It is less cumbersome to
          reference and does not require you to instantiate it for it to work. As you can see in the last lab, Vehicle is a
          static class because it makes vehicles. battleBuick is an instance because there is only one battleBuick and it was
          instantiated first.

 */
        // endregion

        //region 2
        /*
        A value is one of the primitive data types and is real data. A reference is a reference to an Object, or a collection of real data. A reference is simply a pointer.

         */
         int firstNum = 5;
         int myNum = firstNum;
        System.out.println(myNum);
         firstNum = 100;
        System.out.println(myNum);

        String firstString = "Hey";
        String myString = "Heya";
        System.out.println(firstString);
        firstString = myString;
        System.out.println(firstString);

        //endregion

        //region 3
        Hashtable<Integer, String> hashTableExample = new Hashtable<>();
            hashTableExample.put(1,"and the Prisoner of ISIS");
            hashTableExample.put(3,"II: Electric Boogaloo");
            hashTableExample.put(4,"Revengence");
            hashTableExample.put(5,"VS Rick and Morty");
            hashTableExample.put(6,"Reloaded");
            hashTableExample.put(7,"and the Eternal Brexit");

        System.out.println("Unfortunately the new Harry Potter reboot failed spectacularly, probably because it was titled");
        System.out.println();

        for(Integer key : hashTableExample.keySet()){
            System.out.println("Harry Potter "+ hashTableExample.get(key));
        }

        System.out.println();

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "I work too hard, I care too much, and sometimes I can be too invested in my job.");
        hashMap.put(2, "I am often a target of sexual harassment by female coworkers owning to my Magnum Dong");
        hashMap.put(3, "I try to insert something about my large collection of Anime Body pillows into every conversation");
        hashMap.put(4, "What the fuck did you just fucking say about me, you little bitch? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You're fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little \"clever\" comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn't, you didn't, and now you're paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You're fucking dead, kiddo.");

        System.out.println("By far the best response to the interview question \"What is your greatest weakness\" is ");
        System.out.println();

        for(Integer key : hashMap.keySet()){
            System.out.println(hashMap.get(key));
        }

        System.out.println();

        HashSet<String> hashSet = new HashSet<>();
            hashSet.add("funny thing 1");
            hashSet.add("funny thing 2");
            hashSet.add("funny thing 3");

        System.out.println("Funny machine broke");
        System.out.println();

        for(String s : hashSet){
            System.out.println(s);

        }


        //endregion
    }
    private static void Lab05Part5(IFeelings Ifeelings){
        if (Ifeelings.ownerShip()){
            System.out.println("I have owned this");
        } else System.out.println("I have not owned this");
        System.out.println("I feel like: " +Ifeelings.mood());
        System.out.println("I feel this a: " +Ifeelings.passion() + " out of 10");
    }
    private static void LessonCollectionsLABandLab05(){
        List<Vehicle> vehicleList = new ArrayList<>();

        VehicleMake jeep = new VehicleMake();
        jeep.setVehicleMakeName("Jeep");
        jeep.setVehicleMakeId(1);
        jeep.setCreateDate("2011");

        VehicleMake tesla = new VehicleMake(2,"Tesla", "01-01-2010");
        VehicleMake bmw = new VehicleMake(3, "BMW", "01-01-2019");
        VehicleMake buick = new VehicleMake(4, "Buick", "01-01-2017");

        VehicleModel liberty = new VehicleModel();
        liberty.setVehicleModelId(1);
        liberty.setVehicleModelName("Liberty");
        liberty.setVehicleMake(jeep);

        VehicleModel s = new VehicleModel(2, "S", tesla);
        VehicleModel x6 = new VehicleModel(3, "X6",bmw );
        VehicleModel regal = new VehicleModel(4, "Regal", buick);

        Vehicle myJeep = new Vehicle();
        myJeep.setVehicleId(1);
        myJeep.setYear("2011");
        myJeep.setLicensePlate("938-AAE");
        myJeep.setVin("1234567890HE12345");
        myJeep.setColor("Black");
        myJeep.setIsPurchase('y');
        myJeep.setPurchasePrice(10000);
        myJeep.setPurchaseDate("10-01-2019");
        myJeep.setVehicleModel(liberty);

        Vehicle theTesla = new Vehicle(2, "2015", "542-BBQ", "0987654321QW12345", "Silver", 'n', 50000, "Nov 29th, 2025", s);
        Vehicle theBMW = new Vehicle(3, "2019","I<3 NW Yk", "102878203982030EV9", "Gold", 'n', 100000, "Nov 29th 2010", x6);
        Vehicle battleBuick = new Vehicle(4, "1995", "243-BPN", "203287p739803RT9", "Champaigne", 'y', 0, "Oct 3rd 2016", regal );
        //git branch test
        vehicleList.add(battleBuick);
        vehicleList.add(myJeep);
        vehicleList.add(theTesla);
        vehicleList.add(theBMW);

        System.out.println(theBMW.mood());

        IFeelings bmwFeelings = theBMW;
        System.out.println(bmwFeelings.passion());

        Lab05Part5(battleBuick);

        for(Vehicle v : vehicleList){
            System.out.println(" " +v.getVehicleId() +" The " + v.getVehicleModel().getVehicleMake().getVehicleMakeName() +" " +v.getVehicleModel().getVehicleModelName() +" " + v.getColor() +" goes "+v.getVehicleModel().getVehicleMake().CarNoise() );
        }

        Backwards("Heya");

        // So I looked in the docs, and it turns out that String is part of the CharSequence interface, so I should be fine just reversing a string. If you want me to do it another way please let me know.
    }
    public static String Backwards(String str) {
        int i = 0;
        String collec = "";
        Hashtable<Integer, Character>reverser = new Hashtable<>();
        while (str.length() != 0){
            reverser.put(i++,str.toCharArray()[0]);
            str = str.substring(1);
        }
        for(Integer key : reverser.keySet()){
            collec += reverser.get(key);
        }
        return collec;
    }
    private static void LessonComplexProperties(){
        EntityType emailWorkType = new EntityType();
        emailWorkType.setEntityTypeId(1);

        Email myEmail = new Email("tucker.nemcek@aston.com");
        myEmail.setEmailType(emailWorkType);

        System.out.println(myEmail.getEmailAddress() + " Type: " + myEmail.getEmailType());

        Employee myEmployee = new Employee();
        myEmployee.getEmails().add(new Email("test@test.com"));
        myEmployee.getEmails().add(new Email("tuck@test.com"));
        myEmployee.getEmails().add(new Email("dan@test.com"));

        for(Email email : myEmployee.getEmails()){
            System.out.println(email.getEmailAddress());
        }
    }
    private static void OOPPrincipalsLab02(){
        Phone tuckPhone = new Phone();
        tuckPhone.setPhoneNumber(6513015752L);
        String phoneLength = tuckPhone.PhoneNumLength();
        System.out.println(tuckPhone.getPhoneNumber());
        System.out.println(phoneLength);

        VehicleMake myJeep = new VehicleMake();
        myJeep.setVehicleMakeName("BMW");
        System.out.println(myJeep.getVehicleMakeName());
        System.out.println(myJeep.CarNoise());

        Address myAddress = new Address();
        myAddress.setAddressNumber(5589);
        String adLength = myAddress.AddressChecker();
        System.out.println(myAddress.getAddressNumber());
        System.out.println(adLength);

        ProjectStatus myProject = new ProjectStatus();
        myProject.setPercentComplete(50);
        String perComplete = myProject.ProgressYeller();
        System.out.println(myProject.getPercentComplete());
        System.out.println(perComplete);

        Email myEmail = new Email();
        myEmail.setEmailAddress("tucker.nemcek@gmail.com");
        String checkMyEmail = myEmail.EmailChecker();
        System.out.println(myEmail.getEmailAddress());
        System.out.println(checkMyEmail);

        BaseBo base = new BaseBo();
        base.setId(1);
        System.out.println(base.getId());

        Client myClient = new Client();
        myClient.setClientName("Paul");
        System.out.println(myClient.getClientName());

        ClientContact myClientContact = new ClientContact();
        myClientContact.setClientContactId(1);
        System.out.println(myClientContact.getClientContactId());

        EmployeeProject myEmployeeProject = new EmployeeProject();
        myEmployeeProject.setNotes("test employee project");
        System.out.println(myEmployeeProject.getNotes());

        Entity myEntity = new Entity();
        myEntity.setEntityId(1);
        System.out.println(myEntity.getEntityId());

        EntityType myEntityType = new EntityType();
        myEntityType.setEntityTypeId(1);
        System.out.println(myEntityType.getEntityTypeId());

        LoyaltyAccount myLoyaltyAccount = new LoyaltyAccount();
        myLoyaltyAccount.setLoyaltyAccountId(1);
        System.out.println(myLoyaltyAccount.getLoyaltyAccountId());

        LoyaltyCompany myLoyaltyCompany = new LoyaltyCompany();
        myLoyaltyCompany.setCompanyName("McDonals");
        System.out.println(myLoyaltyCompany.getCompanyName());

        Person me = new Person();
        me.setFirstName("Tucker");
        System.out.println(me.getFirstName());

        Project myNewProject = new Project();
        myNewProject.setProjectName("Lab02");
        System.out.println(myNewProject.getProjectName());

        Review myReview = new Review();
        myReview.setReviewId(1);
        System.out.println(myReview);

        ReviewData myReviewData = new ReviewData();
        myReviewData.setReviewDataId(1);
        System.out.println(myReviewData.getReviewDataId());

        Training myTraining = new Training();
        myTraining.setTrainingId(1);
        System.out.println(myTraining.getTrainingId());

        TrainingData myTrainingData = new TrainingData();
        myTrainingData.setTrainingDataId(1);
        System.out.println(myTrainingData.getTrainingDataId());

        Vehicle myVehicle = new Vehicle();
        myVehicle.setVehicleId(1);
        System.out.println(myVehicle.getVehicleId());

        VehicleModel myVehicleModel = new VehicleModel();
        myVehicleModel.setVehicleModelId(1);
        System.out.println(myVehicleModel.getVehicleModelId());

        VehicleStatus myVehicleStatus = new VehicleStatus();
        myVehicleStatus.setNotes("Test Vehicle status");
        System.out.println(myVehicleStatus.getNotes());
    }
    private static void LessonMethods(){
        Employee constructorEmployee = new Employee("Tucker", "Nemcek");
        System.out.println(constructorEmployee.getFirstName() + " " + constructorEmployee.getLastName());

        Employee const2Employee = new Employee("Zack");
        System.out.println(const2Employee.getFirstName());

        Employee employeeJames = new Employee("Williams");
        System.out.println(employeeJames.GetFullName());
    }
    private static void LessonInheritance(){
        Employee employeeTuck = new Employee();
        employeeTuck.setFirstName("Tucker(e)");
        employeeTuck.setLastName("Nemcek(e)");
        employeeTuck.setId(3);

        System.out.println(employeeTuck.getFirstName() + " " + employeeTuck.getLastName());

        Person personTuck = new Person();
        personTuck.setFirstName("Tucker");
        personTuck.setLastName("Nemcek");
        personTuck.setId(2);
    }
    private static void LessonClassObjects(){
        Person myFirstPerson = new Person();
        myFirstPerson.setFirstName("Tucker");
        myFirstPerson.setLastName("Nemcek");
        myFirstPerson.setTitle("Mr.");

        System.out.print(myFirstPerson.getTitle());
        System.out.print(" ");
        System.out.print(myFirstPerson.getFirstName());
        System.out.print(" ");
        System.out.println((myFirstPerson.getLastName()));

        Person mySecondPerson = new Person();
        mySecondPerson.setFirstName("Bipin");
        mySecondPerson.setLastName("Butala");
        mySecondPerson.setTitle("Mr.");

        System.out.print(mySecondPerson.getTitle());
        System.out.print(" ");
        System.out.print(mySecondPerson.getFirstName());
        System.out.print(" ");
        System.out.print((mySecondPerson.getLastName()));

        //notes:    setting value for super (inherited class)
        myFirstPerson.setId(3);
        System.out.println(myFirstPerson.getId());
    }
    private static void LessonCalculatorLAB() throws Exception{
        double input;
        double input2;
        double total;
        String operator;
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a number 0-9");
             input = sc.nextInt();
            if (input > 0 && input <= 9){
                System.out.println("YOU DID IT!!!! Your number is " +input);
            }
            else {
                System.out.println("INVALID");
                LessonCalculatorLAB();
            }

            System.out.println("Please enter a number 0-9");
             input2 = sc.nextInt();
            if (input2 > 0 && input2 <= 9){
                System.out.println("YOU DID IT AGAIN!!!! Your number is "+input2);
            }
            else {
                System.out.println("INVALID");
                LessonCalculatorLAB();
            }

            System.out.println("Please enter one of the following: +, -, /, *");
            operator = sc.next();

        switch(operator){
            case "+":
                total = input + input2;
                System.out.println("Your total is " + total);
                break;
            case "-":
                total = input - input2;
                System.out.println("Your total is " + total);
                break;
            case "*":
                total = input * input2;
                System.out.println("Your total is " + total);
                break;
            case "/":
                total = input / input2;
                System.out.println("Your total is " + total);
                break;

            default:
                System.out.println("Hey, That's not an operator!");
                LessonCalculatorLAB();
        }

           }
        catch (Exception ex)
        {
            throw new Exception("How did you mess this up?!", ex);
        }
    }
    private static void LessonFizzBuzzLAB(){
        for (int i = 0; i <= 100; i++){
            if (i % 15 == 0){
                System.out.println(i + " FizzBuzz");
            }
            else if (i % 5 == 0){
                System.out.println(i + " Buzz");
            }
            else if (i % 3 == 0){
                System.out.println(i + " Fizz");
            }
            else {
                System.out.println(i);
            }
        }
    }
    private static void LessonExceptions() throws Exception{

        String firstName = null;
        try {
            int x = Integer.parseInt(firstName);

            System.out.println("Integer value: ");
            System.out.println(x);
        }
        catch(Exception ex)
        {
            throw new Exception("A custom exception from LessonExceptions method", ex);
        }
    }
    private static void LessonFlowControl() {
        String name = "Tucker";

        switch (name) {
            case "Tucker":
                System.out.println("Hey Tuck");
                break;

            case "dan":
            case "danny":
            case "daniel":
                System.out.println("first name is dan, danny, or daniel");
                break;

            default:
                System.out.println("some other name");
                break;
        }
    }
    private static void LessonOperators(){

    }
    private static void FundamentalsLab(){
/*
        Scanner sc = new Scanner(System.in);
        double addTo = 1.75;
        System.out.println("What is your favorite number from 1-10?");
        String input = sc.nextLine();
        double total = addTo + Double.parseDouble(input);
        System.out.println("did you know that " + input + " + 1.75 = " +total);
*/

        byte  minByte = -128;
        byte  maxByte =  127;
        short minShort = -32768;
        short maxShort =  32760;
        int   maxInt = -2147483648;
        int   minInt =  2147483647;
        long  minLong = -9223372036854775808L;
        long  maxLong =  9223372036854775807L;
        float avgFloat = 5.123457f;
        double avgDouble = 2.123456789101112d;
        boolean fBool = false;
        boolean tBool = true;
        char exChar = 'a';

        String stringRant = "Strings are not primitive for a variety of reasons. First of all, you reference them with a capital letter. A string can be null. Strings are not declared with a lower case letter." +
                "\n" + "Strings also do not depend on the size of the data type, as this run on string exemplifies. Strings are actually an array of chars";

        // Fun fact you gotta put an L after it if it is bigger than an int!
        // Fun fact you gotta put an f after it if it is a float!
        // Fun fact you gotta put an d after it if it is a double!
        // Fun fact you gotta put single quotes around a char!



        System.out.println("Fun fact: the min output for a byte is " + minByte);
        System.out.println("Fun fact: the max output for a byte is " + maxByte);
        System.out.println("Fun fact: the min output for a short is " + minShort);
        System.out.println("Fun fact: the max output for a short is " + maxShort);
        System.out.println("Fun fact: the min output for an int is " + minInt);
        System.out.println("Fun fact: the max output for an int is " + maxInt);
        System.out.println("Fun fact: the min output for a long is " + minLong);
        System.out.println("Fun fact: the max output for a byte is " + maxLong);
        System.out.println("Fun fact: the float type can hold 6 positive or negative decimal points, like this: " + avgFloat);
        System.out.println("Fun fact: the double type can hold 15 positive or negative decimal points, like this: " + avgDouble);
        System.out.println("Fun fact: booleans can be positive, like this: " + tBool);
        System.out.println("Fun fact: or negative like this " + fBool);
        System.out.println("Fun fact: chars are one character in single quotes, like this: " + exChar);

        System.out.println(stringRant);


        System.out.println("also, behold: a string made from an array of chars! It is cooler in the code than the output");

        char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
        String helloString = new String(helloArray);
        System.out.println( helloString );
        System.out.println();
        System.out.println("Welcome to the conspiricy generator, please select a conspiracy");

        List <String> conspiracyGenerator = new ArrayList<>();
        conspiracyGenerator.add("Jet fuel can't melt steel beams");
        conspiracyGenerator.add("The chemtrails are turning the frogs gay");
        conspiracyGenerator.add("The earth is hollow and filled with bees");
        conspiracyGenerator.add("The government paid Stanley Kubrick to fake the moon landing. However, he was such a perfectionist that he actually landed on the moon to make the shot perfect");
        conspiracyGenerator.add("Vaccines cause gingivitis");

        for (String c : conspiracyGenerator){
            System.out.println(c);
        }

        System.out.println("You cannot use primitives as they are in Array Lists. However, you can use a wrapper class used to treat them like objects and then use them. such as changing boolean to Boolean");
        System.out.println("\n");

        System.out.println("You have asked to see the lottery resuls, here they are" + "\n");

        String gameName = "Powerball";

        List <Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(02);
        winningNumbers.add(78);
        winningNumbers.add(24);
        winningNumbers.add(11);
        winningNumbers.add(89);

        int jackpot = 122000000;

        int date = 2013-12-14;

        System.out.println("Game Name is " + gameName);
        System.out.println("Winning numbers are ");
        for (int i : winningNumbers){
            System.out.println(i);
        }

        System.out.println("The Jackpot was " + jackpot);
        System.out.println("The date they were pulled is " + date);
        System.out.println("Thanks for playing!");



    }
    private static void LessonLists(){
        List<String> myStringCollection = new ArrayList<String>();

//        myStringCollection.add("1st String");
//        myStringCollection.add("2nd String");
//        myStringCollection.add("3rd String");
//        myStringCollection.add("4th String");
//        myStringCollection.add("5th String");
//
//        for(String singleString : myStringCollection) {
//            System.out.println(singleString);
//        }
//
//        List<Integer> myIntCollection = new ArrayList<Integer>();
//
//        myIntCollection.add(10);
//        myIntCollection.add(20);
//        myIntCollection.add(30);
//        myIntCollection.add(40);
//        myIntCollection.add(50);
//
//        System.out.println(myIntCollection);
//
//        for (int i : myIntCollection){
//            System.out.println(i);
//        }

        String[] myStringArray = new String[5];

        myStringArray[0] = "1st";
        myStringArray[1] = "2nd";
        myStringArray[2] = "3rd";
        myStringArray[3] = "4th";
        myStringArray[4] = "5th";

        for (String c : myStringArray){
            System.out.println(c);
        }

    }
    private static void LessonStrings(){


//        if(firstString == null || firstString.isEmpty()) {
//            System.out.println("String is empty");
//        }
//            else {
//                System.out.println(("String has a value"));
//            }

            StringBuilder myStringBuilder = new StringBuilder();

            for (int x = 0; x <= 100; x++){
                myStringBuilder.append("your new x is ").append(Integer.toString(x)).append("\n");
            }
            System.out.println(myStringBuilder);

        String largeString = "this is a loner string than before";
        String partOfAString = largeString.substring(28,34);
        System.out.println(partOfAString);
        }
    private static void LessonDataTypes(){
        boolean myBool = false;
        int myInt = 4;
        String myString = "some words";
        Date myDate = new Date();

        String numberString ="321";
        int intFromString = Integer.parseInt(numberString);

        System.out.println((numberString));
        System.out.println((intFromString));
    }
    private static void LessonVariables(String ScopeVar){

        System.out.println(ScopeVar);

        String lastName = "Nemcek", firstName = "Tucker";

        System.out.println(lastName + " " + firstName);

        Scanner reader = new Scanner (System.in);

        System.out.print("Enter your name: ");

        String input = reader.nextLine();

        System.out.println("Hello " +input);

    }

}
