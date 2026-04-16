/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jechm.ejerciciosintecap.ejerciciomenu;

import java.util.ArrayList;

/**
 *
 * @author chemi
 */
public class pedido {

    public pedido() {
    }

    private final ArrayList<String> productos = new ArrayList<>();
    private final ArrayList<Integer> cantidades = new ArrayList<>();
    private final ArrayList<Integer> precios = new ArrayList<>();
    private int totalAPagar;
    private int totalProductos;

    public void agregarProducto(int cantidad, String producto, int precio, ArrayList<String> extras, ArrayList<Integer> preciosExtras) {

        cantidades.add(cantidad);
        productos.add(producto);
        precios.add(precio); //Agrega el precio del producto principal
        aumentarTotales(precio, cantidad);
        
        //manejo de agregar extras al pedido
        precios.addAll(preciosExtras);

        for (int i = 0; i < extras.size(); i++) {
            String pr;
            pr = "Extra-->" + extras.get(i);
            cantidades.add(cantidad);
            productos.add(pr);
            
            aumentarTotales(preciosExtras.get(i), cantidad);
        }

    }

    public void agregarProducto(int cantidad, String producto, int precio) {

        cantidades.add(cantidad);
        productos.add(producto);
        precios.add(precio);
        aumentarTotales(precio, cantidad);

    }

    private void aumentarTotales(int precio, int cantidad) {
        totalAPagar += precio;
        totalProductos+=cantidad;
    }

    public int getTotalAPagar() {
        return this.totalAPagar;
    }

    public int getTotalProductos() {
        return this.totalProductos;
    }

    public ArrayList getProductos() {
        return new ArrayList<>(productos);
    }

    public ArrayList getPrecios() {
        return new ArrayList<>(precios);
    }

    public ArrayList getCantidades() {
        return new ArrayList<>(cantidades);
    }
    
}
