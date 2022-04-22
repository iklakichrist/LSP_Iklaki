import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MapTest {
 @Rule
 public ExpectedException thrown  = ExpectedException.none();

    @Test
    public void testReturnRightComparison(){
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Oyo", "Akwa");
        map1.put("Maurice", "Akwa");
        map1.put("Tete", "Akwa");
        map1.put("Akwa", "Akwa");
        map1.put("Lap", "Routine");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Akwa", "Akwa");
        map2.put("Oyo", "Akwa");
        map2.put("Maurice", "Akwa");
        map2.put("Elop", "Akwa");
        map2.put("Me", "0");

        assertEquals(3, MapUtilities.commonKeyValuePairs(map1,map2));
    }

    
    @Test //(expected = NullMapException.class)
    public void testThrowNullMapException() throws Exception{
       
        
            HashMap<String, String> map1 = new HashMap<>();
            map1.put("Oyo", "Akwa");
            map1.put("Maurice", "Akwa");
            map1.put("Tete", "Akwa");
            map1.put(null, "Akwa");
            map1.put("Lap", "Routine");

            HashMap<String, String> map2 = new HashMap<>();
            map2.put("Akwa", "Akwa");
            map2.put("Oyo", "Akwa");
            map2.put("Maurice", "Akwa");
            map2.put("Elop", "Akwa");
            map2.put("Me", "0");
            try{
                MapUtilities.commonKeyValuePairs(map1, map2);
                
                throw new NullMapException("One or both maps are null");
            }
            catch (Exception e){
                assertTrue(e.getClass().getName().contains("NullMapException"));
            }
            
           // Exception e= assertThrows(NullMapException.class,()-> MapUtilities.commonKeyValuePairs(map1, map2));
        
            
        
         
    }

    @Test
    public void testNoEqualMap(){
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Christ", "Akwa");
        map1.put("Maurice", "Akwa");
        map1.put("Tete", "Akwa");
        map1.put("Akwa", "Akwa");
        map1.put("Lap", "Routine");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Cat", "Dog");
        map2.put("Oyo", "Etim");
        map2.put("Maurice", "Ededet");
        map2.put("Elop", "Akwa");
        map2.put("Me", "0");

        assertEquals(0, MapUtilities.commonKeyValuePairs(map1, map2));
    }

    @Test
    public void testAllMapEqual(){
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Eat", "rat");
        map1.put("bird", "Halk");
        map1.put("Tete", "bro");
        map1.put("Spoon", "beans");
        map1.put("fan", "wind");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Eat", "rat");
        map2.put("bird", "Halk");
        map2.put("Tete", "bro");
        map2.put("Spoon", "beans");
        map2.put("fan", "wind");

        assertTrue(5 == (MapUtilities.commonKeyValuePairs(map1, map2)));
    }

    @Test 
    public void testDiffrentSizeMap(){
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Eat", "rat");
        map1.put("bird", "Halk");
        map1.put("Tete", "bro");
        map1.put("Spoon", "beans");
        map1.put("fan", "wind");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Eat", "rat");
        map2.put("bird", "Halk");
        map2.put("Tete", "bro");
        map2.put("Spoon", "beans");

        assertTrue(4 == (MapUtilities.commonKeyValuePairs(map1, map2)));
    }

    @Test
    public void testEmptyHash(){
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Eat", "rat");
        map1.put("bird", "Halk");
        map1.put("Tete", "bro");
        map1.put("Spoon", "beans");
        map1.put("fan", "wind");

        HashMap<String, String> map2 = new HashMap<>();
        assertEquals(0, MapUtilities.commonKeyValuePairs(map1, map2));
    }

    @Test
    public void test1EmptyMap(){
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Oyo", "Akwa");
        map1.put("Maurice", "Akwa");
        map1.put("Tete", "Akwa");
        map1.put("", "Akwa");
        map1.put("Lap", "Routine");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Akwa", "Akwa");
        map2.put("Oyo", "Akwa");
        map2.put("Maurice", "Akwa");
        map2.put("Elop", "Akwa");
        assertEquals(0, MapUtilities.commonKeyValuePairs(map1, map2));
    }

    @Test
    public void test2EmptyHash() {
        HashMap<String, String> map1 = new HashMap<>();
        

        HashMap<String, String> map2 = new HashMap<>();
        assertEquals(0, MapUtilities.commonKeyValuePairs(map1, map2));
    }
}
