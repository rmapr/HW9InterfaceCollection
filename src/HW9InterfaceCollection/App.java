package HW9InterfaceCollection;

public class App {
    public static MyCollection myCollection;

    public static void main(String[] args) {
        myCollection = new MyCollection(5);
        CollectionServiceImpl collectionServiceImpl = new CollectionServiceImpl();
        int ind;
        String str;
        System.out.println(myCollection);

        if (collectionServiceImpl.add("Red")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        if (collectionServiceImpl.add("Green")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        if (collectionServiceImpl.add("Blue")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        MyCollection myCollection1 = new MyCollection();
        myCollection1.setArrayStr(new String[]{"Red", "Green", "blue", "null", "null"});
        myCollection1.setCount(3);
        System.out.println("\nПорівняння колекцій.\nКолекція 1\n" + myCollection1);
        System.out.println("Моя колекція\n" +myCollection);

        if (collectionServiceImpl.equals(myCollection1)){
            System.out.println("Колекції рівні");
        } else {
            System.out.println("Колекції не рівні");
        }

        if (collectionServiceImpl.add("Orange")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        if (collectionServiceImpl.add("Black")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        System.out.println("\nМасив до вставки: " + myCollection);
        ind = 1;
        str = "Yellow";
        if (collectionServiceImpl.add(ind, str)) System.out.println("Add successfully. Індекс " + ind + " значення: " + str);
        else System.out.println("Add not successfully");
        System.out.println("Масив після вставки: " + myCollection);

        if (collectionServiceImpl.add("Gray")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");
        System.out.println(myCollection);

        System.out.println("\nМасив до вставки: " + myCollection);
        ind = 5;
        str = "Add 5";
        if (collectionServiceImpl.add(ind, str)) System.out.println("Add successfully. Індекс " + ind + " значення: " + str);
        else System.out.println("Add not successfully");
        System.out.println("Масив після вставки: " + myCollection);

        if (collectionServiceImpl.add("RedGreen")) System.out.println("Add successfully");
        else System.out.println("Add not successfully");

        ind = 6;
        if (collectionServiceImpl.delete(ind)) {
            System.out.println("\nDelete index " + ind + " successfully");
            System.out.println("Масив після видалення: " + myCollection);
        } else System.out.println("Delete not successfully");

        str = "Red";
        if (collectionServiceImpl.delete(str)) {
            System.out.println("\nDelete value " + str + " successfully");
            System.out.println("Масив після видалення: " + myCollection);
        } else System.out.println("Delete not successfully");

        System.out.println(collectionServiceImpl.get(3));
        System.out.println(myCollection);

        str = "green";
        if (collectionServiceImpl.contain(str)) {
            System.out.println("\nЗначення " + str + " є в масиві");
        } else {System.out.println("\nЗначення " + str + " немає в масиві");}

        System.out.println("\nРозмір колекції: " + collectionServiceImpl.size());

        if (collectionServiceImpl.clear()) {System.out.println("\nКолекція очищена.");}
        System.out.println(myCollection);

    }
}
