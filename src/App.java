import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        List<TaxPayer> contribuintes = new ArrayList<TaxPayer>();
        int quantidade;

        System.out.print("Quantos contribuintes você vai digitar? ");
        quantidade = sc.nextInt();

        for (int i = 1; i <= quantidade; i++) {
            double capitalIncome, educationSpending, healthSpending,
                    salaryIncome, serviceIncome;

            System.out.printf("\nDigite os dados do %do contribuinte:", i);
            System.out.print("\nRenda anual com salário: ");
            salaryIncome = sc.nextDouble();

            System.out.print("Renda anual com prestação de serviço: ");
            serviceIncome = sc.nextDouble();

            System.out.print("Renda anual com ganho de capital: ");
            capitalIncome = sc.nextDouble();

            System.out.print("Gastos médicos: ");
            healthSpending = sc.nextDouble();

            System.out.print("Gastos educacionais: ");
            educationSpending = sc.nextDouble();

            contribuintes.add(
                    new TaxPayer(capitalIncome, educationSpending, healthSpending,
                            salaryIncome, serviceIncome));
        }

        for (int i = 1; i <= quantidade; i++) {
            System.out.printf("\nResumo do %do contribuinte:", i);
            System.out.printf("\nImposto bruto total: %.2f", contribuintes.get(i - 1).grossTax());
            System.out.printf("\nAbatimento: %.2f", contribuintes.get(i - 1).taxRebate());
            System.out.printf("\nImposto devido: %.2f", contribuintes.get(i - 1).netTax());

            if (i < quantidade)
                System.out.println();
        }

        sc.close();

    }
}
