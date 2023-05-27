package HW9InterfaceCollection;

public interface Collection {

    boolean add(String o);

    boolean add(int index, String o);

    boolean delete(int index);

    boolean delete(String o);

    String get(int index);

    boolean contain(String o);

    boolean equals(MyCollection str);

    boolean clear();

    int size();
}
