package es.DechrisT.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.DechrisT.telegrambot.TelegramBotContent.*;

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
            setUserGlory(0);
            sendTextMessageAsync( STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,Map.of("!Tomar una salchicha ¡ +20 de fama","step_2_btn",
                    "!Tomar una pescado ¡ +20 de fama","step_2_btn",
                    "!Tirar un a lata de pepinillo ¡ +20 de fama,","step_2_btn") );
        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,Map.of(
                    "Hackear al robot aspiradora","step_3_btn") );
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,Map.of("!Enviar robot aspiradora por comida ¡ +30 de fama","step_4_btn",
                    "!Dar un paseo en el robot aspiradora ¡ +30 de fama","step_4_btn",
                    "!Huir del robt aspiradora¡ +30 de fama,","step_4_btn") );
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,Map.of());
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,Map.of("¡Correr por los tejados, grabar con la GoPro! +40 de fama","step_5_btn",
                    "¡Atacar a otros gatos desde tu escondite con la GoPro! +40 de fama","step_5_btn",
                    "¡Atacar a los perros desde tu escondite con la GoPro! +40 de fama,","step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT,Map.of("Romper la contraseña","step_6_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT,Map.of("Salir al patio","step_7_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            sendTextMessageAsync(FINAL_TEXT,Map.of());
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}