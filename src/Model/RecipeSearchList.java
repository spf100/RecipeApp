package Model;

import java.util.List;

public class RecipeSearchList {
    private List<String[]> list;

    public RecipeSearchList(){

    }
    public RecipeSearchList(List<String[]> list){
        this.list = list;
    }

    public void setList(List<String[]> list){
        this.list = list;
    }
    public List<String[]> getList(){
        return this.list;
    }
    public String[] getArray(int i){return this.list.get(i);}
    public String getIndex(int i, int j){return this.list.get(i)[j];}
    public Integer size(){return this.list.size();}
}
