package HW9InterfaceCollection;

import static HW9InterfaceCollection.App.myCollection;

public class CollectionServiceImpl implements Collection {
    @Override
    public boolean add(String value) {
        //Якщо список пустий додаємо з індексом 0
        int count = myCollection.getCount();
        String[] str = myCollection.getArrayStr();
        if (count == 0) {
            str[0] = value;
            count++;
            myCollection.setCount(count);
            System.out.println("\nЗначення " + value + " добавлено під індексом " + (count - 1));
            return true;
        }
        while (count < str.length) {
            str[count] = value;
            count++;
            myCollection.setCount(count);
            System.out.println("\nЗначення " + value + " добавлено під індексом " + (count - 1));
            return true;
        }
        if (count == str.length) {
            //Підготувати новий масив, переписати в нього все з першого
            myCollection.setArrayStr(createCopyFieldsOfArray(str));
            count = myCollection.getCount();
            str = myCollection.getArrayStr();
        }
        //продовжувати записувати
        str[count] = value;
        myCollection.setArrayStr(str);
        count++;
        myCollection.setCount(count);
        System.out.println("\nЗначення " + value + " добавлено під індексом " + (myCollection.getCount() - 1));
        return true;
    }

    @Override
    public boolean add(int index, String value) {
        int count = myCollection.getCount();
        String[] str = myCollection.getArrayStr();
        if (index > count && count != 0) {
            System.out.println("Індекс перевищує максимальний, добавляю слідом за останнім!");
            str[count] = value;
            myCollection.setArrayStr(str);
            count++;
            myCollection.setCount(count);
            return true;
        }
        //Якщо список пустий додаємо з індексом 0
        if (count == 0) {
            System.out.println("Масив пустий, добавляю з індексом 0!");
            str[0] = value;
            myCollection.setArrayStr(str);
            count++;
            myCollection.setCount(count);
            return true;
        }
        if ((count) == str.length) {
            //Підготувати новий масив, переписати в нього все з першого
            myCollection.setArrayStr(createCopyFieldsOfArray(myCollection.getArrayStr()));
            count = myCollection.getCount();
            str = myCollection.getArrayStr();
        }
        //Скопіювали
        for (int i = count; i > index; i--) {
            str[i] = str[i - 1];
        }
        //записали з індексом
        str[index] = value;
        myCollection.setArrayStr(str);
        count++;
        myCollection.setCount(count);
        return true;
    }

    @Override
    public boolean delete(int index) {
        int count = myCollection.getCount();
        String[] str = myCollection.getArrayStr();
        if ((index > count) || (index < 0)) {
            System.out.println("\nІндекс " + index + " виходить за границі. Максимальний індекс не null " +
                    (count - 1));
            return false;
        }
        //Скопіювали
        for (int i = index; i < count; i++) {
            str[i] = str[i + 1];
        }
        count--;
        myCollection.setArrayStr(str);
        myCollection.setCount(count);
        return true;
    }

    @Override
    public boolean delete(String value) {
        int count = myCollection.getCount();
        String[] str = myCollection.getArrayStr();
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (str[i].equalsIgnoreCase(value)) {
                index = i;
            }
        }
        if (index == -1) return false;
            //Скопіювали
        else {
            for (int i = index; i < count; i++)
                str[i] = str[i + 1];
            count--;
            myCollection.setArrayStr(str);
            myCollection.setCount(count);
            return true;
        }
    }

    @Override
    public String get(int index) {
        String s;
        if ((index < myCollection.getCount()) && (index >= 0))
            s = "\nЕлемент масиву з індексом " + index + " є: " + myCollection.getArrayStr()[index];
        else s = "\nІндекс " + index + " виходить за границі. Максимальний індекс не null " +
                (myCollection.getCount() - 1);
        return s;
    }

    @Override
    public boolean contain(String o) {
        int i = 0;
//        String[] str = myCollection.getArrayStr();
        for (; i < myCollection.getCount(); i++) {
            if (myCollection.getArrayStr()[i].equalsIgnoreCase(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(MyCollection str) {
        if (myCollection.getCount() != str.getCount()) {
            return false;
        }
        int count = 0;
//        Колекції рівні, якщо кожен елемент масиву дорівнює і size
        for (int i = 0; i < myCollection.getCount(); i++) {
            if (myCollection.getArrayStr()[i].equalsIgnoreCase(str.getArrayStr()[i])) {
                count++;
            }
        }
        if (count == myCollection.getCount()) return true;
//Поясніть, будь ласка, на лекції, чому не вірно працює код нижче, він перевіряє ссилки?
//        if (myCollection.equals(str)) {
//            return true;
//        }
        return false;
    }

    @Override
    public boolean clear() {
        String[] str = myCollection.getArrayStr();
        if (myCollection.getCount() == 0) {
            return true;
        }
        for (int i = 0; i <= myCollection.getCount(); i++) {
            str[i] = null;
        }
        myCollection.setArrayStr(str);
        myCollection.setCount(0);
        return true;
    }

    @Override
    public int size() {
        return myCollection.getCount();
    }

    //    новий масив на 5 елементів більше
    private String[] createCopyFieldsOfArray(String[] source) {
        int newSize = (source.length * 3) / 2 + 1;
        String[] temp = new String[newSize];
//        System.arraycopy(source, 0, temp, 0, source.length);
        for (int i = 0; i < source.length; i++){
            temp[i] = source[i];
        }
        return temp;
    }

}
