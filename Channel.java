public class Channel {
    public String name;
    private Message headMessage;
    public Channel next;

    // Constructor de la clase Channel
    public Channel(String name) {
        this.name = name;
        this.headMessage = null;
        this.next = null;
    }

    // Agrega un mensaje al final de la lista de mensajes del canal
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

    // Retorna true si la lista de mensajes está vacía
    public boolean empty() {
        return headMessage == null;
    }

    // Asigna un nuevo canal como next
    public void setNext(Channel c) {
        this.next = c;
    }

    // Busca un mensaje por su ID
    public Message search(int id) {
        Message temp = headMessage;
        while (temp != null) {
            if (temp.getID() == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // Si no se encuentra el mensaje
    }

    // Retorna el primer mensaje del canal
    public Message getHead() {
        return headMessage;
    }
}