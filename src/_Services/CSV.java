package _Services;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public static List<String[]> returnData(Integer path) throws IOException {
        List<String[]> data = new ArrayList<>();
        String filepath;
        switch(path){
            case 1: filepath = "C:\\Users\\Gingy\\IdeaProjects\\RecipeApp\\src\\Data\\UserData.csv";
                break;
            case 2: filepath = "C:\\Users\\Gingy\\IdeaProjects\\RecipeApp\\src\\Data\\Recipes.csv";
                break;
            default:
                System.out.println("didnt make it");
                return data;
        }

        BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
        String row="";
        System.out.println("loop");
        while (true){
            try {
                if (((row = csvReader.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] rowdata = new String[0];
            rowdata = row.split(",");
            System.out.println("lets add:");
            System.out.println(row);
            data.add(rowdata);
        }
        csvReader.close();

        return data;
    }

    public boolean AddUser(String Username, String Password) throws IOException {
        List<String[]> data = new ArrayList<>();
        data = returnData(1);
        String[] element = data.get(data.size()-1);
        String id = element[0];
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                //user already in database
                return false;
            }
        }
        String[] userData = {id, Username, Password};
        data.add(userData);
        //return true if worked
        return true;
    }

    public boolean RemoveUser(String Username, String Password) throws IOException{
        List<String[]> data = new ArrayList<>();
        data = returnData(1);
        String[] element = data.get(data.size()-1);
        String id = element[0];
        String[] userData = {id, Username, Password};
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                data.remove(userData);
                return true;
            }
        }
        return false;
    }

    public boolean CheckPassword(String Username, String Password) throws IOException {
        List<String[]> data = new ArrayList<>();
        data = returnData(1);
        String[] element = data.get(data.size()-1);
        String id = element[0];
        String[] userData = {id, Username, Password};
        for (String[] checkData : data) {
            if (checkData[1].equals(Username)) {
                return checkData[2].equals(Password);
            }
        }
        //user doesnt exist
        return false;
    }


}


