------------------------------------------------------------------------------
Instruction to Run the project
------------------------------------------------------------------------------
1. Build and Run application.

   Method-1: usingCommand line ->
    - build project using command -> mvn clean install
    - go to target folder and run jar file using command -> java -jar trade-app-1.0-SNAPSHOT.jar

   Method-2: using class with main method directly
   - ApplicationRunner class is the main class to be used to run the test the project and its functionality

2. Enter input command line

   - Input 1 Type of sorted data you want in the report. e.g.
        Command line display: 
        
        
        Enter Sorting Type for Report (INCOMING/OUTGOING):: INCOMING

   - Input 2 Enter date for which report to be generated, its optional. If kept blank it will display all the records.
    If date entered in format (dd MMM yyyy) it will display records for that date only.
        Command line Display: 
       
       
       Enter Date (format dd MMM yyy, e.g 01 Aug 2019) for the report (Optional) ::
       
       OR
       
       Enter Date (format dd MMM yyy, e.g 01 Aug 2019) for the report (Optional) :: 01 Aug 2019

3. Output will be returned in the console
    To get report, place enter and report will be displayed command line like below:
    

    settlementDate    entity    incomingAmount    outgoingAmount
    
    ============================================================================
    [2019-08-20        foo        5012.5        10025.0
    
    , 2019-08-20        bar        null        1655.5
    
    , 2019-08-18        bar        14899.5        1655.5
    
    , 2019-08-14        joo        null        10025.0
    
    , 2019-08-12        joo        null        10025.0

4. Some test coverage is provided for few classes as per time available but ideal would be 100% coverage.

5. InstructionBuilder can be used to create sample data

6. pom.xml contains all the dependencies used in the project

7. Assumptions:
    - InstructionApp as an interface to read client Instructions for trading/settlement
    - TradeReportService is main service to retrieve settlement report data
    - Project is completed with a time limitation.
