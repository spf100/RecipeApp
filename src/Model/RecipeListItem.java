package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecipeListItem {
    private String title;
    private String category;
    private ArrayList<String> ingredients;

    public RecipeListItem(){

    }
    public RecipeListItem(String title, String category, ArrayList<String> ingredients){
        this.category = category;
        this.title = title;
        this.ingredients = ingredients;
    }

    public String getTitle(){return this.title;}
    public String getCategory(){return this.category;}
    public ArrayList<String> getIngredients(){return this.ingredients;}

    public void setTitle(String title){this.title = title;}
    public void setCategory(String category){this.category = category;}
    public void setIngredients(ArrayList<String> ingredients){this.ingredients = ingredients;}
}
