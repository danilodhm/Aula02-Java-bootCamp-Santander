public class Main {
    public static void main(String[] args) throws Exception {

        MensagemMarketing mensagem = new WhatsApp();
        mensagem.enviarMensagem();

        mensagem = new Email();
        mensagem.enviarMensagem();

        mensagem = new SMS();
        mensagem.enviarMensagem();

        mensagem = new RedeSocial();
        mensagem.enviarMensagem();
        
    }
}
