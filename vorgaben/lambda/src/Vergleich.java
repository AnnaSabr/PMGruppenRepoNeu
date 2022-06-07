import java.util.Comparator;

public interface Vergleich<T> extends Comparator<T> {

    int compare(T type, T type2);
}
