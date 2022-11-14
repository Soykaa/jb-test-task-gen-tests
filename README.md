# Automatically generating unit tests: test task

## Requirements

- Java 11
- Maven

## Information about fixes

The first thing I did was run the test - and yes, it doesn't work! (it was important to make sure). I split the assert into 2 different asserts to make sure that the problem was exactly in exceeding the permissible value.

1. Before fixing bugs - formatting and code cleanup. This way it is more pleasant to read, easier to work with.
2. Editing in the places highlighted by the IDE - again, so at least it is more pleasant to work with what you have at the moment.
Adding keywords (final, static) in places where necessary
3. Bug fixes.
- I guess getEnergy should just return the current energy level, not increase it by one
- Since distance is a module, car has Math.abs missing in the driveTo method (this seems to be where `testPerson` was already going)
- Since the action takes place in a 2D world, it makes sense that the coordinates should be two-dimensional

## Time, time, time: TODO

- bring out the magic constants
- add checks
- check the overall logic (this requires more time, and I don't have enough of it)
- cover the unit with tests - at least 2-3 per method
- write larger tests (for example, integration tests, which will have time)
- additional refactoring (if necessary)
- Bonus: Javadoc would definitely make everyone's life easier...