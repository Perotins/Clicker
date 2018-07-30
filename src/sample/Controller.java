package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private static boolean firstClick = false;
    private static double clicks = 0;
    @FXML
    private Text text;
    @FXML
    private Button button;

    public void onButtonClick(){
        if(firstClick){
            clicks++;
            text.setText("Clicks: " + clicks);
        } else {
            clicks++;
            firstClick = true;
            text.setText("Clicks: " + clicks);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    text.setText("You clicked " + clicks + " times with a CPS of " + clicks/5+"!");
                    firstClick = false;
                    button.setDisable(true);
                    clicks = 0;
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            button.setDisable(false);
                        }
                    }, 1500);

                }
            }, 5000);

        }
    }
}
