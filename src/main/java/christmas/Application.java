package christmas;

import dto.Receipt;
import model.CalculatorTotalCost;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.greetMessageOutputter();
        Receipt receipt = new Receipt(inputView.dateInputter(), inputView.menuInputter());
        outputView.benefitsPreviewOutputter(receipt);
        outputView.totalOrderOutputter(receipt);
        outputView.totalAmountBeforeDiscountOutputter(receipt);
        outputView.giveAwayOutputter(receipt);
        outputView.benefitDetailsOutputter(receipt);
        outputView.totalBenefitAmountOutputter(receipt);
        outputView.estimatedPaymentAmountAfterDiscount(receipt);
        outputView.BadgeOutputter(receipt);
    }
}
