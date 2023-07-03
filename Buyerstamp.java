import java.util.Scanner;
public class Buyerstamp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Prompt for the purchase price of the property.
    System.out.print("Enter the purchase price of the property (SGD): ");
    double purchasePrice = scanner.nextDouble();

    // Prompt for the type of the property
    System.out.print("Enter the property type (residential/non-residential): ");
    String propertyType = scanner.next();

    // Calculate the buyer's stamp duty.
    double bsd = calculateBSD(purchasePrice, propertyType);

    // Print the BSD.
    System.out.println("The Buyer'ss stamp Duty is $" + bsd);
  }

  private static double calculateBSD(double purchasePrice, String propertyType) {
    double bsd = 0.0;

    if (propertyType.equals("residential")) {
      if (purchasePrice < 180000) {
        bsd = purchasePrice * 0.01;
      } else if (purchasePrice <= 600000) {
        bsd = purchasePrice * 0.02;
      } else {
        bsd = purchasePrice * 0.03;
      }
    } else {
      if (purchasePrice < 180000) {
        bsd = purchasePrice * 0.015;
      } else if (purchasePrice <= 600000) {
        bsd = purchasePrice * 0.025;
      } else {
        bsd = purchasePrice * 0.035;
      }
    }

    return bsd;
  }
}
