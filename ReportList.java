public class ReportList {
    private Message firstMessage;
    private Message lastMessage;

    public ReportList() {
        this.firstMessage = null;
        this.lastMessage = null;
    }

    // Agrega un mensaje reportado al final
    public void enqueue(Message m) {
        if (firstMessage == null) {
            firstMessage = m;
            lastMessage = m;
        } else {
            lastMessage.setNext(m);
            lastMessage = m;
        }
    }

    // Retorna el primer mensaje reportado
    public Message first() {
        return firstMessage;
    }

    // Retorna si la lista esta vacia
    public boolean empty() {
        return firstMessage == null;
    }

    // Retorna los primeros k mensajes reportados
    public Message[] firstKReportedMessages(int k) {
        int count = 0;
        Message temp = firstMessage;

        // Contar la cantidad de mensajes reportados
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