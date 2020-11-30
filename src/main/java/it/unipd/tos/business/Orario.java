////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

public class Orario {
    private int Ore;
    private int Minuti;
    private int Secondi;
    public Orario(int Ore,int Minuti,int Secondi) 
    {
        this.Ore=Ore;
        this.Minuti=Minuti;
        this.Secondi=Secondi;
    }
    public int getOre() {
        return Ore;
    }
    public int getMinuti() {
        return Minuti;
    }
    public int getSecondi() {
        return Secondi;
    }
}
