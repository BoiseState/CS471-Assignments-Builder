package edu.boisestate.cs.cs471assignmentsbuilder;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Main class of the application
 */
public class MainApp
{
    private static final String FILE_NAME_JAR = "build/libs/CS471-Assignments-Builder-1.0.jar";
    private static final String DEFAULT_FILE_NAME_REPOSITORY_DATA_JSON = "src/main/resources/SampleRepositoryData.json";

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Hello world!");

        //we want to use Google's JSON library for Java called Gson
        //this code should generate a compilation error if the Gson library is not configured correctly
        Gson gson = new Gson();


        String fileNameWithRepositoryDataJSON = null;
        switch (args.length)
        {
            case 0:
                fileNameWithRepositoryDataJSON = DEFAULT_FILE_NAME_REPOSITORY_DATA_JSON;
                break;
            case 1:
                fileNameWithRepositoryDataJSON = args[0];
                break;
            default:
                printUsage("Invalid number of arguments");
                System.exit(1);
        }

        RepositoryData repositoryData = parseAndLoadRepositoryDataFromJSON(fileNameWithRepositoryDataJSON);
        System.out.println("Loaded repository data:\n" + repositoryData);
    }

    private static RepositoryData parseAndLoadRepositoryDataFromJSON(String fileNameWithRepositoryDataJSON) throws FileNotFoundException
    {
        System.out.println("Started parsing repository data file '" + fileNameWithRepositoryDataJSON + "'");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameWithRepositoryDataJSON));

        // Creates a Gson instance to load data from a JSON file
        Gson gson = new Gson();

        // this is where the magic happens:
        // gson uses reflection to initialize all the fields in the RepositoryData class and
        // in all the classes it references (e.g., Repository, Owner, Issue, Comment)
        RepositoryData repositoryData = gson.fromJson(bufferedReader, RepositoryData.class);

        System.out.println("Done parsing repository data file '" + fileNameWithRepositoryDataJSON + "'");

        return repositoryData;
    }

    private static void printUsage(String errorMessasge)
    {
        System.err.println(errorMessasge);
        System.err.println("Usage:");
        System.err.println("  java -jar " + FILE_NAME_JAR + " [<fileNameWithRepositoryData.json>]");
        System.err.println();
        System.err.println("Where:");
        System.err.println("  [<fileNameWithRepositoryData.json>]");
        System.err.println("    - is a repository data file in json format");
        System.err.println("    - this is an optional parameter");
        System.err.println("    - if no repository data file is specified, the default \"" + DEFAULT_FILE_NAME_REPOSITORY_DATA_JSON + "\" is attempted to be loaded");
        System.err.println();
        System.err.println("Example:");
        System.err.println("  ./gradlew jar");
        System.err.println("  java -jar " + FILE_NAME_JAR + " " + DEFAULT_FILE_NAME_REPOSITORY_DATA_JSON);
    }

}
