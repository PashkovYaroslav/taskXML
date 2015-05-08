import com.epam.pashkov.Bank;
import com.epam.pashkov.parsers.*;

/**
 * Created by Yaroslav_Pashkov on 5/6/2015.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("DomParser");
        for(Bank.Deposit deposit: DomParserXML.parse()){
            System.out.println(deposit);
        }

        System.out.println("\nJdomParser");
        for (Bank.Deposit deposit : JdomParserXML.parse()) {
            System.out.println(deposit);
        }

        System.out.println("\nSaxParser");
        for(Bank.Deposit deposit: SaxParserXML.parse()){
            System.out.println(deposit);
        }

        System.out.println("\nStAXParser");
        for(Bank.Deposit deposit: StAXParserXML.parse()){
            System.out.println(deposit);
        }

        System.out.println("\nJsonParser");
        for(Bank.Deposit deposit: ParserJSON.parse()){
            System.out.println(deposit);
        }

        System.out.println("\nJaxbParser");
        for(Bank.Deposit deposit: JaxbParserXML.parse()){
            System.out.println(deposit);
        }

        CreateJSONFile.create();

        ExcelHelper eh = new ExcelHelper();
        System.out.println(eh.getFullTable());
    }
}
