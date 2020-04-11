package fr.android.moi.projet;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Match implements Parcelable{

    private int idMatch;
    private String nomJ1;
    private String nomJ2;
    private String formatMatch;
    private String formatSet;

    private String scoreJ1Set1 ;
    private String scoreJ1Set2 ;
    private String scoreJ1Set3 ;
    private String scoreJ2Set1 ;
    private String scoreJ2Set2 ;
    private String scoreJ2Set3 ;

    private String doubleFauteJoueur1 ;
    private String doubleFauteJoueur2;
    private String aceJoueur1 ;
    private String aceJoueur2 ;
    private String gagnantJoueur1 ;
    private String gagnantJoueur2 ;
    private String fauteJoueur1 ;
    private String fauteJoueur2 ;

    public Match(){}
    public Match(int idMatch, String nomJ1, String nomJ2, String formatMatch, String formatSet,
                 String scoreJ1Set1, String scoreJ1Set2, String scoreJ1Set3, String scoreJ2Set1, String scoreJ2Set2, String scoreJ2Set3,
                 String doubleFauteJoueur1, String doubleFauteJoueur2,
                 String aceJoueur1, String aceJoueur2,
                 String gagnantJoueur1, String gagnantJoueur2,
                 String fauteJoueur1, String fauteJoueur2 ) {

        Log.d("classMatch","gagnant J1 -" + gagnantJoueur1 );

        this.setIdMatch( idMatch);
        this.setJoueur1( nomJ1 );
        this.setJoueur2( nomJ2 );
        this.setFormatMatch( formatMatch );
        this.setFormatSet( formatSet );

        this.setScoreJ1Set1(scoreJ1Set1);
        this.setScoreJ1Set2(scoreJ1Set2);
        this.setScoreJ1Set3(scoreJ1Set3);
        this.setScoreJ2Set1(scoreJ2Set1);
        this.setScoreJ2Set2(scoreJ2Set2);
        this.setScoreJ2Set3(scoreJ2Set3);

        this.setDoubleFauteJoueur1 (doubleFauteJoueur1) ;
        this.setDoubleFauteJoueur2 (doubleFauteJoueur2) ;
        this.setAceJoueur1 (aceJoueur1) ;
        this.setAceJoueur2 (aceJoueur2) ;
        this.setGagnantJoueur1 (gagnantJoueur1) ;
        this.setGagnantJoueur2 (gagnantJoueur2) ;
        this.setFauteJoueur1 (fauteJoueur1) ;
        this.setFauteJoueur2 (fauteJoueur2) ;
    }

    public Match(Parcel in) {

        idMatch = in.readInt();
        nomJ1 = in.readString();
        nomJ2 = in.readString();
        formatMatch = in.readString();
        formatSet = in.readString();

        scoreJ1Set1 = in.readString();
        scoreJ1Set2 = in.readString();
        scoreJ1Set3 = in.readString();
        scoreJ2Set1 = in.readString();
        scoreJ2Set2 = in.readString();
        scoreJ2Set3 = in.readString();

        doubleFauteJoueur1  = in.readString();
        doubleFauteJoueur2 = in.readString();
        aceJoueur1 = in.readString();
        aceJoueur2 = in.readString();
        gagnantJoueur1 = in.readString();
        gagnantJoueur2 = in.readString();
        fauteJoueur1 = in.readString();
        fauteJoueur2 = in.readString();
    }


    public static final Creator<Match> CREATOR = new Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel in) {
            return new Match(in);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };

    // fonction affichage
    @Override
    public String toString() {
        return idMatch + ": " + nomJ1 + " and " + nomJ2
                + " doubleFauteJoueur1: " + doubleFauteJoueur1 + "- doubleFauteJoueur2: " + doubleFauteJoueur2
                + "aceJoueur1:" + aceJoueur1 +  "- aceJoueur2: " + aceJoueur2
                + " gagnantJoueur1: " + gagnantJoueur1 + "- gagnantJoueur2: " + gagnantJoueur2
                + "fauteJoueur1:" + fauteJoueur1 +  "- fauteJoueur2: " + fauteJoueur2 ;
    }

    // fonction parceable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // écrire dans l'ordre les attributs classe
        dest.writeInt(idMatch);
        dest.writeString(nomJ1);
        dest.writeString(nomJ2);
        dest.writeString(formatMatch);
        dest.writeString(formatSet);

        dest.writeString(scoreJ1Set1);
        dest.writeString(scoreJ1Set2);
        dest.writeString(scoreJ1Set3);
        dest.writeString(scoreJ2Set1);
        dest.writeString(scoreJ2Set2);
        dest.writeString(scoreJ2Set3);

        dest.writeString(doubleFauteJoueur1);
        dest.writeString(doubleFauteJoueur2);
        dest.writeString(aceJoueur1);
        dest.writeString(aceJoueur2);
        dest.writeString(gagnantJoueur1);
        dest.writeString(gagnantJoueur2);
        dest.writeString(fauteJoueur1);
        dest.writeString(fauteJoueur2);

    }


    // getter and setter

    public String getAceJoueur1() {
        return aceJoueur1;
    }
    public String getAceJoueur2() {
        return aceJoueur2;
    }
    public String getDoubleFauteJoueur1() { return doubleFauteJoueur1; }
    public String getDoubleFauteJoueur2() { return doubleFauteJoueur2; }
    public String getGagnantJoueur1() { return gagnantJoueur1; }
    public String getGagnantJoueur2() { return gagnantJoueur2; }
    public String getFauteJoueur1() { return fauteJoueur1; }
    public String getFauteJoueur2() { return fauteJoueur2; }

    public void setAceJoueur1(String aceJoueur1) {
         this.aceJoueur1 = aceJoueur1;
    }
    public void setAceJoueur2(String aceJoueur2) {
         this.aceJoueur2 = aceJoueur2;
    }
    public void setDoubleFauteJoueur1(String doubleFauteJoueur1) {
         this.doubleFauteJoueur1 = doubleFauteJoueur1;
    }
    public void setDoubleFauteJoueur2(String doubleFauteJoueur2) {
        this.doubleFauteJoueur2 = doubleFauteJoueur2;
    }
    public void setGagnantJoueur1(String gagnantJoueur1) {
         this.gagnantJoueur1  = gagnantJoueur1;
    }
    public void setGagnantJoueur2(String gagnantJoueur2) {
        this.gagnantJoueur2 = gagnantJoueur2;
    }
    public void setFauteJoueur1(String fauteJoueur1) {
         this.fauteJoueur1 = fauteJoueur1;
    }
    public void setFauteJoueur2(String fauteJoueur2) {

        this.fauteJoueur2 = fauteJoueur2;
    }

    private void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public String getJoueur1() {
        return nomJ1;
    }

    public void setJoueur1(String joueur1) {
        this.nomJ1 = joueur1;
    }

    public String getJoueur2() {
        return nomJ2;
    }

    public void setJoueur2(String joueur2) {
        this.nomJ2 = joueur2;
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

    public String getScoreJ1Set1() {
        return scoreJ1Set1;
    }

    public void setScoreJ1Set1(String scoreJ1Set1) {
        this.scoreJ1Set1 = scoreJ1Set1;
    }

    public String getScoreJ1Set2() {
        return scoreJ1Set2;
    }

    public void setScoreJ1Set2(String scoreJ1Set2) {
        this.scoreJ1Set2 = scoreJ1Set2;
    }

    public String getScoreJ1Set3() {
        return scoreJ1Set3;
    }

    public void setScoreJ1Set3(String scoreJ1Set3) {
        this.scoreJ1Set3 = scoreJ1Set3;
    }

    public String getScoreJ2Set1() {
        return scoreJ2Set1;
    }

    public void setScoreJ2Set1(String scoreJ2Set1) {
        this.scoreJ2Set1 = scoreJ2Set1;
    }

    public String getScoreJ2Set2() {
        return scoreJ2Set2;
    }

    public void setScoreJ2Set2(String scoreJ2Set2) {
        this.scoreJ2Set2 = scoreJ2Set2;
    }

    public String getScoreJ2Set3() {
        return scoreJ2Set3;
    }

    public void setScoreJ2Set3(String scoreJ2Set3) {
        this.scoreJ2Set3 = scoreJ2Set3;
    }

    /* public boolean isJ1Gagnant() {
        return J1Gagnant;
    }

     public void setJ1Gagnant(boolean j1Gagnant) {
        J1Gagnant = j1Gagnant;
    }
    */
}
