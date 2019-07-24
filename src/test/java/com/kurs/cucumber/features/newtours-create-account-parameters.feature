Feature: Aavtrain user creation

  Scenario Outline: user can create an account on website

    Given an open browser with http://newtours.demoaut.com/mercuryregister.php ncap_feature

    When user fills in required fields: <firstName>, <lastName>, <phone>, <email>, <address1>, <address2>, <city>, <state>, <zip>, <userName>, <password>, <passwordC> ncap_feature

    And click Submit button ncap_feature

    Then user is created ncap_feature

    And close web browser ncap_feature

    Examples:
      |firstName |lastName  |phone        |email                         |address1            |address2            |city         |state |zip    |userName |password  |passwordC |
      |James     |Butt      |504-621-8927 |jbutt@gmail.com               |6649 N Blue Gum St  |6649 N Blue Gum St  |New Orleans  |LA    |70116  |jambut   |jambut123 |jambut123 |
      |Josephine |Darakjy   |810-292-9388 |josephine_darakjy@darakjy.org |4 B Blue Ridge Blvd |4 B Blue Ridge Blvd |Brighton     |MI    |48116  |josdar   |josdar123 |josdar123 |
      |Art       |Venere    |856-636-8749 |art@venere.org                |8 W Cerritos Ave 54 |8 W Cerritos Ave 54 |Bridgeport   |NJ    |8014   |artven   |artven123 |artven123 |
      |Lenna     |Paprocki  |907-385-4412 |lpaprocki@hotmail.com         |639 Main St         |639 Main St         |Anchorage    |AK    |99501  |lenpap   |lenpap123 |lenpap123 |
      |Donette   |Foller    |513-570-1893 |donette.foller@cox.net        |34 Center St        |34 Center St        |Hamilton     |OH    |45011  |donfol   |donfol123 |donfol123 |
      |Simona    |Morasca   |419-503-2484 |simona@morasca.com            |3 Mcauley Dr        |3 Mcauley Dr        |Ashland      |OH    |44805  |simmor   |simmor123 |simmor123 |
      |Mitsue    |Tollner   |773-573-6914 |mitsue_tollner@yahoo.com      |7 Eads St           |7 Eads St           |Chicago      |IL    |60632  |mittol   |mittol123 |mittol123 |
      |Leota     |Dilliard  |408-752-3500 |leota@hotmail.com             |7 W Jackson Blvd    |7 W Jackson Blvd    |San Jose     |CA    |95111  |leodil   |leodil123 |leodil123 |
      |Sage      |Wieser    |605-414-2147 |sage_wieser@cox.net           |5 Boston Ave 88     |5 Boston Ave 88     |Sioux Falls  |SD    |57105  |sagwie   |sagwie123 |sagwie123 |
