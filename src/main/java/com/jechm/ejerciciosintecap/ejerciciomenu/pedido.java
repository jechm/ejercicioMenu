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
    private final ArrayList<Integer> precios = new ArrayList<>();
    private int totalAPagar;
    private int totalProductos;

    public void agregarProducto(String producto, int precio, String[] extras, int[] preciosExtras) {

        productos.add(producto);
        precios.add(precio);
        aumentarTotales(precio);

        for (int i = 0; i < extras.length; i++) {
            String pr;
            pr = "-->"+ extras[i];
            productos.add(pr);
            precios.add(preciosExtras[i]);
            aumentarTotales(preciosExtras[i]);
        }

    }

    public void agregarProducto(String producto, int precio) {

        productos.add(producto);
        precios.add(precio);
        aumentarTotales(precio);

    }

    private void aumentarTotales(int precio) {
        totalAPagar += precio;
        totalProductos++;
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
}
