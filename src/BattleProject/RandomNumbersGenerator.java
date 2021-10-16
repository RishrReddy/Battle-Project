package BattleProject;

import java.util.List;

/**
 * RandomNumbersGenerator interface represents the generation of
 * random number in the range specified.
 * It is implemented by two classes RandomNumberGenerateTest and
 * RandomNumberGenerateSource, objects which will be used for testing and development purpose
 * respectively.
 */
public interface RandomNumbersGenerator {


  /**
   * Generates a random integer within the provided range.
   * @param minValue minimum accepted value.
   * @param maxValue maximum accepted value.
   * @return an integer which is randomly generated.
   */
  int getRandomNumber(int minValue, int maxValue);

  /**
   * Generates a list of random integers.
   * @param listSize total number of random integers to be generated
   * @param maxValue maximum accepted value.
   * @return a List of integers which is randomly generated.
   */
  List<Integer> getRandomList(int listSize, int maxValue);
}
