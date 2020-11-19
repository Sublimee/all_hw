import java.util.ArrayList;

class SimpleList<E> {

    private final ArrayList<E> arrayList;

    SimpleList() {
        arrayList = new ArrayList<>();
    }

    int size() {
        return arrayList.size();
    }

    SimpleList<E> add(E e) {
        arrayList.add(e);
        return this;
    }

    SimpleList<E> remove(E e) {
        arrayList.remove(e);
        return this;
    }

}
