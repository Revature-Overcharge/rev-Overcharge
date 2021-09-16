
-- Users
insert into users (id, username, password, points, role, last_login) values (1, 'mclapston0', 'kGex8fqXt8', 89, 1, 1629315831000);
insert into users (id, username, password, points, role, last_login) values (2, 'snassey1', 'CwQOZeX', 68, 2, 1629315706000);
insert into users (id, username, password, points, role, last_login) values (3, 'jbolsteridge2', 'APU1yVAJO9W', 52, 2, 1629315843000);
insert into users (id, username, password, points, role, last_login) values (4, 'kdarco3', 'dJMNV7', 67, 2, 1629315937000);
insert into users (id, username, password, points, role, last_login) values (5, 'nriseborough4', 'js9Gzq4X8', 60, 2, 1629315680000);
insert into users (id, username, password, points, role, last_login) values (6, 'wblackley5', 'D2BNKoim', 6, 2, 1629315786000);
insert into users (id, username, password, points, role, last_login) values (7, 'cdavydoch6', 'N63aKnQ72N', 84, 2, 1629315784000);
insert into users (id, username, password, points, role, last_login) values (8, 'tholburn7', '2E2LGtacW', 49, 2, 1629315622000);
insert into users (id, username, password, points, role, last_login) values (9, 'vguerrin8', 'dwCCrw', 14, 2, 1629315698000);
insert into users (id, username, password, points, role, last_login) values (10, 'lelvy9', '6PbDEWA5yo', 26, 2, 1629315695000);
insert into users (id, username, password, points, role, last_login) values (11, 'user', 'pass', 26, 2, 1629315455000);

-- Decks
insert into decks (id, creator_id, title, created_on, status) values (1, 2, 'DevOps', 1629315906000, 1);
insert into decks (id, creator_id, title, created_on, status) values (2, 3, 'Testing', 1629319843000, 2);
insert into decks (id, creator_id, title, created_on, status) values (3, 3, 'Spring', 1629329843000, 3);

-- Ratings
-- Ratings for deck 1 (DevOps) from users 1, 4, 5
insert into ratings (user_id, deck_id, stars, rated_on) values (1, 1, 2, 1629316906000);
insert into ratings (user_id, deck_id, stars, rated_on) values (4, 1, 4, 1629317906000);
insert into ratings (user_id, deck_id, stars, rated_on) values (5, 1, 3, 1629318906000);
-- Ratings for deck 2 (Testing) from users 8, 9, 10
insert into ratings (user_id, deck_id, stars, rated_on) values (8, 2, 3, 1629933179000);
insert into ratings (user_id, deck_id, stars, rated_on) values (9, 2, 3, 1629339843000);
insert into ratings (user_id, deck_id, stars, rated_on) values (10, 2, 2, 1629349843000);
-- Ratings for deck 3 (Spring) from users 8, 9, 10
insert into ratings (user_id, deck_id, stars, rated_on) values (8, 3, 1, 1629329843000);
insert into ratings (user_id, deck_id, stars, rated_on) values (9, 3, 2, 1629933179000);
insert into ratings (user_id, deck_id, stars, rated_on) values (10, 3, 2, 1629349843000);

-- Cards
-- DevOps: created by user 2
insert into cards (id, deck_id, question, answer, created_on) values (1, 1, 'A _______ is the term used for a Jenkins build workflow that you configure for a project.', 'Job', 1629315687000);
insert into cards (id, deck_id, question, answer, created_on) values (2, 1, 'A ______ defines when a Jenkins will begin a build.', 'Build configuration', 1629315931000);
insert into cards (id, deck_id, question, answer, created_on) values (3, 1, 'For EC2, which instance state will completely remove the instance and its backing store?', 'Terminate', 1629315775000);
insert into cards (id, deck_id, question, answer, created_on) values (4, 1, 'What are advantages of DevOps?', 'Faster code delivery', 1629315794000);
insert into cards (id, deck_id, question, answer, created_on) values (5, 1, 'What does the AWS S3 service provide?', 'Persistent storage', 1629315613000);
insert into cards (id, deck_id, question, answer, created_on) values (6, 1, 'What does the acronym AMI mean?', 'Amazon Machine Image', 1629315840000);
insert into cards (id, deck_id, question, answer, created_on) values (7, 1, 'What is the default location of your local repository?', 'userhome/.m2/repository', 1629315549000);
insert into cards (id, deck_id, question, answer, created_on) values (8, 1, 'What is Maven?', ' A build automation and project management tool', 1629315825000);
insert into cards (id, deck_id, question, answer, created_on) values (9, 1, 'POM stands for:', 'Project Object Model', 1629315697000);
insert into cards (id, deck_id, question, answer, created_on) values (10, 1, 'Which AWS service creates a virtual machine in the cloud?', 'EC2', 1629315596000);
insert into cards (id, deck_id, question, answer, created_on) values (11, 1, 'Which AWS service provides DNS translation?', 'Route 53', 1629315991000);
insert into cards (id, deck_id, question, answer, created_on) values (12, 1, 'Which service is a type of storage container for data in AWS?', 'S3', 1629315671000);
insert into cards (id, deck_id, question, answer, created_on) values (13, 1, 'T/F: Stopping an instance will delete the instance and disassociate any data storage volumes and delete them as well.', 'False', 1629315966000);
insert into cards (id, deck_id, question, answer, created_on) values (14, 1, 'AWS VPC stands for?', 'Virtual Private Cloud', 1629315865000);

