package flyweight_design_pattern;

import java.util.HashMap;
import java.util.Random;

// Employee interface with methods for assigning skills and performing tasks
interface Employee {
  public void assignSkill(String skill);
  public void task();
}

// Developer class implements the Employee interface for developers
class Developer implements Employee {
  private final String JOB;
  private String skill;

  public Developer() {
    JOB = "Fix the issue";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
  }
}

// Tester class implements the Employee interface for testers
class Tester implements Employee {
  private final String JOB;
  private String skill;

  public Tester() {
    JOB = "Test the issue";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
  }
}

// EmployeeFactory manages the creation and storage of Employee instances
class EmployeeFactory {
  private static HashMap<String, Employee> m = new HashMap<String, Employee>();

  public static Employee getEmployee(String type) {
    Employee p = null;
    if (m.get(type) != null) {
      p = m.get(type);
    } else {
      switch (type) {
        case "Developer":
          System.out.println("Developer Created");
          p = new Developer();
          break;
        case "Tester":
          System.out.println("Tester Created");
          p = new Tester();
          break;
        default:
          System.out.println("No Such Employee");
      }

      m.put(type, p);
    }
    return p;
  }
}

public class FlyweightPattern {
  private static String employeeType[] = {"Developer", "Tester"};
  private static String skills[] = {"Java", "C++", ".Net", "Python"};

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
      e.assignSkill(getRandSkill());
      e.task();
    }
  }

  // Helper method to get a random employee type
  public static String getRandEmployee() {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt];
  }

  // Helper method to get a random skill
  public static String getRandSkill() {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt];
  }
}
