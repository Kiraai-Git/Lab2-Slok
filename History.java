public class History {
    private Message topMessage;

    public History(){
        this.topMessage = null;
    }

    public void push(Message m){
        if (topMessage == null) {
            topMessage = m;
        } else {
            Message temp = topMessage;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.setNext(m);
        }
    }

    public Message top(){
        return topMessage;
    }

    public boolean empty(){
        return topMessage == null;
    }

    public Message[] lastKMessages(int k) {
        int count = 0;
        Message temp = topMessage;

        while (temp != null && count < k) {
            count++;
            temp = temp.next;
        }

        Message[] mensajes = new Message[count];
        temp = topMessage;
        for (int i = 0; i < count; i++) {
            mensajes[i] = temp;
            temp = temp.next;
        }

        return mensajes;
    }
}
