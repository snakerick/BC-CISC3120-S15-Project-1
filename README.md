# README.md

The long assignment description is [here](http://bc-cisc3120-s15.github.io/project1-flyingobjects).

## Description and Instructions
Created a simple space game. The game creates objects and the goal is to avoid the objects. Once an object touches its Game Over. 
######Instruction
The user can use the 4 arrow keys: up, down, left, right to move the ship. Moving to any boarders will bring to you to opposite end of the gameboard it "wraps" around. Your main goal is to avoid the **SPACE OBJECTS**!!

## Works Cited
1. http://en.wikipedia.org/wiki/Decorator_pattern
2. http://docs.oracle.com/javase/7/docs/api/
3. http://codereview.stackexchange.com/questions/58063/better-way-to-implement-screen-wraparound (Used example code for wrap around)
4. Sample codes from class.

## Code Summary
######SimpleGame:
This class creates the game and the objects for the game. It also keeps track of the score and when the game is done. 
######KeyboardAdpater 
This is uses the adapter design method to create a keyboardadapter class which allows the user to control a specific object.
######FallingObject, SpinningObject, ControlledObject
These three classes does the following: ######FallingObject, makes the object fall from the screen with a wrap around. ######SpinningObject, allows the object to rotate wiht a specific *r*. ######ControlledObject, allows the object passed in to have user controll. All these threw classes takes in a SpaceObject which is create by the SimpleGame. 
######Polygon
The method for *move* was changed so that a wrap around was created in the game. This allows the object that falls out of the boarder to come back in on the opposite side, like a *circle*.
######SimpleSpaceObject
This creates a simple *SpaceObject* which takes in points from a polygon. 
The collide method was filled in, so that when the object being passed in the arugument *collides* with the other, the one that is calling the function disappears and set the area to 0.
######SpaceObject Interface
The method *getPoly()* was added which returns a Polygon so that it would be easier to test to see if two objects collide.

## Extra Credit Behavior
None.
