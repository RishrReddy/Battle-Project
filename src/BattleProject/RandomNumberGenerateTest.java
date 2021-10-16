package BattleProject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * RandomNumberGenerateTest class provides an integer or list of integers for testing
 * the source code involving randomly generated numbers.
 * It implements the RandomNumbersGenerator interface and overrides its methods as desired.
 */
public class RandomNumberGenerateTest implements RandomNumbersGenerator {
  private int randomValue;
  private List<Integer> randomNumberList;

  /**
   * Constructs a RandomNumberGenerateTest object with the value provided
   * which will further be used in testing.
   * @param value integer represented the random number.
   */
  public RandomNumberGenerateTest(int ...value){
    if(value.length>1){
      if(this.randomNumberList==null){
        this.randomNumberList = new ArrayList<>();
      }
      for(Integer i : value){
        this.randomNumberList.add(i);
      }
      this.randomValue = 2;
    }else if(value.length==1){
      this.randomValue = value[0];
    }
  }

  @Override
  public int getRandomNumber(int minValue, int maxValue) {
      return this.randomValue;
  }

  @Override
  public List<Integer> getRandomList(int listSize, int maxValue) {
    List<Integer> randomList = new ArrayList<>();
    if(listSize == 10){
      randomList.add(2);
      randomList.add(6);
      randomList.add(11);
      randomList.add(23);
      randomList.add(16);
      randomList.add(18);
      randomList.add(34);
      randomList.add(39);
      randomList.add(15);
      randomList.add(20);
      return randomList;
    }
    return this.randomNumberList ;
  }
}
