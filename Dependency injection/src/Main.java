public class Main {

    public static void main(String[] args) {

        MessageProducer fileProducer = new FileMessageProducer();
        MessagePrinter filePrinter = new MessagePrinter(fileProducer);
        filePrinter.printMessage();

        MessageProducer simpleProducer = new SimpleMessageProducer();
        MessagePrinter printer = new MessagePrinter(simpleProducer);
        printer.printMessage();
    }
}
