public class Channel {
    public String name;
    private Message headMessage;
    public Channel next;

    public Channel(String name) {
        this.name = name;
        this.headMessage = null;
        this.next = null;
    }

    public void appendMessage(Message m) {
        if (headMessage == null) {
            headMessage = m;
        } else {
            Message temp = headMessage;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.setNext(m);
        }
    }

    public boolean empty() {
        return headMessage == null;
    }

    public void setNext(Channel c) {
        this.next = c;
    }

    public Message search(int id) {
        Message temp = headMessage;
        while (temp != null) {
            if (temp.getID() == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Message getHead() {
        return headMessage;
    }
}