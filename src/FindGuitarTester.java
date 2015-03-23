import java.util.Iterator;
import java.util.List;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec whatErinLikes = 
      new GuitarSpec(Builder.FENDER, "Stratocastor", 
                     Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);
    List matchingGuitars = inventory.search(whatErinLikes);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getModel() + " " +
            spec.getNumStrings() + "-string" + " " +
          spec.getType() + " guitar:\n     " +
          spec.getBackWood() + " back and sides,\n     " +
          spec.getTopWood() + " top.\n  You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar("11277", 3999.95, new GuitarSpec(Builder.COLLINGS,
                        "CJ", Type.ACOUSTIC, 
                        Wood.INDIAN_ROSEWOOD, Wood.SITKA, 12));
    inventory.addGuitar("V95693", 1499.95, new GuitarSpec(Builder.FENDER,
                        "Stratocastor", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, 12));
    inventory.addGuitar("V9512", 1549.95, new GuitarSpec(Builder.FENDER,
                        "Stratocastor", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, 12));
    inventory.addGuitar("122784", 5495.95, new GuitarSpec(Builder.MARTIN,
                        "D-18", Type.ACOUSTIC,
                        Wood.MAHOGANY, Wood.ADIRONDACK, 12));
    inventory.addGuitar("76531", 6295.95, new GuitarSpec(Builder.MARTIN,
                        "OM-28", Type.ACOUSTIC,
                        Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK, 6));
  }
}
