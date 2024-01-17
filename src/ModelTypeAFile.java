import java.util.ArrayList;
import java.util.List;

public class ModelTypeAFile {

    private List <String>  typeString ;
    private  List<Integer> typeInteger;
    private  List <Float>   typeFloat ;


    public ModelTypeAFile(List<String> str) {
        typeString =  new ArrayList<>();
        typeInteger =  new ArrayList<>();
        typeFloat = new ArrayList<>();
        for(var item : str){
            if (item.matches("[0-9]+")){
                typeInteger.add( Integer.parseInt(item));
            }
            else if (item.matches("[0-9]+\\.[0-9]+")){
                typeFloat.add(Float.parseFloat(item));
            }
            else{
                typeString.add(item);
            }
        }
    }

    public List<String> getTypeString() {
        return typeString;
    }

    public List<Integer> getTypeInteger() {
        return typeInteger;
    }

    public List<Float> getTypeFloat() {
        return typeFloat;
    }

    @Override
    public String toString() {
        return "ModelTypeStringFile{" +
                "typeString=" + typeString +
                ", typeInteger=" + typeInteger +
                ", typeFloat=" + typeFloat +
                '}';
    }
}
