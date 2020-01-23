package macura.andrzej;

import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {
    final static Logger logger = Logger.getLogger("Andrzej");

    public static void main(String[] args) {
        setLogger();


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                GraphicalInterface UI = new GraphicalInterface(new CalculatorFacade());
            }
        });
    }

        private static void setLogger ()
        {
            try {
                FileHandler handler = new FileHandler("logs.txt");
                logger.addHandler(handler);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

