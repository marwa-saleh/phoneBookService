package test.java.com.phonebookservice.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.util.MyArrayList;

public class TestMyArrayList {

    /**
     * test initialize list with negative value.
     */
    @Test
    public void testInitalizeListWithNegativeValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new MyArrayList<String>(-5);
        });
    }

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
     * test add larger size list.
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
     * test add larger size list by index.
     */
    @Test
    public void testAddLargerSizeListByIndex() {
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
        stringList.add(10, TestSetUpUtil.TEST_STRING_VALUE1);
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
     * test not contains in list.
     */
    @Test
    public void testNotContainsList() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertFalse(
                stringList.contains(TestSetUpUtil.TEST_STRING_VALUE2));
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
    public void testToArrayListWithEqualSize() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final String[] arrayList = new String[1];
        arrayList[0] = TestSetUpUtil.TEST_STRING_VALUE2;
        final Object[] arrayResult = stringList.toArray(arrayList);
        Assertions.assertEquals(1, arrayResult.length);
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                arrayResult[0]);
    }

    /**
     * test to array with list have smalller size than array.
     */
    @Test
    public void testToArrayListWithListSizeSmaller() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        final String[] arrayList = new String[1];
        arrayList[0] = TestSetUpUtil.TEST_STRING_VALUE2;
        final Object[] arrayResult = stringList.toArray(arrayList);
        Assertions.assertNotNull(arrayResult);
        Assertions.assertNull(arrayResult[0]);

    }

    /**
     * test to array with list have larger size than array.
     */
    @Test
    public void testToArrayWithListSizeLarger() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        final String[] arrayList = new String[1];
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
     * test index of null value in list.
     */
    @Test
    public void testIndexOfNullValue() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(null);
        stringList.add(null);

        Assertions.assertEquals(1, stringList.indexOf(null));
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
     * test last index of list.
     */
    @Test
    public void testLastIndexOfNullElement() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(null);
        stringList.add(null);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertEquals(2, stringList.lastIndexOf(null));
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

    /**
     * test sub list with toIndex out of bound.
     */
    @Test
    public void testSubListWithToIndexOutOfBound() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.subList(1, 4);
        });
    }

    /**
     * test sub list with fromIndex greater than toIndex.
     */
    @Test
    public void testSubListWithFromIndexGreaterThanToIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringList.subList(3, 1);
        });
    }

    /**
     * test sub list with fromIndex equal than toIndex.
     */
    @Test
    public void testSubListWithFromIndexEqualThanToIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        final List<String> result = stringList.subList(1, 1);
        Assertions.assertEquals(0, result.size());
    }

    /**
     * test sub list with negative fromIndex.
     */
    @Test
    public void testSubListWithNegativeFromIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.subList(-1, 1);
        });

    }

    /**
     * test remove object.
     */
    @Test
    public void testRemoveObject() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE4);

        Assertions.assertTrue(
                stringList.remove(TestSetUpUtil.TEST_STRING_VALUE2));
        Assertions.assertEquals(3, stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                stringList.get(0));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE3,
                stringList.get(1));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE4,
                stringList.get(2));
    }

    /**
     * test remove null object.
     */
    @Test
    public void testRemoveNullObject() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(null);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertTrue(stringList.remove(null));
        Assertions.assertEquals(2, stringList.size());
    }

    /**
     * test remove non exist object.
     */
    @Test
    public void testRemoveNonExistObject() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertFalse(
                stringList.remove(TestSetUpUtil.TEST_STRING_VALUE2));
        Assertions.assertEquals(2, stringList.size());
    }

    /**
     * test remove by index.
     */
    @Test
    public void testRemoveIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                stringList.remove(1));
        Assertions.assertEquals(2, stringList.size());
    }

    /**
     * test add by index.
     */
    @Test
    public void testAddByIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(1, TestSetUpUtil.TEST_STRING_VALUE4);
        Assertions.assertEquals(TestSetUpUtil.TEST_ARRAY_SIZE_4,
                stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE4,
                stringList.get(1));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                stringList.get(2));
    }

    /**
     * test add null value by index.
     */
    @Test
    public void testAddNullValueByIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(1, null);
        Assertions.assertEquals(TestSetUpUtil.TEST_ARRAY_SIZE_4,
                stringList.size());
        Assertions.assertNull(stringList.get(1));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                stringList.get(2));
    }

    /**
     * test add negative value by index.
     */
    @Test
    public void testAddNegativeValueByIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.add(-1, null);
        });
    }

    /**
     * test add out of bound value by index.
     */
    @Test
    public void testAddOutOfBoundValueByIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.add(6, TestSetUpUtil.TEST_STRING_VALUE3);
        });
    }

    /**
     * test get by negative index.
     */
    @Test
    public void testGetByNegativeIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.get(-1);
        });
    }

    /**
     * test get by out of bound index.
     */
    @Test
    public void testGetByOutOfBoundIndex() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.get(6);
        });
    }

    /**
     * test add by index after last one.
     */
    @Test
    public void testAddByIndexAfterLastOne() {
        final MyArrayList<String> stringList = new MyArrayList<String>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(3, TestSetUpUtil.TEST_STRING_VALUE4);
        Assertions.assertEquals(TestSetUpUtil.TEST_ARRAY_SIZE_4,
                stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE4,
                stringList.get(3));
    }

    /**
     * test add all with list.
     */
    @Test
    public void testAddAllWithList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.addAll(stringList2));
        Assertions.assertEquals(3, stringList.size());
    }

    /**
     * test add all with big list.
     */
    @Test
    public void testAddAllWithBigList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        Assertions.assertTrue(stringList.addAll(stringList2));
        Assertions.assertEquals(13, stringList.size());
    }

    /**
     * test add all with set.
     */
    @Test
    public void testAddAllWithSet() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final Set<String> stringList2 = new HashSet<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.addAll(stringList2));
        Assertions.assertEquals(3, stringList.size());
    }

    /**
     * test add all with linked list.
     */
    @Test
    public void testAddAllWithQueue() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final Queue<String> stringList2 = new LinkedList<String>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.addAll(stringList2));
        Assertions.assertEquals(3, stringList.size());
    }

    /**
     * test add all with null list.
     */
    @Test
    public void testAddAllWithNullList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            stringList.addAll(null);
        });
    }

    /**
     * test add all with empty data list.
     */
    @Test
    public void testAddAllWithEmptyDataList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.addAll(stringList2));
        Assertions.assertEquals(2, stringList.size());
    }

    /**
     * test add all with empty list.
     */
    @Test
    public void testAddAllWithEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertFalse(stringList.addAll(new ArrayList<>()));
        Assertions.assertEquals(1, stringList.size());
    }

    /**
     * test add all with null value.
     */
    @Test
    public void testAddAllWithNullValue() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(null);
        Assertions.assertTrue(stringList.addAll(stringList2));
        Assertions.assertEquals(3, stringList.size());
    }

    /**
     * test add all with index with list.
     */
    @Test
    public void testAddAllWithIndexWithList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.addAll(0, stringList2));
        Assertions.assertEquals(3, stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                stringList.get(0));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                stringList.get(2));
    }

    /**
     * test add all with index with big list.
     */
    @Test
    public void testAddAllWithIndexWithBigList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        Assertions.assertTrue(stringList.addAll(1, stringList2));
        Assertions.assertEquals(13, stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE3,
                stringList.get(1));
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE2,
                stringList.get(12));
    }

    /**
     * test add all with index with null list.
     */
    @Test
    public void testAddAllWithIndexWithNullList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            stringList.addAll(0, null);
        });
    }

    /**
     * test add all with index out of bound.
     */
    @Test
    public void testAddAllWithIndexOutOfBound() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.addAll(1, stringList2);
        });
    }

    /**
     * test add all with index with empty list.
     */
    @Test
    public void testAddAllWithIndexWithEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertFalse(stringList.addAll(0, new ArrayList<>()));
        Assertions.assertEquals(1, stringList.size());
    }

    /**
     * test add all with index with null list.
     */
    @Test
    public void testAddAllWithIndexWithNullValue() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(null);
        Assertions.assertTrue(stringList.addAll(1, stringList2));
        Assertions.assertEquals(3, stringList.size());
    }

    /**
     * test remove all with different lists.
     */
    @Test
    public void testRemoveAllWithDifferentLists() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertFalse(stringList.removeAll(stringList2));
        Assertions.assertEquals(1, stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                stringList.get(0));
    }

    /**
     * test remove all with list.
     */
    @Test
    public void testRemoveAllWithList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE4);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.removeAll(stringList2));
        Assertions.assertEquals(2, stringList.size());
    }

    /**
     * test remove all with similar list.
     */
    @Test
    public void testRemoveAllWithSimilarList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.removeAll(stringList2));
        Assertions.assertEquals(0, stringList.size());
    }

    /**
     * test remove all with null value.
     */
    @Test
    public void testRemoveAllWithNullValue() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(null);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(null);
        Assertions.assertTrue(stringList.removeAll(stringList2));
        Assertions.assertEquals(1, stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                stringList.get(0));
    }

    /**
     * test remove all with null list.
     */
    @Test
    public void testRemoveAllWithNullList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            stringList.removeAll(null);
        });
    }

    /**
     * test remove all with empty list.
     */
    @Test
    public void testRemoveAllWithEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertFalse(stringList.removeAll(new ArrayList<>()));
        Assertions.assertEquals(1, stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                stringList.get(0));
    }

    /**
     * test retain all with different lists.
     */
    @Test
    public void testRetainAllWithDifferentLists() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE4);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.retainAll(stringList2));
        Assertions.assertEquals(1, stringList.size());
    }

    /**
     * test retain all with list.
     */
    @Test
    public void testRetainAllWithList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertFalse(stringList.retainAll(stringList2));
        Assertions.assertEquals(1, stringList.size());
        Assertions.assertEquals(TestSetUpUtil.TEST_STRING_VALUE1,
                stringList.get(0));
    }

    /**
     * test retain all with similar list.
     */
    @Test
    public void testRetainAllWithSimilarList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertFalse(stringList.retainAll(stringList2));
        Assertions.assertEquals(2, stringList.size());
    }

    /**
     * test retain all with null value.
     */
    @Test
    public void testRetainAllWithNullValue() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(null);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(null);
        Assertions.assertTrue(stringList.retainAll(stringList2));
        Assertions.assertEquals(1, stringList.size());
        Assertions.assertEquals(null, stringList.get(0));
    }

    /**
     * test retain all with null list.
     */
    @Test
    public void testRetainAllWithNullList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            stringList.retainAll(null);
        });
    }

    /**
     * test retain all with empty list.
     */
    @Test
    public void testRetainAllWithEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertTrue(stringList.retainAll(new ArrayList<>()));
        Assertions.assertEquals(0, stringList.size());
    }

    /**
     * test contains all with equal null value.
     */
    @Test
    public void testContainsAllWithEqualNullValue() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(null);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(null);
        Assertions.assertTrue(stringList.containsAll(stringList2));
    }

    /**
     * test contains all with same values.
     */
    @Test
    public void testContainsAllWithSameValues() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertTrue(stringList.containsAll(stringList2));
    }

    /**
     * test contains all with equal values.
     */
    @Test
    public void testContainsAllWithEqualValues() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        Assertions.assertTrue(stringList.containsAll(stringList2));
    }

    /**
     * test contains all with different values.
     */
    @Test
    public void testContainsAllWithDifferentValues() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        Assertions.assertFalse(stringList.containsAll(stringList2));
    }

    /**
     * test contains all with not equal value.
     */
    @Test
    public void testContainsAllWithNotEqualValue() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE4);
        Assertions.assertFalse(stringList.containsAll(stringList2));
    }

    /**
     * test contains all check with empty list.
     */
    @Test
    public void testContainsAllCheckWithEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertTrue(stringList.containsAll(new ArrayList<>()));
    }

    /**
     * test contains all with empty list.
     */
    @Test
    public void testContainsAllWithEmptyList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE2);
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE3);
        Assertions.assertFalse(stringList.containsAll(stringList2));
    }

    /**
     * test contains all check with null list.
     */
    @Test
    public void testContainsAllCheckWithNullList() {
        final MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            stringList.containsAll(null);
        });
    }

    /**
     * test contains all with null list.
     */
    @Test
    public void testContainsAllWithNullList() {
        final MyArrayList<String> stringList = null;
        final ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add(TestSetUpUtil.TEST_STRING_VALUE1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            stringList.containsAll(stringList2);
        });
    }
}
