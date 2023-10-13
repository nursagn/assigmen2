package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// The Vehicle class implements the Cloneable interface for cloning
class Vehicle implements Cloneable {
  private List<String> vehicleList;

  public Vehicle() {
    this.vehicleList = new ArrayList<String>();
  }

  public Vehicle(List<String> list) {
    this.vehicleList = list;
  }

  public void insertData() {
    vehicleList.add("Honda Amaze");
    vehicleList.add("Audi A4");
    vehicleList add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList() {
    return this.vehicleList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();

    for (String s : this.getVehicleList()) {
      tempList.add(s);
    }

    return new Vehicle(tempList);
  }
}

public class PrototypePattern {
  public static void main(String[] args) throws CloneNotSupportedException {
    // Create a prototype object 'a' and insert data
    Vehicle a = new Vehicle();
    a.insertData();

    // Clone 'a' to create a new object 'b'
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();

    // Modify the cloned list by adding a new vehicle
    list.add("Honda New Amaze");

    // Print the vehicle list from both 'a' and 'b'
    System.out.println("Vehicle List from 'a': " + a.getVehicleList());
    System.out.println("Vehicle List from 'b': " + list);

    // Remove an item from the cloned list and print both lists
    b.getVehicleList().remove("Audi A4");
    System.out.println("Modified List from 'b': " + list);
    System.out.println("Original List from 'a': " + a.getVehicleList());
  }
}
