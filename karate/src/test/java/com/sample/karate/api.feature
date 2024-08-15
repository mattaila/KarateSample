Feature: sample karate test script
  for help, see: https://github.com/karatelabs/karate/wiki/IDE-Support

  Background:
    * url 'http://localhost:8080'

  Scenario: create data and then get it by id
    
    #create data
    * def postData =
      """
      {
        "id": 1,
        "name": "user1",
        "description": "this is Karate test"
      }
      """

    * print 'post data is ' , postData
    Given url 'http://localhost:8080/create'
    And request postData
    When method post
    Then status 200

    #get data
    Given url 'http://localhost:8080/get/' + postData.id
    When method get
    Then status 200
    And match $ == postData
    * print 'response data is ' , response

  Scenario: update data
    
    #update data
    * def postUpdateData =
      """
      {
        "id": 1,
        "name": "user1",
        "description": "updated"
      }
      """

    * print 'post data is ' , postUpdateData
    Given url 'http://localhost:8080/update/' + postUpdateData.id
    And request postUpdateData
    When method post
    Then status 200

    #get data
    Given url 'http://localhost:8080/get/' + postUpdateData.id
    When method get
    Then status 200
    And assert response.description == postUpdateData.description
    * print 'response data is ' , response

  Scenario: list data
    
    #create data
    * def postData2 =
      """
      {
        "id": 2,
        "name": "user2",
        "description": "this is Karate test2"
      }
      """
    
    * def postData3 =
      """
      {
        "id": 3,
        "name": "user3",
        "description": "this is Karate test3"
      }
      """

    * print 'post data is ' , postData2
    Given url 'http://localhost:8080/create'
    And request postData2
    When method post
    Then status 200

    * print 'post data is ' , postData3
    Given url 'http://localhost:8080/create'
    And request postData3
    When method post
    Then status 200

    #get data
    Given url 'http://localhost:8080/list'
    When method get
    Then status 200
    And assert response.length == 3
    * print 'response data is ' , response

   Scenario: delete data
    
    #delete data
    Given url 'http://localhost:8080/delete/1'
    When method get
    Then status 200

    #get data
    Given url 'http://localhost:8080/list'
    When method get
    Then status 200
    And assert response.length == 2
    * print 'response data is ' , response

  