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

public class HelloController {
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
    private Button subractButton;
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
    public void putNumOnBoard(ActionEvent e) throws IOException {
        EventHandler<MouseEvent> buttonClickHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                calcBoardLabel.setText(calcBoardLabel.getText() + ((Button)event.getSource()).getText());
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
                calcBoardLabel.setText("");
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
}