-- StudiedCards
-- User 4 does not want to see cards 1, 2, 3, 4 anymore
insert into studied_cards (user_id, card_id, studied_on) values (4, 1, 1629316687000);
insert into studied_cards (user_id, card_id, studied_on) values (4, 2, 1629317687000);
insert into studied_cards (user_id, card_id, studied_on) values (4, 3, 1629318687000);
insert into studied_cards (user_id, card_id, studied_on) values (4, 4, 1629319687000);
-- User 1 does not want to see cards 11, 12 anymore
-- insert into studied_cards (user_id, card_id, studied_on) values (1, 11, 1629315991000);
-- insert into studied_cards (user_id, card_id, studied_on) values (1, 12, 1629318991000);


insert into studied_cards (user_id, card_id, studied_on) values (1, 1, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 2, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 3, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 4, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 5, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 6, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 7, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 8, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 9, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 10, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 11, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 12, 1629935035000);
insert into studied_cards (user_id, card_id, studied_on) values (1, 13, 1629935035000);

-- Cards
-- Testing: created by user 3
insert into cards (id, deck_id, question, answer, created_on) values (15, 2, 'What does BDD stand for?', 'Behavior-driven development', 1629315695000);
insert into cards (id, deck_id, question, answer, created_on) values (16, 2, 'What is step definition in Cucumber?', 'Code implementation of the feature file', 1629315633000);
insert into cards (id, deck_id, question, answer, created_on) values (17, 2, 'What is the language used in a feature file?', 'Gherkin', 1629315814000);
insert into cards (id, deck_id, question, answer, created_on) values (18, 2, 'Which step comes first in behavior-driven development?', 'Write a failing acceptance test', 1629315971000);
insert into cards (id, deck_id, question, answer, created_on) values (19, 2, 'Which method of the WebDriver interface will open a Web browser?', 'Get', 1629315854000);
insert into cards (id, deck_id, question, answer, created_on) values (20, 2, 'What method of the WebElement interface types text into a DOM element?', 'sendKeys', 1629315728000);
insert into cards (id, deck_id, question, answer, created_on) values (21, 2, 'To run a test method second in TestNG, use:', '@Test(priority=2)', 1629315961000);
insert into cards (id, deck_id, question, answer, created_on) values (22, 2, 'Which annotation specifies a source to supply test data to a test method?', '@DataProvider', 1629315622000);
insert into cards (id, deck_id, question, answer, created_on) values (23, 2, 'Which TestNG method annotation will execute first?', '@BeforeSuite', 1629315561000);
insert into cards (id, deck_id, question, answer, created_on) values (24, 2, 'What is the basic structure of scenario steps in Gherkin?', 'Given, When, Then', 1629315607000);
insert into cards (id, deck_id, question, answer, created_on) values (25, 2, 'When using Cucumber with JUnit, you need a ‘hook’ class annotated with:', '@RunWith(Cucumber.class)', 1629315711000);
insert into cards (id, deck_id, question, answer, created_on) values (26, 2, 'The page object model says that we should make pages in our application', 'Class in our framework', 1629315737000);
insert into cards (id, deck_id, question, answer, created_on) values (27, 2, 'What is the name of that class that allows for finding elements on a page?', 'By', 1629315940000);
insert into cards (id, deck_id, question, answer, created_on) values (28, 2, 'In BDD, ____ denotes the desired outcome of a test.', 'Then', 1629315812000);
insert into cards (id, deck_id, question, answer, created_on) values (29, 2, 'In BDD, ____ denotes the action taken for a test.', 'When', 1629315763000);
insert into cards (id, deck_id, question, answer, created_on) values (30, 2, 'In BDD, ____ denotes the preconditions for a test.', 'Given', 1629315799000);
insert into cards (id, deck_id, question, answer, created_on) values (31, 2, '@Test has the optional parameters of:', 'expected and timeout', 1629315693000);
insert into cards (id, deck_id, question, answer, created_on) values (32, 2, 'In what order are annotated methods executed?', ' BeforeClass, Before, Test, After, AfterClass', 1629315616000);
insert into cards (id, deck_id, question, answer, created_on) values (33, 2, 'What is the package for JUnit?', 'org.junit', 1629315734000);

