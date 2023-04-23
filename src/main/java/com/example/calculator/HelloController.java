package com.example.calculator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.lang.Math;

public class HelloController extends HelloApplication{
    public HelloController() {

    }
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label titleLabel;
    @FXML
    private Label calcBoardLabel;
    @FXML
    private Button zeroButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button decimalPointButton;
    @FXML
    private Button equalButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button additionButton;
    @FXML
    private Button tanButton;
    @FXML
    private Button cosButton;
    @FXML
    private Button sinButton;
    @FXML
    private Button squaredButton;
    @FXML
    private Button squareRootButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button numberSignButton;
    @FXML
    private Button percentageButton;
    String expression = "";
    public void putNumOnBoard(ActionEvent e) throws IOException {
        EventHandler<MouseEvent> buttonClickHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                expression += ((Button)event.getSource()).getText();
                calcBoardLabel.setText(expression);
            }
        };
        for(Node node : anchorPane.getChildren()){
            if(node instanceof Button)
                ((Button)node).setOnMouseClicked(buttonClickHandler);
        }
    }
    public void clearBoard(ActionEvent e) throws IOException {
        clearButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                expression ="";
                calcBoardLabel.setText("0");
            }
        });
    }
    public void percentBoard(ActionEvent e) throws IOException {
        percentageButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                double percent = Double.parseDouble(calcBoardLabel.getText()) / 100;
                calcBoardLabel.setText(String.valueOf(percent));
            }
        });
    }
    public void operationsBoard(ActionEvent e) throws IOException {
        additionButton.setOnMouseClicked(event -> {
            calcBoardLabel.setText(calcBoardLabel.getText() + " " + "+" + " ");
            expression = calcBoardLabel.getText();
        });
        subtractButton.setOnMouseClicked(event -> {
            calcBoardLabel.setText(calcBoardLabel.getText() + " " + "-" + " ");
            expression = calcBoardLabel.getText();
        });
        multiplyButton.setOnMouseClicked(event -> {
            calcBoardLabel.setText(calcBoardLabel.getText() + " " + "*" + " ");
            expression = calcBoardLabel.getText();
        });
        divideButton.setOnMouseClicked(event -> {
            calcBoardLabel.setText(calcBoardLabel.getText() + " " + "/" + " ");
            expression = calcBoardLabel.getText();
        });
        numberSignButton.setOnMouseClicked(event -> {
            if(calcBoardLabel.getText().charAt(0) == '-') {
                calcBoardLabel.setText(calcBoardLabel.getText().substring(1));
                expression = calcBoardLabel.getText();
            } else{
                calcBoardLabel.setText("-" + calcBoardLabel.getText());
                expression = calcBoardLabel.getText();
            }
        });
    }
    public void equalsBoard(ActionEvent e){
        double total = 0;
        for (int i = 0; i < calcBoardLabel.getText().length(); i++) {
            if(Character.isDigit(calcBoardLabel.getText().charAt(i)))
                total+=Character.getNumericValue(calcBoardLabel.getText().charAt(i));
        }
        calcBoardLabel.setText(String.valueOf(total));
        expression = String.valueOf(total);
    }
}