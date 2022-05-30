import operations.AOperationForCalculatorUI;
import operations.IOperation;

@AOperationForCalculatorUI("+")
public class AddOperation implements IOperation{

    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
    
}