-- StudiedCards
-- User 4 does not want to see cards 1,2,3,4 anymore
insert into studied_cards (user_id, card_id, studied_on) values (4, 17, 1629315814000);
insert into studied_cards (user_id, card_id, studied_on) values (4, 18, 1629316814000);

-- Cards
-- Spring: created by user 3
insert into cards (id, deck_id, question, answer, created_on) values (34, 3, 'What annotation in Spring MVC is used in REST to define the URI where resource can be accessed?', 'RequestMapping', 1629315720000);
insert into cards (id, deck_id, question, answer, created_on) values (35, 3, '_____ advice executes regardless of the means by which a join point exits (normal or exceptional return).', 'After', 1629315579000);
insert into cards (id, deck_id, question, answer, created_on) values (36, 3, 'What is the current core container in Spring?', 'cras', 1629315756000);
insert into cards (id, deck_id, question, answer, created_on) values (37, 3, 'The Spring Web MVC framework is designed around a _____ that handles all the HTTP requests and responses', 'DispatcherServlet', 1629315541000);
insert into cards (id, deck_id, question, answer, created_on) values (38, 3, 'What are the different types of Advice?', 'after, after throwing, after returning, around, before', 1629315646000);
insert into cards (id, deck_id, question, answer, created_on) values (39, 3, 'What do you mean by Aspect?', 'A modularization of a concern that cuts across multiple objects', 1629315815000);
insert into cards (id, deck_id, question, answer, created_on) values (40, 3, 'What do you mean by Advice?', 'Action taken at a particular join point', 1629315989000);
insert into cards (id, deck_id, question, answer, created_on) values (41, 3, 'What are the scopes of a Spring bean?', 'Singleton, Prototype, Session, Global Session, Request', 1629315726000);
insert into cards (id, deck_id, question, answer, created_on) values (42, 3, 'The ____ takes the request and calls the appropriate service methods based on used GET or POST method.', 'Controller', 1629315979000);
insert into cards (id, deck_id, question, answer, created_on) values (43, 3, 'ApplicationContext will pre-instantiate beans with the ________ bean scope', 'Singleton', 1629315945000);
insert into cards (id, deck_id, question, answer, created_on) values (44, 3, '_____ advice surrounds a join point such as a method invocation. This is the most powerful kind of advice.', 'Around', 1629315767000);
insert into cards (id, deck_id, question, answer, created_on) values (45, 3, '____ advice executes after a join point completes normally: for example, if a method returns without throwing an exception.', 'After returning', 1629315540000);
insert into cards (id, deck_id, question, answer, created_on) values (46, 3, '____ advice executes before a join point, but does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).', 'Before', 1629315737000);
insert into cards (id, deck_id, question, answer, created_on) values (47, 3, '_____ advice executes if a method exits by throwing an exception.', 'After throwing', 1629315712000);
insert into cards (id, deck_id, question, answer, created_on) values (48, 3, 'The process of automatically injecting bean dependencies is called what?', 'autowiring', 1629315743000);
insert into cards (id, deck_id, question, answer, created_on) values (49, 3, 'True or False: Spring MVC can use HTML documents as views', 'True', 1629315719000);
insert into cards (id, deck_id, question, answer, created_on) values (50, 3, 'T/F: A singleton bean returns a NEW instance every time the bean is retrieved from the Application Context?', 'False', 1629315787000);

-- StudiedCards
-- User 3 does not want to see cards 35, 36 anymore
insert into studied_cards (user_id, card_id, studied_on) values (3, 35, 1629315720000);
insert into studied_cards (user_id, card_id, studied_on) values (3, 36, 1629316720000);

