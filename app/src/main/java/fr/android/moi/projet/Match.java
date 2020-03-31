package fr.android.moi.projet;

import android.os.Parcel;
import android.os.Parcelable;

public class Match implements Parcelable{

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

    public Match(Parcel in) {

        idMatch = in.readInt();
        joueur1 = in.readString();
        joueur2 = in.readString();
        formatMatch = in.readString();
        formatSet = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // écrire dans l'ordre les attributs classe
        dest.writeInt(idMatch);
        dest.writeString(joueur1);
        dest.writeString(joueur2);
        dest.writeString(formatMatch);
        dest.writeString(formatSet);

    }
}
