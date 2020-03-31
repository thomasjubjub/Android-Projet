package fr.android.moi.projet;

public class Match {

    private int idMatch;
    private String joueur1;
    private String joueur2;
    private String formatMatch;
    private String formatSet;


    public Match(){}
    public Match(int idMatch, String joueur1, String joueur2, String formatMatch, String formatSet){

        this.setIdMatch( idMatch);
        this.setJoueur1( joueur1 );
        this.setJoueur2( joueur2 );
        this.setFormatMatch( formatMatch );
        this.setFormatSet( formatSet );
    }

    private void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public String getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(String joueur1) {
        this.joueur1 = joueur1;
    }

    public String getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(String joueur2) {
        this.joueur2 = joueur2;
    }

    public String getFormatMatch() {
        return formatMatch;
    }

    public void setFormatMatch(String formatMatch) {
        this.formatMatch = formatMatch;
    }

    public String getFormatSet() {
        return formatSet;
    }

    public void setFormatSet(String formatSet) {
        this.formatSet = formatSet;
    }

    @Override
    public String toString() {
        return idMatch + ": " + joueur1 + " and " + joueur2 + " plays a " + formatMatch + "with " + formatSet;
    }
}
