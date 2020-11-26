package framework;

import framework.annotations.Test;

public class MyItemsTest {

    private SimpleList<Integer> simpleList;

    public void noAnnotationTest() {
        System.out.println("it is fake: no @Test");
    }

    @SuppressWarnings("")
    public void fakeAnnotationTest() {
        System.out.println("it is fake: no @Test");
    }

    @Test
    public void argumentsExistsTest(int a, int b) {
        System.out.println("it is fake: arguments exists");
    }

    @Test
    private void privateModifierTest() {
        System.out.println("it is fake: private modifier");
    }

    @Test
    public int returnNotVoidTest() {
        System.out.println("it is fake: do not return void");
        return 0;
    }

    @Test
    public void failTest() {
        simpleList = new SimpleList<>();
        simpleList.add(1).add(2).add(3);
        Assert.assertTrue(simpleList.size() == Integer.MAX_VALUE);
    }

    @Test
    public void exceptionBeforeAssertionTest() {
        simpleList.add(1).add(2).add(3);
        Assert.assertTrue(simpleList.size() == Integer.MAX_VALUE);
    }

    @Test
    @SuppressWarnings("")
    public void passTest() {
        simpleList = new SimpleList<>();
        simpleList.add(1).add(2).add(3).remove(3).remove(2).remove(1);
        Assert.assertTrue(simpleList.size() == 0);
    }

}
