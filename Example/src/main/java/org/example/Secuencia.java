package org.example;

class Secuencia {
    static private long numSec = 0;
    synchronized static public long getNumSec(){
        return numSec++;
    }
}
