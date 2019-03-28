public class MessagePrinter {

    MessageProducer messageProducer;
    public MessagePrinter(MessageProducer messageProducer)
    {
        this.messageProducer= messageProducer;
    }

    public void printMessage(){
        System.out.println(messageProducer.getMessage());
    }
}
