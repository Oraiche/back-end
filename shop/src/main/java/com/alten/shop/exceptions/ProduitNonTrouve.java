package com.alten.shop.exceptions;

public class ProduitNonTrouve extends RuntimeException{
    public ProduitNonTrouve(String msg){
        super(msg);
    }
}
