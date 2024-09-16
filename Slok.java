public class Slok {
    private Channel headChannel;
    private History history;
    private ReportList reportList;
    private int idCounter;

    public Slok(){
        this.headChannel = null;
        this.history = new History();
        this.reportList = new ReportList();
        idCounter = 1;
    }

    public void reportMessage(int id, String channelName) {
        Channel currentChannel = headChannel;
    
        while (currentChannel != null) {
            if (currentChannel.name.equals(channelName)) {
                Message messageToReport = currentChannel.search(id);
                
                if (messageToReport != null) {
                    if (!messageToReport.isReported()) {
                        messageToReport.report();

                        Message reportedMessageCopy = new Message(messageToReport.getContent(), channelName, messageToReport.getID());
                        reportList.enqueue(reportedMessageCopy);
    
                        System.out.println("Mensaje reportado y añadido a la lista de reportes.");
                    } else {
                        System.out.println("El mensaje ya ha sido reportado.");
                    }
                } else {
                    System.out.println("Mensaje con ID " + id + " no encontrado en el canal " + channelName + ".");
                }
                return;
            }
            currentChannel = currentChannel.next;
        }
        System.out.println("Canal " + channelName + " no encontrado.");
    }
    

    public void createMessage(String content, String channelName) {
        Channel currentChannel = headChannel;
    
        while (currentChannel != null) {
            if (currentChannel.name.equals(channelName)) {
                Message newMessage = new Message(content, channelName, idCounter);

                currentChannel.appendMessage(newMessage);

                incrementIDCounter();
    
                history.push(new Message(newMessage.getContent(), channelName, newMessage.getID()));
    
                System.out.println("Mensaje creado y añadido al canal " + channelName);
                return;
            }
            currentChannel = currentChannel.next;
        }
        System.out.println("Canal " + channelName + " no encontrado.");
    }
    

    public void createChannel(String name){
        Channel newChannel = new Channel(name);
        if (headChannel == null) {
            headChannel = newChannel;
        } else {
            Channel temp = headChannel;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.setNext(newChannel);
        }
    }

    public void incrementIDCounter(){
        idCounter += 1;
    }

    public int getIDCounter(){
        return idCounter;
    }
}