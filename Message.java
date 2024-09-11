public class Message {
    private int id;
    private String content;
    private boolean reported;
    public String channelName;
    public Message next;

    // Constructor de la clase Message
    public Message(String content, String channelName, int id) {
        this.content = content;
        this.channelName = channelName;
        this.id = id;
        this.reported = false;
        this.next = null;
    }

    // Cambia el valor de reported a true
    public void report() {
        this.reported = true;
    }

    // Retorna si el mensaje ha sido reportado
    public boolean isReported() {
        return reported;
    }

    // Retorna el contenido del mensaje
    public String getContent() {
        return content;
    }

    // Asigna un nuevo mensaje como next
    public void setNext(Message n) {
        this.next = n;
    }

    // Retorna el ID del mensaje
    public int getID() {
        return id;
    }
}

