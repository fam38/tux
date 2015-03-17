/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

/**
 *
 * @author stevensm
 */
public class Chronometre {

    private long begin;
    private long end;
    private long current;
    private int limite;

    public Chronometre(int limite) {
        begin = 0;
        end = 0;
        current = 0;
        this.limite = limite;
    }

    public void start() {
        begin = System.currentTimeMillis();
    }

    public void stop() {
        end = System.currentTimeMillis();
    }

    public long getTime() {
        current = System.currentTimeMillis();
        return current - begin;
    }

    public long getMilliseconds() {
        current = System.currentTimeMillis();
        return current - begin;
    }

    public int getSeconds() {
        current = System.currentTimeMillis();
        return (int) ((current - begin) / 1000);
    }

    public double getMinutes() {
        current = System.currentTimeMillis();
        return (current - begin) / 60000.0;
    }

    public double getHours() {
        current = System.currentTimeMillis();
        return (current - begin) / 3600000.0;
    }

    public int remainsTime() {
        end = System.currentTimeMillis();
        int timeSpent;
        timeSpent = (int) ((current - begin) / 1000.0);
        return (timeSpent);
    }

    public int getLimite() {
        return limite;
    }

}

