package com.example.creditcard;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CreditCardController implements Initializable {
    Image imgAMEX = new Image("file:/Users/swewainehtet/IdeaProjects/creditcard/src/main/resources/AMEX.png");
    Image imgJCB = new Image("file:/Users/swewainehtet/IdeaProjects/creditcard/src/main/resources/JCB.png");
    Image imgMC = new Image("file:/Users/swewainehtet/IdeaProjects/creditcard/src/main/resources/MC.png");
    Image imgVISA = new Image("file:/Users/swewainehtet/IdeaProjects/creditcard/src/main/resources/VISA.png");

    @FXML // fx:id="ivCheckmark";
    private ImageView ivCheckmark;

    @FXML // fx:id="ivCardType";
    private ImageView ivCardType;

    public void cardValidator(Event e) {
        TextField num = (TextField) e.getSource();
        if (num.getText().length() == 16) {
            switch (checkType(num.getText())) {
                case "AMEX":
                    this.ivCardType.setImage(imgAMEX);
                    this.ivCardType.setVisible(true);
                    break;
                case "MC":
                    this.ivCardType.setImage(imgMC);
                    this.ivCardType.setVisible(true);
                    break;
                case "JCB":
                    this.ivCardType.setImage(imgJCB);
                    this.ivCardType.setVisible(true);
                    break;
                case "VISA":
                    this.ivCardType.setImage(imgVISA);
                    this.ivCardType.setVisible(true);
                    break;
                default:
                    this.ivCardType.setVisible(false);
                    break;
            }

            this.ivCheckmark.setVisible(true);
        } else {
            this.ivCardType.setVisible(false);
            this.ivCheckmark.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.ivCheckmark.setVisible(false);
        this.ivCardType.setVisible(false);
    }

    // helper method for checking card type
    public String checkType(String number) {
        if (number.charAt(0) == '4') {
            return "VISA";
        } else if (number.charAt(0) == '5') {
            return "MC";
        } else if (number.startsWith("34") || number.startsWith("37")) {
            return "AMEX";
        } else if (number.startsWith("35")) {
            return "JCB";
        }
        return "None";
    }
}
