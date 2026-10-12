package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class DataStore {

    
    public static void save(
            Universitysystem university,
            String fileName) throws IOException {

        try (
            FileOutputStream fileOutput =
                    new FileOutputStream(fileName);

            ObjectOutputStream objectOutput =
                    new ObjectOutputStream(fileOutput)
        ) {

     
            objectOutput.writeObject(university);
        }
    }


    public static Universitysystem load(
            String fileName)
            throws IOException, ClassNotFoundException {

        try (
            FileInputStream fileInput =
                    new FileInputStream(fileName);

            ObjectInputStream objectInput =
                    new ObjectInputStream(fileInput)
        ) {

     
            Object data = objectInput.readObject();


            if (data instanceof Universitysystem) {


                return (Universitysystem) data;
            }

  
            throw new IOException(
                    "Invalid university data file."
            );
        }
    }
}
