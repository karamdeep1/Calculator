package com.example.calculator;

import javafx.collections.ListChangeListener;
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
import java.util.Stack;

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
        EventHandler<MouseEvent> buttonClickHandler = event -> {
            String buttonText = ((Button) event.getSource()).getText();
            if (buttonText.equals(".")) {
                if (expression.contains(".")) {
                    return;
                }
            }
            if(expression.length() == 1 && expression.equals("0")){
                expression = "";
            }
            expression += ((Button) event.getSource()).getText();
            calcBoardLabel.setText(expression);
        };
        for(Node node : anchorPane.getChildren()){
            if(node instanceof Button)
                ((Button)node).setOnMouseClicked(buttonClickHandler);
        }
    }
    public void clearBoard(ActionEvent e) throws IOException {
        clearButton.setOnMouseClicked(event -> {
            expression ="";
            calcBoardLabel.setText("0");
        });
    }
    public void percentBoard(ActionEvent e) throws IOException {
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        else {
            percentageButton.setOnMouseClicked(event -> {
                double percent = Double.parseDouble(calcBoardLabel.getText()) / 100;
                calcBoardLabel.setText(String.valueOf(percent));
                expression = calcBoardLabel.getText();
            });
        }
    }
    public void operationsBoard(ActionEvent e) throws IOException {
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        else {
            additionButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "+" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            subtractButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "-" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            multiplyButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "*" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            divideButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "/" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            numberSignButton.setOnMouseClicked(event -> {
                if (calcBoardLabel.getText().charAt(0) == '-') {
                    calcBoardLabel.setText(calcBoardLabel.getText().substring(1));
                    expression = calcBoardLabel.getText();
                } else {
                    calcBoardLabel.setText("-" + calcBoardLabel.getText());
                    expression = calcBoardLabel.getText();
                }
            });
            squareRootButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.sqrt(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            squaredButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.pow(num,2);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            sinButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.sin(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            cosButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.cos(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            tanButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.tan(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
        }
    }

    public void equalsBoard(ActionEvent e) {
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        else {
            String input = calcBoardLabel.getText();
            String[] tokens = input.split(" ");
            Stack<Double> numbers = new Stack<>();
            Stack<String> operators = new Stack<>();
            for (String token : tokens) {
                if (token.matches("[+\\-*/]")) {
                    while (!operators.isEmpty() && hasPrecedence(token, operators.peek())) {
                        double second = numbers.pop();
                        double first = numbers.pop();
                        String op = operators.pop();
                        numbers.push(applyOp(first, second, op));
                    }
                    operators.push(token);
                } else {
                    numbers.push(Double.parseDouble(token));
                }
            }
            while (!operators.isEmpty()) {
                double second = numbers.pop();
                double first = numbers.pop();
                String op = operators.pop();
                if (op.equals("/") && second == 0)
                    calcBoardLabel.setText("Error");
                else
                    numbers.push(applyOp(first, second, op));
            }
            if (!numbers.isEmpty()) {
                double total = numbers.pop();
                calcBoardLabel.setText(String.valueOf(total));
                expression = String.valueOf(total);
            }
        }
    }

    private boolean hasPrecedence(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")")) {
            return false;
        } else if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) {
            return false;
        } else {
            return true;
        }
    }

    private double applyOp(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}