/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.edu.inegz.colegio.gotitas.config;

/**
 *
 * @author ALEJANDRA ZELADA
 */
public class Credentials {
    public static final String DATA_BASE = System.getenv("DATA_BASE");
    public static final String URL_DB = System.getenv("URL_MY_SQLDB");
    public static final String USER_DB = System.getenv("USER_DB");
    public static final String PASS_DB = System.getenv("PASS_DB");
}
