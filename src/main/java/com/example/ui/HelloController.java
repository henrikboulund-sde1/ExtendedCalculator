package com.example.ui;

import com.example.bll.CalculatorLogic;
import com.example.bll.LoggerLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    Action lastAction = null;
    Operator currentOperator = null;
    ArrayList<Double> numbersList = new ArrayList<Double>();
    ArrayList<Character> operatorsList = new ArrayList<Character>();
    CalculatorLogic calculatorLogic = new CalculatorLogic();
    LoggerLogic loggerLogic = new LoggerLogic();
    @FXML
    private Label welcomeText;

    @FXML
    private TextField txtNumericScreen;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onNumbericButttonClick(ActionEvent action)
    {
        if(lastAction == null || lastAction == Action.Number)
        {
            Button button = (Button) action.getSource();
            int number = Integer.parseInt(button.getText());
            int numberOnScreen = Integer.parseInt(txtNumericScreen.getText());
            if(numberOnScreen != 0)
            {
                txtNumericScreen.setText(txtNumericScreen.getText() + number);
            }
            else
            {
                txtNumericScreen.setText(number + "");
            }
            lastAction = Action.Number;
        }
        else if(lastAction == Action.Operator)
        {
            Button button = (Button) action.getSource();
            int number = Integer.parseInt(button.getText());
            txtNumericScreen.setText(number + "");
            lastAction = Action.Number;
        }
    }

    public void onOperatorButttonClick(ActionEvent actionEvent)
    {
        if(lastAction == null || lastAction != Action.Operator)
        {
            Button button = (Button)actionEvent.getSource();
            char getOperator = button.getText().toCharArray()[0];
            if(getOperator != '=')
            {
                operatorsList.add(getOperator);
                numbersList.add(Double.parseDouble(txtNumericScreen.getText()));
                lastAction = Action.Operator;
            }
            else
            {
                numbersList.add(Double.parseDouble(txtNumericScreen.getText()));
                double result = calculatorLogic.Calculate(numbersList, operatorsList);
                txtNumericScreen.setText(result+"");
                numbersList.clear();
                operatorsList.clear();
                lastAction = Action.Equal;
            }

        }
    }

    public enum Operator
    {
        Plus,
        Minus,
        Multiply,
        Division
    }

    public enum Action
    {
        Number,
        Operator,
        Equal
    }
}