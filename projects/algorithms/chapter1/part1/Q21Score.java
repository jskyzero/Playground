public class Q21Score {
  public String name;
  public int totalScore;
  public int getScore;

  public Q21Score(String name_, int totalScore_, int getScore_) {
    name = name_;
    totalScore = totalScore_;
    getScore = getScore_;
  }

  public double calculatePercentage() {
    return (double)getScore / totalScore;
  }

  public String printScore() {
    return String.format("Name: %-10s Total: %-5d Get: %-5d Percentage: %-5f", name, totalScore, getScore, calculatePercentage());
  }
}