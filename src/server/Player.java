/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author evand
 */
public class Player {
    
    private String name;
    private char symbol;
    private int[] position;
    
    /*
    
    position[0] → linha
    position[1] → coluna
    
    */
    public Player() {
        this.position = new int[2];
        // Gerar símbolo automático
        this.symbol = this.name.charAt(this.name.length() - 1);
    }
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    
    
    
    
    
}
