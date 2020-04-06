package fr.android.moi.projet;

import android.os.Parcel;
import android.os.Parcelable;

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

    private boolean J1Gagnant  = true;



    public Match(){}
    public Match(int idMatch, String nomJ1, String nomJ2, String formatMatch, String formatSet,
                 String scoreJ1Set1, String scoreJ1Set2, String scoreJ1Set3, String scoreJ2Set1, String scoreJ2Set2, String scoreJ2Set3){

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
        return idMatch + ": " + nomJ1 + " and " + nomJ2 + " plays a " + formatMatch + "with " + formatSet;
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


    }

    // getter and setter
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

    public boolean isJ1Gagnant() {
        return J1Gagnant;
    }

    public void setJ1Gagnant(boolean j1Gagnant) {
        J1Gagnant = j1Gagnant;
    }

}
