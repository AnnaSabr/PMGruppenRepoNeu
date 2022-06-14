package tree;

public class Inorder implements Visitor {
    @Override
    public void visit(Node node) {
        if(node==null){
            return;
        }else{
            this.visit(node.getLeftChild());
            System.out.println("Name: " + node.getData().getName() + " Preis: " + node.getData().getPrice());
            this.visit(node.getRightChild());
        }

    }
}
