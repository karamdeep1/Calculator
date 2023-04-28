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
    //Default Constuctor
    public HelloController() {

    }
    //Variables used in program
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
    //puts the number on the screen
    public void putNumOnBoard(ActionEvent e) throws IOException {
        //Event handler for mouse events
        EventHandler<MouseEvent> buttonClickHandler = event -> {
            //Gets text from the button and sets it to a string
            String buttonText = ((Button) event.getSource()).getText();
            //checks if it equals a '.' and if it does then it just returns to prevent multiple '.' from occurring
            if (buttonText.equals(".")) {
                if (expression.contains(".")) {
                    return;
                }
            }
            //adds the text from the button to the expression
            expression += ((Button) event.getSource()).getText();
            //sets the screens text to expression
            calcBoardLabel.setText(expression);
        };
        //calls the event handler for every button under the anchor pane
        for(Node node : anchorPane.getChildren()){
            if(node instanceof Button)
                ((Button)node).setOnMouseClicked(buttonClickHandler);
        }
    }
    //clears the screen
    public void clearBoard(ActionEvent e) throws IOException {
        //event handler for clearing the expression and putting 0 on the screen
        clearButton.setOnMouseClicked(event -> {
            expression ="";
            calcBoardLabel.setText("0");
        });
    }
    //Gives the number as a percentage
    public void percentBoard(ActionEvent e) throws IOException {
        //If the screen says error it will set the screen to say 0 to restart
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        //event handler to divide the number by 100 and setting the screen to be that number
        else {
            percentageButton.setOnMouseClicked(event -> {
                double percent = Double.parseDouble(calcBoardLabel.getText()) / 100;
                calcBoardLabel.setText(String.valueOf(percent));
            });
        }
    }
    //All the operations on the screen
    public void operationsBoard(ActionEvent e) throws IOException {
        //If it says error it will set it back to 0 to restart
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        //all the operators
        //Each event handler checks if the operator is already displayed and if it is then it will not work
        else {
            //event handler for when addition is selected, will a '+' onto the screen
            additionButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "+" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for when subtraction is selected, will a '-' onto the screen
            subtractButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "-" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for when multiplication is selected, will a '*' onto the screen
            multiplyButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "*" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //event handler for when division is selected, will a '/' onto the screen
            divideButton.setOnMouseClicked(event -> {
                if (!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))) {
                    calcBoardLabel.setText(calcBoardLabel.getText() + " " + "/" + " ");
                    expression = calcBoardLabel.getText();
                }
            });
            //checks if +/- button is selected
            numberSignButton.setOnMouseClicked(event -> {
                //if the first character of the text has a negative sign it will get rid of it otherwise it adds it at the beginning
                if (calcBoardLabel.getText().charAt(0) == '-') {
                    calcBoardLabel.setText(calcBoardLabel.getText().substring(1));
                    expression = calcBoardLabel.getText();
                } else {
                    calcBoardLabel.setText("-" + calcBoardLabel.getText());
                    expression = calcBoardLabel.getText();
                }
            });
            //checks if the square root button is clicked and if it is it will square root the number
            squareRootButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.sqrt(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //checks if the squared button is clicked and if it is it will square the number
            squaredButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.pow(num,2);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //check if the sin button is clicked and if it is it will take the sin of the number
            sinButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.sin(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //checks if the cos button is clicked and if it is it will take the cos of the number
            cosButton.setOnMouseClicked(event ->{
                if(!(calcBoardLabel.getText().contains("+") || calcBoardLabel.getText().substring(1).contains("-") || calcBoardLabel.getText().contains("*") || calcBoardLabel.getText().contains("/"))){
                    double num = Double.parseDouble(calcBoardLabel.getText());
                    num = Math.cos(num);
                    calcBoardLabel.setText(String.valueOf(num));
                    expression = calcBoardLabel.getText();
                }
            });
            //checks if the tan button is clicked and if it is it will take the tan of the number
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
    //this runs when the equal button is clicked
    public void equalsBoard(ActionEvent e) {
        //if it says error it will just set it back to 0 otherwise continue
        if(calcBoardLabel.getText().equals("Error")){
            calcBoardLabel.setText("0");
        }
        else {
            //sets the text to a string
            String input = calcBoardLabel.getText();
            //splits the input string into the numbers and operators
            String[] tokens = input.split(" ");
            //creates stacks to hold numbera and operators
            Stack<Double> numbers = new Stack<>();
            Stack<String> operators = new Stack<>();
            //Iterate through tokens and push them onto the stacks
            for (String token : tokens) {
                //checks if numbers match a certain operator
                if (token.matches("[+\\-*/]")) {
                    //if the token is an operator then evaluate higher preceding operating first
                    while (!operators.isEmpty() && hasPrecedence(token, operators.peek())) {
                        double second = numbers.pop();
                        double first = numbers.pop();
                        String op = operators.pop();
                        numbers.push(applyOp(first, second, op));
                    }
                    //pushes the current operator to the stack
                    operators.push(token);
                } else {
                    //if its a number push it onto the stack
                    numbers.push(Double.parseDouble(token));
                }
            }
            //evaluate remaining operators
            while (!operators.isEmpty()) {
                double second = numbers.pop();
                double first = numbers.pop();
                String op = operators.pop();
                //checks division by 0
                if (op.equals("/") && second == 0)
                    calcBoardLabel.setText("Error");
                else
                    //applys operator to 2 operands and pushes it to the stack
                    numbers.push(applyOp(first, second, op));
            }
            //get the final result from the stack and update the screen
            if (!numbers.isEmpty()) {
                double total = numbers.pop();
                calcBoardLabel.setText(String.valueOf(total));
                expression = String.valueOf(total);
            }
        }
    }

    private boolean hasPrecedence(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")")) {
            //if op1 is a parentheses it has no higher precendence so it returns false
            return false;
        } else if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) {
            //if op1 is multiplication or division and op 2 is addition or subtraction it returns false
            return false;
        } else {
            //all other cases return true
            return true;
        }
    }

    private double applyOp(double a, double b, String op) {
        //checks what op is
        switch (op) {
            case "+":
                //if addition return a+b
                return a + b;
            case "-":
                //if subtraction return a-b
                return a - b;
            case "*":
                //if multiplication return a*b
                return a * b;
            case "/":
                //if division return a/b unless dividing by 0
                if (b == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return a / b;
            default:
                //default statement for invalid operators
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}