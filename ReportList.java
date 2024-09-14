public class ReportList {
    private Message firstMessage;
    private Message lastMessage;

    public ReportList() {
        this.firstMessage = null;
        this.lastMessage = null;
    }

    public void enqueue(Message m) {
        if (firstMessage == null) {
            firstMessage = m;
            lastMessage = m;
        } else {
            lastMessage.setNext(m);
            lastMessage = m;
        }
    }

    public Message first() {
        return firstMessage;
    }

    public boolean empty() {
        return firstMessage == null;
    }

    public Message[] firstKReportedMessages(int k) {
        int count = 0;
        Message temp = firstMessage;

        while (temp != null && count < k) {
            count++;
            temp = temp.next;
        }

        Message[] mensajesReportados = new Message[count];
        temp = firstMessage;
        for (int i = 0; i < count; i++) {
            mensajesReportados[i] = temp;
            temp = temp.next;
        }

        return mensajesReportados;
    }
}