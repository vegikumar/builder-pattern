
public class Message {

    private final MessageType messageType;
    private final String content;
    private final String sender;
    private final String recipient;
    private final boolean isDelivered;
    private final long timestamp;

    private Message(MessageBuilder builder) {
        this.messageType = builder.messageType;
        this.content = builder.content;
        this.sender = builder.sender;
        this.recipient = builder.recipient;
        this.isDelivered = builder.isDelivered;
        this.timestamp = builder.timestamp;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public static class MessageBuilder {

        private final MessageType messageType;
        private final String content;
        private final String sender;
        private final String recipient;
        private boolean isDelivered;
        private long timestamp;

        public MessageBuilder(
                MessageType messageType,
                String content,
                String sender,
                String recipient) {
            this.messageType = messageType;
            this.content = content;
            this.sender = sender;
            this.recipient = recipient;
            this.isDelivered = false;
            this.timestamp = 0L;
        }

        public MessageBuilder isDelivered(boolean isDelivered) {
            this.isDelivered = isDelivered;
            return this;
        }

        public MessageBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
