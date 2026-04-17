/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jechm.ejerciciosintecap.ejerciciomenu;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    private int totalAPagar = 0;
    private int totalProductos = 0;

    //agrega productos con extras
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
//Agrega productos sin extras

    public void agregarProducto(int cantidad, String producto, int precio) {

        cantidades.add(cantidad);
        productos.add(producto);
        precios.add(precio);
        aumentarTotales(precio, cantidad);

    }

    public String generarTicket() {

        String listaPedido = "";
        //Preparacion de vista en tiempo real
        //lista pedido guardara todo lo que se mostrará segun se vaya creando el pedido
        if (totalProductos != 0) {
            listaPedido = "Cant.\tProducto          \t\tPrecio U\tSub-Total";

            //Crea la linea de producto a mostrar
            for (int i = 0; i < cantidades.size(); i++) {
                String separaPrecio = "";
                String productoActual = productos.get(i);
                for (int j = 0; j < 20 - productoActual.length(); j++) {
                    separaPrecio = separaPrecio + " ";
                }
                if (productoActual.equals("Flan") || productoActual.equals("Café")) {
                    separaPrecio = separaPrecio + "\t";
                }
                separaPrecio = separaPrecio + "\tQ ";

                listaPedido = listaPedido + "\n" + cantidades.get(i) + "\t" + productos.get(i) + separaPrecio + precios.get(i) + "\t Q " + (cantidades.get(i) * precios.get(i));
            }
            listaPedido = listaPedido + "\n---------------------------\nTotal: Q " + totalAPagar;
        }
        
        return listaPedido;
        

    }

    private void aumentarTotales(int precio, int cantidad) {
        totalAPagar += precio;
        totalProductos += cantidad;
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

    public void cancelarPedido() {
        if (totalProductos != 0) {
            //limpiar listas
            productos.clear();
            precios.clear();
            cantidades.clear();

            //resetear variables
            totalAPagar = 0;
            totalProductos = 0;

        }

    }
}
