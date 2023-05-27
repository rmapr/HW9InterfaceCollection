package HW9InterfaceCollection;

import java.util.Arrays;

public class MyCollection {
    private String[] arrayStr;
    private int count;

    public MyCollection() {
    }

    public MyCollection(int countStr) {
        this.arrayStr = new String[countStr];
        this.count = 0;
    }

    public String[] getArrayStr() {
        return arrayStr;
    }

    public void setArrayStr(String[] arrayStr) {
        this.arrayStr = arrayStr;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "arrayStr=" + Arrays.toString(arrayStr) +
                ", count=" + count +
                '}';
    }
}
