package es.DechrisT.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "DeChristBot_bot";
    public static final String TOKEN = "6664653649:AAHeGClJBcHiJcy7FLUmrE2fcP9fo7MBfCQ";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equals("/start")){
            sendTextMessageAsync("Hola ,_Futuro_ *Programador¡*");
        }
        if (getMessageText().contains("hola")){
            sendTextMessageAsync("_Hola_, cual es tu *nombre* ?");
        }
        if (getMessageText().contains("me llamo ")){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato*");

        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}