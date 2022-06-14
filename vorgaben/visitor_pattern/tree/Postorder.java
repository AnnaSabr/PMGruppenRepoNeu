package tree;

public class Postorder implements Visitor {
    @Override
    public void visit(Node node) {
        if(node==null){
            return;
        }else{
            this.visit(node.getLeftChild());
            this.visit(node.getRightChild());
            System.out.println("Name: " + node.getData().getName() + " Preis: " + node.getData().getPrice());
        }
    }
}
