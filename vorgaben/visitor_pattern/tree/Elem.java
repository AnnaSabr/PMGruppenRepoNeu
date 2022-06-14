package tree;

public interface Elem {

    /**
     * ruft visit auf dem Visitor Parameter auf
     *
     * @param visitor
     */
    void accept(Visitor visitor);
}
