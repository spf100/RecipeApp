package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recipe {
    private String title;
    private String instructions;
    private ArrayList<String[]> ingredients;
    private String category;
    public Recipe(){

    }

    public Recipe(String title, String instructions, ArrayList<String[]> ingredients, String category){
        this.title = title;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.category = category;
    }
    public String getTitle(){return this.title;}
    public String getInstructions(){return this.instructions;}
    public ArrayList<String[]> getIngredients(){return this.ingredients;}
    public String getCategory(){return this.category;}

    public void setTitle(String title){this.title = title;}
    public void setInstructions(String instructions){this.instructions = instructions;}
    public void setCategory(String category){this.category = category;}
    public void setIngredients(ArrayList<String[]> ingredients){this.ingredients = ingredients;}


}

