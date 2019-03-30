package pl.javastart.beans;

public class MessagePrinter {

    private MessageProducer messageProducer;

    public MessagePrinter() {
    }

    public MessagePrinter(MessageProducer messageProducer)
    {
        this.messageProducer = messageProducer;
    }

    public void printMessage(){
        System.out.println(messageProducer.getMessage());
    }

    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
}
