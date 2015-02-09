/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author lvaleriano
 */
public class E_File {
    private File archivo;
    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    private PrintWriter pw;

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    public FileReader getFr() {
        return fr;
    }
    public void setFr(FileReader fr) {
        this.fr = fr;
    }
    public BufferedReader getBr() {
        return br;
    }
    public void setBr(BufferedReader br) {
        this.br = br;
    }
    public FileWriter getFw() {
        return fw;
    }
    public void setFw(FileWriter fw) {
        this.fw = fw;
    }
    public PrintWriter getPw() {
        return pw;
    }
    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
}
