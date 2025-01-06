import java.io.*;

public class SaveManager {
    public final String FILE_LOCATION = System.getProperty("user.dir") + "\\data\\savedata.txt";
    private final byte KEY = 'k';

    // saves player stats and the prompt they were last on
    public void saveData(Player player)
    {
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(FILE_LOCATION);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(player);

            out.close();
            file.close();

            System.out.println("Your data has been saved.");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            System.out.println("Could not save data.");
        }
    }

    // checks if player data exists, if so, return the deserialized player class, else null
    public Player getSaveData()
    {
        Player player = null;
        try
        {
            FileInputStream file = new FileInputStream(FILE_LOCATION);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            player = (Player) in.readObject();

            in.close();
            file.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Could not load save data. If this is your first time playing, ignore this message.");
        }

        return player;
    }
}
