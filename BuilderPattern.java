package builder_design_pattern;

// Vehicle class represents the product being built
class Vehicle {
  private String engine;
  private int wheel;
  private int airbags;

  public String getEngine() {
    return this.engine;
  }

  public int getWheel() {
    return this.wheel;
  }

  public int getAirbags() {
    return this.airbags;
  }

  // Private constructor to be used only by the inner VehicleBuilder
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // VehicleBuilder class for building Vehicle objects
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    private int airbags;

    // Constructor with required parameters
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Method to set optional parameter (airbags) and return the builder
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    // Method to build the final Vehicle object
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

public class BuilderPattern {
  public static void main(String[] args) {
    // Create a car using the VehicleBuilder
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

    // Create a bike using the VehicleBuilder
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Display car details
    System.out.println("Car Engine: " + car.getEngine());
    System.out.println("Car Wheels: " + car.getWheel());
    System.out.println("Car Airbags: " + car.getAirbags());

    // Display bike details
    System.out.println("Bike Engine: " + bike.getEngine());
    System.out.println("Bike Wheels: " + bike.getWheel());
    System.out.println("Bike Airbags: " + bike.getAirbags());
  }
}
