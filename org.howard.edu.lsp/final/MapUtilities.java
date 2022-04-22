
import java.util.HashMap;

public class MapUtilities {

    public static int  commonKeyValuePairs(HashMap<String,String> map1, HashMap<String,String> map2){
        try {
            int counter=0;
            if(map1.equals(map2)){
                return map1.size();
            }
            if(map1.size() <1 || map2.size() < 1){
                return 0;
            }
            for(String i : map1.keySet()){
                for(String j : map2.keySet()){
                    if (i==null || j == null || map1.get(i)==null || map2.get(j)==null) {
                        throw new NullMapException("One or both maps are null");
                    }
                    else if (i.isEmpty() || j.isEmpty() || map1.get(i).isEmpty() || map2.get(j).isEmpty()) {
                        return 0;
                    }
                    else if(i ==j && map1.get(i) == map2.get(i)) {
                        counter++;
                    }
                    
                }
                
            }
            return counter;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Oyo","Akwa");
        map1.put("Maurice", "Akwa");
        map1.put("Tete", "Akwa");
        map1.put("", "Akwa");
        map1.put("Lap", "Routine");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Akwa", "Akwa");
        map2.put("Oyo", "Akwa");
        map2.put("Maurice", "Akwa");
        map2.put("Elop", "Akwa");

        System.out.print(MapUtilities.commonKeyValuePairs(map1, map2) + " Maps Similar");
    }
    
}


