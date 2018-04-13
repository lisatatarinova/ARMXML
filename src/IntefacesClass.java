import java.lang.reflect.Array;
import java.util.ArrayList;

public class IntefacesClass {
    String type_of_interface;
    String name_of_interface;
    boolean is_service;
    ArrayList <Object> data_elements;

    //если элемент начинается с -->, то это конец какого-то тега!!!


    public void setType_of_interface(){

        this.type_of_interface = type_of_interface;
    }

    public String getType_of_interface(){
        return type_of_interface;
    }

    public void setName_of_interface (String name_of_interface) {
        this.name_of_interface = name_of_interface;
    }

    public String getName_of_interface(){
        return  name_of_interface;
    }

    public void setIs_service (boolean is_service) {
        this.is_service = is_service;
    }

    public boolean isIs_service () {
        return is_service;
    }

    public void setData_elements (ArrayList<Object> data_elements) {
        this.data_elements = data_elements;
    }

    public ArrayList<Object> getData_elements (String name, ArrayList<Object> SN_DATA_DEF_PROPS, String Type_Tref, boolean is_queued) {
        return data_elements;
    }

    public static void main (String args[]){
        IntefacesClass type = new IntefacesClass();
        System.out.println(type.getType_of_interface());
    }
}
