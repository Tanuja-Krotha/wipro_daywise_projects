package com.wipro.day6.projects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileCopy 
{
    public static void main(String[] args) 
    {
        String sourcePath = "C:\\Users\\Tanuja\\OneDrive\\Pictures\\FilePicture\\p1.jpg";        
        String destinationPath = "C:\\Users\\Tanuja\\OneDrive\\Pictures\\p2.jpg";     

        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath))
        {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1)
            {
                fos.write(buffer, 0, bytesRead); 

            System.out.println("Image copied successfully!");

            } 
        }
            catch (IOException e) 
            {
            System.out.println("An error occurred while copying the image.");
            e.printStackTrace();
        }
    }
}

