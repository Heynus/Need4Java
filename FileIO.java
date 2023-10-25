import java.io.*;
import java.util.Scanner;

/**
* Utility Class to allow reading and writing to files
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class FileIO
{
    private String fileName;

    /**
     * Default constructor which creates the object of the class FileIO.
     *
     */
    public FileIO()
    {
        fileName = "unknown";
    }

    /**
     * Non-Default constructor which creates the object of the class FileIO.
     *
     * @param     fileName      Accepts the name of a file as a string.
     */
    public FileIO(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Display method to return the state of the object.
     *
     * @return              The state of the object as a string.
     */
    public String display()
    {
        return ("File Name " + fileName);
    }

    /**
     * Accessor method to get the name of the file.
     *
     * @return              The file name as a String.
     */
    public String getFileName()
    {
        return this.fileName;
    }

    /**
     * Mutator method to set the file name.
     *
     * @param   fileName       The file name as a String.
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Reads information from the file to the program.
     *
     * @return          A string representing the contents of the file.
     */
    public String readFile()
    {
        String readStr = "";
        if (this.fileName.trim().length()>0)
        {
            try
            {
                FileReader fileInput = new FileReader(this.fileName);
                Scanner scan = new Scanner(fileInput);
                while (scan.hasNextLine())
                {
                    readStr += scan.nextLine() + "\n";
                }
            }
            catch(Exception e)
            {
                System.out.println("Error reading file");
            }
        }
        else
            System.out.println("File Name Invalid");
        
        return readStr;
    }

    /**
     * Writes a String from the file to the file.
     *
     * @param     contents       A string provided by the program.
     */
    public void writeFile(String contents)
    {
        try
        {
            if(fileName.trim().length() > 0)
            {
                PrintWriter writer = new PrintWriter(this.fileName);
                writer.println(contents);
                writer.close();
            }
            else
                System.out.println("Please enter File Name");
        }
        catch(IOException e)
        {
            System.out.println("An error was encountered while trying to write to " + this.fileName + " file");
        }
    }

}




