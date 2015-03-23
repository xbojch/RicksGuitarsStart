public class GuitarSpec {
 
  private Builder builder; 
  private String model;
  private Type type;
  private Wood backWood;
  private Wood topWood;
  private int numStrings;

  public GuitarSpec(Builder builder, String model, Type type,
                    Wood backWood, Wood topWood, int numStrings) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.backWood = backWood;
    this.topWood = topWood;
    this.numStrings = numStrings;
  }

  public Builder getBuilder() {
    return builder;
  }

  public String getModel() {
    return model;
  }

  public Type getType() {
    return type;
  }

  public Wood getBackWood() {
    return backWood;
  }

  public Wood getTopWood() {
    return topWood;
  }

  public int getNumStrings() { return numStrings; }

  public boolean matches(GuitarSpec spec) {
    if (this.getBuilder() != spec.getBuilder()) {
      return false;
    }
    if ((this.getModel() != null) && (this.getModel() != "") && (this.getModel() != spec.getModel())) {
      return false;
    }
    if (this.getType() != spec.getType()) {
      return false;
    }
    if (this.getBackWood() != spec.getBackWood()) {
      return false;
    }
    if (this.getTopWood() != spec.getTopWood()) {
      return false;
    }
    if (this.getNumStrings() != spec.getNumStrings()) {
      return false;
    }

    return true;
  }
}
