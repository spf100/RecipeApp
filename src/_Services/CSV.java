package _Services;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CSV {
    /*
    60 columns in recipe CSV, if no data put "","","",
    Column order: Title, Directions, Quantity, Unit(measuring), Ingredient....repeat.....Category
    5 columns in User CSV
    Column order: ID, Username, Password, First name, Last name
     */
    //Return all data from CSV of choice
    public static List<String[]> returnData(Integer path) throws IOException {
        List<String[]> data = new ArrayList<>();
        String filepath;
        switch (path) {
            case 1:
                filepath = "C:\\Users\\Gingy\\IdeaProjects\\RecipeApp\\src\\Data\\UserData.csv";
                break;
            case 2:
                filepath = "C:\\Users\\Gingy\\IdeaProjects\\RecipeApp\\src\\Data\\Recipes.csv";
                break;
            default:
                //System.out.println("didnt make it");
                return data;
        }
        BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
        String row = "";
        while (true) {
            try {
                if (((row = csvReader.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] rowdata;
            rowdata = row.split(",");
            data.add(rowdata);
        }
        csvReader.close();
        return data;
    }

    //writer for csv of choice
    private static boolean WriteToCSV(Integer path, List<String[]> list) {
        String filepath;
        switch (path) {
            case 1:
                filepath = "C:\\Users\\Gingy\\IdeaProjects\\RecipeApp\\src\\Data\\UserData.csv";
                break;
            case 2:
                filepath = "C:\\Users\\Gingy\\IdeaProjects\\RecipeApp\\src\\Data\\Recipes.csv";
                break;
            default:
                ////System.out.println("didnt make it");
                return false;
        }
        try {
            PrintWriter writer = new PrintWriter(filepath);
            for (String[] row : list) {
                StringBuilder rowBuilder = new StringBuilder();
                for (String n : row) {
                    rowBuilder.append(n).append(',');
                }
                rowBuilder.deleteCharAt(rowBuilder.length() - 1);
                rowBuilder.append("\n");
                writer.write(String.valueOf(rowBuilder));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //overwrite entire csv
    public static boolean OverwriteCSV(Integer path, List<String[]> list) {
        return WriteToCSV(path, list);
    }

    //append to CSV
    public static boolean AddToCSV(Integer path, List<String[]> list) {
        List<String[]> oldData;
        try {
            oldData = returnData(path);
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Could not find old data");
            return false;
        }
        oldData.addAll(list);
        return WriteToCSV(path, oldData);
    }

    /*
    User Checks/Removes/Additions
     */

    public static boolean AddUser(String Username, String Password, String firstName, String lastName) throws IOException {
        //System.out.println("called");
        List<String[]> data;
        data = returnData(1);
        String[] element = data.get(data.size() - 1);
        String id = element[0];
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                //user already in database
                return false;
            }
        }
        String[] userData = {id, Username, Password, firstName, lastName};
        data.add(userData);
        return AddToCSV(1, data);
    }

    //remove user from csv
    public boolean RemoveUser(String Username) throws IOException {
        List<String[]> data;
        data = returnData(1);
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                data.remove(checkData);
                return OverwriteCSV(1, data);
            }
        }
        return false;
    }

    //check if password is correct for user
    public static boolean CheckPassword(String Username, String Password) throws IOException {
        List<String[]> data;
        data = returnData(1);
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                return checkData[2].equals(Password);
            }
        }
        //user doesnt exist
        return false;
    }

    //return all user data
    public static String[] returnUser(String Username) throws IOException {
        List<String[]> data;
        String[] nothing = {};
        data = returnData(1);
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                return checkData;
            }
        }
        return nothing;
    }

    //check if user exists
    public static boolean findUser(String Username) throws IOException {
        List<String[]> data;
        data = returnData(1);
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                return true;
            }
        }
        return false;
    }

    /*
    Recipe Checks/Removes/Additions
     */

    //check if recipe by title exists
    public static boolean CheckRecipe(String Title) throws IOException {
        List<String[]> data;
        data = returnData(2);
        for (String[] checkData : data) {
            if (checkData[0].equals(Title)) {
                return true;
            }
        }
        //user doesnt exist
        return false;
    }

    //return recipe information
    public static String[] GetRecipe(String Title) throws IOException {
        List<String[]> data;
        String[] array = new String[0];
        data = returnData(2);
        for (String[] checkData : data) {
            if (checkData[0].equals(Title)) {
                return checkData;
            }
        }
        //user doesnt exist
        return array;
    }

    //remove recipe from csv
    public static boolean RemoveRecipe(String Title) throws IOException {
        List<String[]> data;
        data = returnData(2);
        for (String[] checkData : data) {
            if (checkData[0].equals(Title)) {
                data.remove(checkData);
                return OverwriteCSV(2, data);
            }
        }
        return false;
    }

    //add recipe to csv
    public static boolean AddRecipe(String[] Recipe) throws IOException {
        if (CheckRecipe(Recipe[0])) {
            //needs new title
            return false;
        }
        List<String[]> data;
        data = returnData(2);
        data.add(Recipe);
        return AddToCSV(2, data);
    }

    public static List<String[]> SearchRecipes(String item) throws IOException {
        List<String[]> list;
        List<String[]> searchList = new ArrayList<>();
        list = returnData(2);
       // System.out.println("CHECK LIST SIZE");
       // System.out.println(list.size());
        int i = 0;
        for (String[] checkData : list) {
            if(i != 0){
               // System.out.println("CHECK ARRAY");
               // System.out.println(Arrays.toString(checkData));
               //System.out.println(checkData[0].toLowerCase());
                if(checkData[0].toLowerCase().contains(item.toLowerCase())){
                   // System.out.println("CHECK CHECKDATA");
                   // System.out.println(checkData[0]);
                    searchList.add(checkData);
                }
            }
            i++;

        }
       // System.out.println("CHECK SIZE OF LIST");
       // System.out.println(searchList.size());
        return searchList;
    }
}

