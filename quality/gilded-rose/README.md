# Gilded Rose Refactoring Code Kata

## Prerequisites

1. Install Java Version ???

## Activity

For this activity we are going to refactor the code in the [GildedRose::updateQuality()](src/main/java/com/gildedrose/GildedRose.java)

The functionality of the Gilded Rose application has been tested using a single [Golden Master Test](https://en.wikipedia.org/wiki/Characterization_test)
you can find this test in [TextFixtureTest.java](src/test/java/com/gildedrose/TextFixtureTest.java). This Test file
contains a few different functions.

The first `buildGold()` the function creates a collection of Items that contains all the Items the Gilded Rose sell.
It creates an instance of the Gilded Rose application with that collection of Items. It then creates a string of the
current state of all the items and then call `GildedRose::updateQuality()` it does this 32 times. Finally, is returns a
`StringBuilder` containing the state of the Items for each of the 32 runs.

This `buildGold()` function is then used by the following two functions

The `main()` function calls `buildGold()` and saves the contents of the `StringBuilder` to a file call
[gold.txt](src/test/resources/gold.txt).

The `checkAllIsGold()` is the Gold Master test function. It loads the text from the `gold.txt` file and then runs the
`buildGold()` function to ensure that the content of the text file matches the content return from the latest run.

When you are working on this task remember all the different [refactoring techniques](https://refactoring.guru/refactoring/techniques)
available to you.

To run the test you can use Gradle or Maven

```shell
./gradlew test
```

```shell
./mvnw test
```

### Gilded Rose Requirements Specification

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
we can begin selling a new category of items. First an introduction to our system:

	- All items have a SellIn value which denotes the number of days we have to sell the item
	- All items have a Quality value which denotes how valuable the item is
	- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

	- Once the sell by date has passed, Quality degrades twice as fast
	- The Quality of an item is never negative
	- "Aged Brie" actually increases in Quality the older it gets
	- The Quality of an item is never more than 50
	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.
