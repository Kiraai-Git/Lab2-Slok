public class SlokTest {
    public static void main(String[] args) {
        testCreateMessage();
        testReportMessage();
    }

    public static void testCreateMessage() {
        Slok slok = new Slok();
        slok.createChannel("general");
    
        slok.createMessage("Hola mundo", "general"); // Creado exitosamente
        slok.createMessage("Mensaje en canal no existente", "desconocido"); // Error: Canal inexistente
    }

    public static void testReportMessage() {
        Slok slok = new Slok();
        slok.createChannel("general");

        slok.createMessage("Mensaje", "general"); // ID: 1
        slok.createMessage("Otro mensaje", "general"); // ID: 2

        slok.reportMessage(1, "general"); // Reportado exitosamente
        slok.reportMessage(999, "general"); // ID inexistente
        slok.reportMessage(1, "general"); // Error: Mensaje ya reportado
    }    
}
