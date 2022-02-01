The current project is based on the spring boot and support two end point
http://localhost:8080/v1/bfs/booking - get, return all booking
http://localhost:8080/v1/bfs/booking - post create the booking if not existing

Architecture - is based on the layered concept due to time constraint and some requirement gaps. Otherwise hexagonal architecture is preferred in view of testing and extensibility

data model - mainly 3 domain object used
Person - personal details and contact number, contact number is used to identify the person uniquely
Address - address of the person - currntly one to one mapping but should have been one to many, line1 is used to identify the address uniquely. Ideally should have been code used
Booking - booking created by Person, one to many to person, combination of checkin and checkout and person id is used


Application flow
 -Get method, invokes service and return the booking using repository query, convertors are used to convert the enity to the ui model
 - put flow - convert the input to DB model
            - pass through the validation, if fails raise exception
            - no exception, identify the existing record based on input, duplicate check criteria mentioned in data model, otherwise create new record 
            - once db entities are returned convert back to UI model 

Error handling - is done by the controller advice, basic flow is given there is good scope to enhance it
Validation check - could have used spring framework but currently used own way due to time constraints, currenlty one validation checkintime < checkouttime is added to show how it works

Testing - junit with mocking is used, Currenlty not 100% coverage but most important flows are covered and others test case can be added based on the existing test cases. I prefer using simple junit test case with proper injection of mocks

technology - spring boot server, hibernate as orm, h2 in memory DB

