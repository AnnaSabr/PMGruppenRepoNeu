package tree;

public interface Visitor {

    /**
     * Methode um eine Operation auf der Node durchzuführen
     *
     * @param node
     */
    void visit(Node node);
}
