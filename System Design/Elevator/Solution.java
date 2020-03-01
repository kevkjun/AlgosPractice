/*
Design an elevator system given the following specifications:
    1. There are 10 floors
    2. There are 4 elevators
    3. Each floor has both an up and down button
    4. If an elevator is idle, then it stays on the floor it is at

Use Cases:
    - Process Car/Lift Calls: This use case includes several scenarios resulting from the passenger providing input from within the elevator. These scenarios include that the elevator receives lift/car calls from the passengers, turns on or turns off the light of lift/car call buttons, updates the record of lift/car calls stored in system controlling parts, etc. 
    - Process Hall Calls: Similar to Lift/Car Call processing, this use case includes use cases in which the elevator receives hall calls from the passengers, turns on or turns off the light of hall call buttons, updates the record of hall calls in system controlling parts, etc.
    - Move/Stop the Car: The main function of an elevator will include the changing of driving speed, how to make the decision to stop, and driving directions of the car.
    - Indicating Moving Direction: The elevator should have this mechanism to let the passengers in the hall know the current moving direction of the car such that the passenger might decide whether to enter the car or not.
    - Indicating Car Position: Similarly, the elevator should let the passengers know whether his/her destination floor is reached so that the passenger may decide to leave the car.
    - Open/Close the Doors: The elevator should be able to open and close the doors for the passengers to get in and out of the car. The functional areas of this use case should also enable the passengers to make door reversals when the doors are closing and the passenger wants to get in the car (perhaps an extra feature not necessarily required in the MVP).
    - Trigger Emergency Brake: The safety mechanism within the car to make sure that an unsafe state is not transiently generated.
*/