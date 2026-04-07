package src;
import java.io.*;
import java.util.*;

class PersistenceService {

    private static final String FILE_NAME = "booking_data.ser";

    // SAVE data
    public void saveData(List<Reservation> history,
                         Map<String, Integer> inventory) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(history);
            oos.writeObject(inventory);

            System.out.println("Data saved successfully ✅");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // LOAD data
    public Object[] loadData() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            List<Reservation> history =
                    (List<Reservation>) ois.readObject();

            Map<String, Integer> inventory =
                    (Map<String, Integer>) ois.readObject();

            System.out.println("Data loaded successfully ✅");

            return new Object[]{history, inventory};

        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return null;
    }
}