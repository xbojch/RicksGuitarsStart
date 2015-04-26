import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by bojan on 26.04.15.
 */
public class FindInstrument {

    public static void main (String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        Map properties = new HashMap();
        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.MAPLE);
        InstrumentSpec clientSpec = new InstrumentSpec(properties);

        List matchingInstruments = inventory.search(clientSpec);
        if (!matchingInstruments.isEmpty()) {
            System.out.println("You might like these instruments:");
            for (Iterator i = matchingInstruments.iterator(); i.hasNext();) {
                Instrument instrument = (Instrument)i.next();
                InstrumentSpec spec = instrument.getSpec();
                System.out.println("We have a " + spec.getProperty("instrumentType") + " with the following properties: ");
                for (Iterator j = spec.getProperties().keySet().iterator(); j.hasNext();) {
                    String propertyName = (String)j.next();

                    if (propertyName.equals("instrumentType")) {
                        continue;
                    }
                    System.out.println("    " + propertyName + ": "+ spec.getProperty(propertyName));
                }

                System.out.println("You can have this " + spec.getProperty("instrumentType") + " for $"+ instrument.getPrice() + "\n----");
            }
        }
        else {
            System.out.println("Sorry, we have nothing for you.");
        }

    }

    private static void initializeInventory (Inventory inventory) {
        Map properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("backWood", Wood.SITKA);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("numStrings", 6);
        properties.put("type", Type.ACOUSTIC);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Les Paul");
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        properties.put("numStrings", 6);
        properties.put("type", Type.ELECTRIC);
        inventory.addInstrument("70108276", 2295.95, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "F5-G");
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        properties.put("type", Type.ACOUSTIC);
        inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

        properties = new HashMap();
        properties.put("instrumentType", InstrumentType.BANJO);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "RB-3");
        properties.put("backWood", Wood.MAPLE);
        properties.put("numStrings", 5);
        properties.put("type", Type.ACOUSTIC);
        inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));


    }
}
