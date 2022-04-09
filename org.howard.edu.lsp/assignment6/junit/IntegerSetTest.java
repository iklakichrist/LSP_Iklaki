package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import integerset.IntegerSet;
import integerset.IntegerSetException;

public class IntegerSetTest {

    IntegerSet intSet = new IntegerSet();
    
    
    @Before
    public void setUp(){
        
        String str = "This will test the integerset class ";
        System.out.println(str);
        intSet.addItem(4);
        intSet.addItem(8);
        intSet.addItem(3);
        intSet.addItem(9);
        intSet.addItem(7);
        intSet.addItem(5);
    }

    @Test
    public void testRemove(){
        int val = 8;
        final int a = intSet.length();
        intSet.remove(val);
        final int b = intSet.length();
        assertNotEquals(a, b);
    }

    @Test
    public void testLength(){
        final int val = intSet.length();
        intSet.addItem(12);
        int k = intSet.length();
        assertNotEquals(k, val);
    }


    
    public void testLargest(){
        intSet.clear();
        int newLarge =  intSet.largest()+1;
        intSet.addItem(newLarge);
        assertEquals(newLarge, intSet.largest()); 
    }

    @Test
    public void testRemoveException() {

        IntegerSet intSet2 = new IntegerSet();
        intSet.clear();
        
        Exception e =assertThrows(IndexOutOfBoundsException.class, () -> 
            intSet.remove(1)
        );
        
        assertTrue(e.getClass().getName().contains("IndexOutOfBoundsException"));
    }

    @Test
    public void testLargestException() {

        IntegerSet intSet2 = new IntegerSet();
        intSet.clear();

        Exception e = assertThrows(NoSuchElementException.class, () -> intSet.largest());

        assertTrue(e.getClass().getName().contains("NoSuchElementException"));
    }

    @Test
    public void testSmallestException() {

        IntegerSet intSet2 = new IntegerSet();
        intSet.clear();

        Exception e = assertThrows(NoSuchElementException.class, () -> intSet.smallest());

        assertTrue(e.getClass().getName().contains("NoSuchElementException"));
    }

    @Test
    public void testSmallest(){
        final int small = intSet.smallest();
        intSet.addItem(small-1);
        assertFalse("Passed",(intSet.smallest() >small));
    } 

    @Test
    public void testClear(){
        final int l = intSet.length();
        intSet.clear();
        assertEquals(0, intSet.length());
    }

    @Test
    public void testIntersect(){
        ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(4,2,3,7,44,8,33,2,6));
        ArrayList<Integer> listd = new ArrayList<Integer>();
        intSet.intersect(listB);
        ArrayList<Integer> comPare = new ArrayList<>(Arrays.asList(4, 8, 3, 7));
        
        
        assertTrue(intSet.intersectAndUnionsetholder.containsAll(comPare) && comPare.size() == intSet.intersectAndUnionsetholder.size());
     }

     @Test
     public void testEquals(){
         ArrayList<Integer> listD = new ArrayList<>(Arrays.asList(4, 2, 3, 7, 44, 8, 33, 2, 6));
         ArrayList<Integer> listC = new ArrayList<>(Arrays.asList(4, 3, 7 , 8, 9, 5));
         assertFalse(intSet.equal(listD));
         assertTrue(intSet.equal(listC));
         
     }

     @Test
     public void testDiffrenceTakesSetOfLengthGreaterThanZero(){
         ArrayList<Integer> listC = new ArrayList<>(Arrays.asList(4, 3, 7, 8, 9, 5));
         intSet.diffrence(listC);
         assertTrue(listC.size() > 0);
     }

     @Test
     public void testDiffrence(){
         ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(4, 3, 7, 8, 2, 6));
         final ArrayList<Integer> listd = new ArrayList<Integer>(intSet.set);

         intSet.diffrence(listB);
         assertFalse(listd == intSet.set);
         assertTrue(listd.size() > intSet.length());
     } 

     @Test
     public void testUnionTakesSetOfLengthGreaterThanZero() {
         ArrayList<Integer> listC = new ArrayList<>(Arrays.asList(4, 3, 7, 8, 9, 5));
         intSet.union(listC);
         assertTrue(listC.size() > 0);
     }

     @Test
     public void testUnion(){
         ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(4, 3, 7, 8, 2, 6));
         final ArrayList<Integer> listd = new ArrayList<Integer>(intSet.set);

         intSet.union(listB);
         assertFalse(intSet.intersectAndUnionsetholder.size() > intSet.length());
         
     }

     @Test
     public void testContains(){
         int x = 12;
         assertFalse(intSet.contains(x));
     }

     @Test
     public void testAddItemIncreaseSizeByOne(){
         final int v = intSet.length();
         intSet.addItem(13);
         assertTrue((intSet.length()-1)== v);
         assertFalse(intSet.length() == v);
     }

     @Test 
     public void testAddTakesonlyintegers(){
         Integer i = 3;
         intSet.addItem(i);
         assertTrue((i.getClass().getName().contains("Integer")) || (i.getClass().getName().contains("int")));
     }
     @Test
     public void testToString(){
         ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(4, 3, 7, 8, 2, 6));
         String b = intSet.toString(listB);
         assertNotNull(b);
     }

     @Test 
     public void testIsEmpty(){
         ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(4, 3, 7, 8, 2, 6));
         boolean f = intSet.isEmpty(listB);
         assertFalse(f);
     }


}
