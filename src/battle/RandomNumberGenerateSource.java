package battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RandomNumberGenerateSource class provides a random integer or list of integers for generating
 * randomness required in the development process.
 * It extends Random class and
 * implements the RandomNumbersGenerator interface overriding its methods as desired.
 */
public class RandomNumberGenerateSource extends Random implements RandomNumbersGenerator {
  Random random = new Random();

  @Override
  public int getRandomNumber(int min, int max) {
    return random.ints(min, max + 1).findFirst().getAsInt();
  }

  @Override
  public List<Integer> getRandomList(int listSize, int maxValue) {
    List<Integer> indexList = new ArrayList<>();
    for (int j = 0; j < listSize; j++) {
      int randomValue = getRandomNumber(0, maxValue);
      while (indexList.contains(randomValue)) {
        randomValue = getRandomNumber(0, maxValue);
      }
      indexList.add(randomValue);
    }
    return indexList;
  }
}
