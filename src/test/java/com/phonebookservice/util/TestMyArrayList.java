package test.java.com.phonebookservice.util;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.util.MyArrayList;

public class TestMyArrayList {

    /**
     * test add in list.
     */
    @Test
    public void testAddFromList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertEquals(1, stringList.size());
    }

    /**
     * test add larget size list.
     */
    @Test
    public void testAddLargerSizeList() {
        final MyArrayList<String> stringList = new MyArrayList<String>(10);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        Assertions.assertEquals(TestSetUpUtil.TEST_ARRAY_SIZE_12,
                stringList.size());
    }

    /**
     * test get in list.
     */
    @Test
    public void testGetFromList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                stringList.get(0));
    }

    /**
     * test get in list.
     */
    @Test
    public void testGetOutOfBoundFromList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.get(1);
        });
    }

    /**
     * test clear list.
     */
    @Test
    public void testClearList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.clear();
        Assertions.assertEquals(0, stringList.size());
    }

    /**
     * test contains in list.
     */
    @Test
    public void testContainsList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertTrue(
                stringList.contains(TestSetUpUtil.TEST_STRING_VALUE1));
    }

    /**
     * test is not empty list.
     */
    @Test
    public void testIsNotEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertFalse(stringList.isEmpty());
    }

    /**
     * test is empty list.
     */
    @Test
    public void testIsEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        Assertions.assertTrue(stringList.isEmpty());
    }

    /**
     * test set list.
     */
    @Test
    public void testSetList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                stringList.get(1));
        stringList.set(1, TestSetUpUtil.TEST_STRING_VALUE4);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE4,
                stringList.get(1));
    }

    /**
     * test to array.
     */
    @Test
    public void testToArray() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        final Object[] arrayResult = stringList.toArray();
        Assertions.assertEquals(2, arrayResult.length);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                arrayResult[0]);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                arrayResult[1]);
    }

    /**
     * test to array list.
     */
    @Test
    public void testToArrayList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final String[] arrayList = new String[TestSetUpUtil.TEST_ARRAY_SIZE_3];
        arrayList[0] = TestSetUpUtil.TEST_STRING_VALUE2;
        arrayList[1] = TestSetUpUtil.TEST_STRING_VALUE3;
        arrayList[2] = TestSetUpUtil.TEST_STRING_VALUE4;
        final Object[] arrayResult = stringList.toArray(arrayList);
        Assertions.assertEquals(TestSetUpUtil.TEST_ARRAY_SIZE_3,
                arrayResult.length);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                arrayResult[0]);
        Assertions.assertNull(arrayResult[1]);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE4,
                arrayResult[2]);
    }

    /**
     * test to array with list have larger size than array.
     */
    @Test
    public void testToArrayWithListSizeLarger() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        final String[] arrayList = new String[2];
        arrayList[0] = TestSetUpUtil.TEST_STRING_VALUE2;
        final Object[] arrayResult = stringList.toArray(arrayList);
        Assertions.assertEquals(2, arrayResult.length);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                arrayResult[0]);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE3,
                arrayResult[1]);
    }

    /**
     * test index of existing index in list.
     */
    @Test
    public void testIndexOfExisitngIndexList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);

        Assertions.assertEquals(1,
                stringList.indexOf(TestSetUpUtil.TEST_STRING_VALUE2));
    }

    /**
     * test index of non-existing index in list.
     */
    @Test
    public void testIndexOfNonExisitngIndexList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertEquals(-1,
                stringList.indexOf(TestSetUpUtil.TEST_STRING_VALUE4));
    }

    /**
     * test last index of list.
     */
    @Test
    public void testLastIndexOfExisitngIndexList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);

        Assertions.assertEquals(TestSetUpUtil.TEST_ARRAY_SIZE_5,
                stringList.lastIndexOf(TestSetUpUtil.TEST_STRING_VALUE2));
    }

    /**
     * test last index of non existing index list.
     */
    @Test
    public void testLastIndexOfNonExisitngIndexList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);

        Assertions.assertEquals(-1,
                stringList.lastIndexOf(TestSetUpUtil.TEST_STRING_VALUE4));
    }

    /**
     * test sub list.
     */
    @Test
    public void testSubList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);

        final List<String> result = stringList.subList(1, 4);

        Assertions.assertEquals(TestSetUpUtil.TEST_ARRAY_SIZE_3, result.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                result.get(0));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE3,
                result.get(1));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                result.get(2));
    }
}
