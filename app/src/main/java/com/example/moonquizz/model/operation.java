package com.example.moonquizz.model;

public class operation {

    private int operand1;
    private int operand2;
    private String operation;

    public operation(int operand1, int operand2, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }


    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public float getResult(){
        float res;
        if(operation.equals("+")){
            res=operand1+operand2;
        }else if(operation.equals(("-"))){
            res=operand1-operand2;
        }else if(operation.equals("/")){
            res=operand1/operand2;
        } else{
            res=operand1*operand2;
        }

        return res;
    }
}
