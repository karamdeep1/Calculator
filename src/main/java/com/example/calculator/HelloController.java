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
    //default constructor
    public HelloController() {

    }
    //variables
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label calcBoardLabel;
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
    //puts num onto the board
    public void putNumOnBoard(ActionEvent e) throws IOException {
        //event handler for mouse events
        EventHandler<MouseEvent> buttonClickHandler = event -> {
            //gets the text of the button clicked
            String buttonText = ((Button) event.getSource()).getText();
            //prevents multiple decimal points
            if (buttonText.equals(".")) {
                if (expression.contains(".")) {
                    return;
                }
            }
            //adds the number onto the expression and onto the screen
            expression += ((Button) event.getSource()).getText();
            calcBoardLabel.setText(expression);
        };
        for(Node node : anchorPane.getChildren()){
            if(node instanceof Button)
                ((Button)node).setOnMouseClicked(buttonClickHandler);
        }
    }
    //clears the board
    public void clearBoard(ActionEvent e) throws IOException {
        //event handler to clear the screen and set it back to 0
        clearButton.setOnMouseClicked(event -> {
            expression ="";
            calcBoardLabel.setText("0");
        });
    }
    //sets number as a percentage
    public void percentBoard(ActionEvent e) throws IOException {
        //if it says error it resets it to 0
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        else {
            //event handler for percentage button
            percentageButton.setOnMouseClicked(event -> {
                //sets the number divided by 100 to a double and onto the screen
                double percent = Double.parseDouble(calcBoardLabel.getText()) / 100;
                calcBoardLabel.setText(String.valueOf(percent));
            });
        }
    }
    //all operations
    public void operationsBoard(ActionEvent e) throws IOException {
        //if it errors it will reset to 0
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        //All if statements check if an operator is there
        else {
            //event handler for addition button that adds the '+' sign to the screen
            additionButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "+" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for subtraction button that adds the '-' sign to the screen
            subtractButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "-" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for multiplication button that adds the '*' sign to the screen
            multiplyButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "*" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for division button that adds the '/' sign to the screen
            divideButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "/" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for +/= button
            numberSignButton.setOnMouseClicked(event -> {
                //if the number is negative it will remove the negative sign otherwise it will add it
                if (calcBoardLabel.getText().charAt(0) == '-') {
                    calcBoardLabel.setText(calcBoardLabel.getText().substring(1));
                    expression = calcBoardLabel.getText();
                } else {
                    calcBoardLabel.setText("-" + calcBoardLabel.getText());
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for square root button that takes the square root
            squareRootButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.sqrt(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for square button that squares the number
            squaredButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.pow(num,2);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for sin button that takes the sin of the number
            sinButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.sin(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for cos button that takes the cos of the number
            cosButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.cos(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for tan button that takes the tan of the number
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
        //if it errors it will set screen to say 0
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        else {
            //sets the screen to a string input
            String input = calcBoardLabel.getText();
            //gets the operators and number from the input string
            String[] tokens = input.split(" ");
            //adds numbers and operators to stacks
            Stack<Double> numbers = new Stack<>();
            Stack<String> operators = new Stack<>();
            //for every token it will check the operator
            for (String token : tokens) {
                if (token.matches("[+\\-*/]")) {
                    //if the token is an operator, evaluate higher preceding ones first
                    while (!operators.isEmpty() && hasPrecedence(token, operators.peek())) {
                        double second = numbers.pop();
                        double first = numbers.pop();
                        String op = operators.pop();
                        numbers.push(applyOp(first, second, op));
                    }
                    //pushes the operator to the stack
                    operators.push(token);
                } else {
                    //pushes the number onto the stack
                    numbers.push(Double.parseDouble(token));
                }
            }
            //evaluate remaining operators
            while (!operators.isEmpty()) {
                double second = numbers.pop();
                double first = numbers.pop();
                String op = operators.pop();
                //check for division by 0
                if (op.equals("/") && second == 0)
                    calcBoardLabel.setText("Error");
                else
                    //apply operator to the 2 numbers and push result onto stack
                    numbers.push(applyOp(first, second, op));
            }
            //gets final result and adds it to the screen
            if (!numbers.isEmpty()) {
                double total = numbers.pop();
                calcBoardLabel.setText(String.valueOf(total));
                expression = String.valueOf(total);
            }
        }
    }

    private boolean hasPrecedence(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")")) {
            //if it contains parentheses it will not have higher precedence
            return false;
        } else if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) {
            //if op1 is multiplication or division and op2 is addition or subtraction return false
            return false;
        } else {
            //return true in all other cases
            return true;
        }
    }

    private double applyOp(double a, double b, String op) {
        //checks operation
        switch (op) {
            case "+":
                //if '+' then return a+b
                return a + b;
            case "-":
                //if '-' then return a-b
                return a - b;
            case "*":
                //if '*' then return a*b
                return a * b;
            case "/":
                //if '/' then return a/b unless dividing by 0
                if (b == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return a / b;
            default:
                //default case to throw invalid operator
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}