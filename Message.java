public class Message {
    private int id;
    private String content;
    private boolean reported;
    public String channelName;
    public Message next;

    public Message(String content, String channelName, int id) {
        this.content = content;
        this.channelName = channelName;
        this.id = id;
        this.reported = false;
        this.next = null;
    }

    public void report() {
        this.reported = true;
    }

    public boolean isReported() {
        return reported;
    }

    public String getContent() {
        return content;
    }

    public void setNext(Message n) {
        this.next = n;
    }

    public int getID() {
        return id;
    }
}

