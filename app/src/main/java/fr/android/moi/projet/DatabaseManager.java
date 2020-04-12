package fr.android.moi.projet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Bundle;

//classe abstraite
public class DatabaseManager extends SQLiteOpenHelper{

    // attributs
    private static final String DATABASE_NAME = "myBDD.db";

    private static final int DATABASE_VERSION = 13;



    // constucteur
    public DatabaseManager( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    // C'est le système qui invoque ces classe
    @Override
    public void onCreate(SQLiteDatabase db) {

        // construction de table
        String strSql = "create table T_Match ("
                + "    idMatch integer primary key autoincrement," // autoincrementation
                + "    joueur1 text not null,"
                + "    joueur2 text not null,"
                + "    formatSet text not null,"
                + "    formatMatch text not null,"

                + "    scoreJ1Set1 text not null,"
                + "    scoreJ1Set2 text not null,"
                + "    scoreJ1Set3 text not null,"
                + "    scoreJ2Set1 text not null,"
                + "    scoreJ2Set2 text not null,"
                + "    scoreJ2Set3 text not null,"

                + "    doubleFauteJoueur1 text not null,"
                + "    doubleFauteJoueur2 text not null,"
                + "    aceJoueur1 text not null,"
                + "    aceJoueur2 text not null,"
                + "    gagnantJoueur1 text not null,"
                + "    gagnantJoueur2 text not null,"
                + "    fauteJoueur1 text not null,"
                + "    fauteJoueur2 text not null,"
                + "    image blob not null"
                + ")";

        db.execSQL( strSql );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // si il y a une mise à jour de la BDD

      db.execSQL("DROP TABLE T_match"); // supprimer la table

        Log.i( "DATABASE", "newVersion" );
        if (newVersion > oldVersion) {
            String strSql = "create table T_Match ("
                    + "    idMatch integer primary key autoincrement," // autoincrementation
                    + "    joueur1 text not null,"
                    + "    joueur2 text not null,"
                    + "    formatSet text not null,"
                    + "    formatMatch text not null,"

                    + "    scoreJ1Set1 text not null,"
                    + "    scoreJ1Set2 text not null,"
                    + "    scoreJ1Set3 text not null,"
                    + "    scoreJ2Set1 text not null,"
                    + "    scoreJ2Set2 text not null,"
                    + "    scoreJ2Set3 text not null,"

                    + "    doubleFauteJoueur1 text not null,"
                    + "    doubleFauteJoueur2 text not null,"
                    + "    aceJoueur1 text not null,"
                    + "    aceJoueur2 text not null,"
                    + "    gagnantJoueur1 text not null,"
                    + "    gagnantJoueur2 text not null,"
                    + "    fauteJoueur1 text not null,"
                    + "    fauteJoueur2 text not null,"
                    + "    image blob not null"
                    + ")";

            db.execSQL( strSql );
            /*
            db.execSQL("ALTER TABLE T_match ADD COLUMN joueur1 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN joueur2 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN formatSet TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN formatMatch TEXT DEFAULT null");

            db.execSQL("ALTER TABLE T_match ADD COLUMN scoreJ1Set1 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN scoreJ1Set2 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN scoreJ1Set3 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN scoreJ2Set1 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN scoreJ2Set2 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN scoreJ2Set3 TEXT DEFAULT null");

            db.execSQL("ALTER TABLE T_match ADD COLUMN doubleFauteJoueur1 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN doubleFauteJoueur2 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN aceJoueur1 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN aceJoueur2 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN gagnantJoueur1 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN gagnantJoueur2 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN fauteJoueur1 TEXT DEFAULT null");
            db.execSQL("ALTER TABLE T_match ADD COLUMN fauteJoueur2 TEXT DEFAULT null");

             */
        }


    }

    public void insertMatch(String joueur1, String joueur2, String formatSet, String formatMatch,
                            String scoreJ1Set1, String scoreJ1Set2, String scoreJ1Set3, String scoreJ2Set1, String scoreJ2Set2, String scoreJ2Set3,
                            String doubleFauteJoueur1, String doubleFauteJoueur2,
                            String aceJoueur1, String aceJoueur2,
                            String gagnantJoueur1, String gagnantJoueur2,
                            String fauteJoueur1, String fauteJoueur2,
                            byte[] image){

        // pour mettre les string entre ''
        joueur1 = joueur1.replace( "'", "''" );
        joueur2 = joueur2.replace( "'", "''" );
        formatSet = formatSet.replace( "'", "''" );
        formatMatch = formatMatch.replace( "'", "''" );


        //Log.i( "DATABASE", "insertMatch" );
        Log.d("insertMatch","gagnant J1" + gagnantJoueur1 );

        String strSql = "insert into T_Match (joueur1, joueur2, formatSet, formatMatch," +
                "  scoreJ1Set1, scoreJ1Set2, scoreJ1Set3, scoreJ2Set1, scoreJ2Set2, scoreJ2Set3, " +
                "doubleFauteJoueur1, doubleFauteJoueur2, " +
                "aceJoueur1, aceJoueur2, gagnantJoueur1, " +
                "gagnantJoueur2, " +
                "fauteJoueur1, fauteJoueur2," +
                "image) " +
                "values ('" + joueur1 + "', '" + joueur2 + "', '"+ formatSet +"', '"+ formatMatch +"', " +
                " '"+ scoreJ1Set1 +"', '"+ scoreJ1Set2 +"', '"+ scoreJ1Set3 +"'," +
                "'"+ scoreJ2Set1 +"','"+ scoreJ2Set2 +"','"+ scoreJ2Set3 +"'," +
                " '"+ doubleFauteJoueur1 +"','"+ doubleFauteJoueur2 +"', " +
                " '"+ aceJoueur1 +"','"+ aceJoueur2 +"', " +
                " '"+ gagnantJoueur1 +"','"+ gagnantJoueur2 +"', " +
                " '"+ fauteJoueur1 +"','"+ fauteJoueur2 +"' " +
                ",'"+ image +"' )";

        this.getWritableDatabase().execSQL( strSql );
    }

    public List<Match> readMatch(){

        //creation arraylist
        List<Match> matches = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + "T_Match" ;

        Cursor cursor = db.rawQuery(selectQuery, null);
        try{
            if (cursor.moveToLast()) {

                do{
                    //String info = cursor.getString(cursor.getColumnIndex("idMatch"));
                    // creation d'un objet match
                    Match match = new Match( cursor.getInt( 0 ), cursor.getString( 1 ), cursor.getString( 2 ),  cursor.getString( 3 ), cursor.getString( 4 ),
                            cursor.getString( 5 ),cursor.getString( 6),cursor.getString( 7 ), cursor.getString( 8 ), cursor.getString( 9 ),cursor.getString( 10 ),
                            cursor.getString( 11 ),cursor.getString( 12),cursor.getString( 13 ), cursor.getString( 14 ),
                            cursor.getString( 15 ),cursor.getString( 16),cursor.getString( 17 ), cursor.getString( 18 ),
                            cursor.getBlob(19));
                    // ajout du match dans l'arraylist

                    Log.d("InReadMatch_cursor", cursor.getInt( 0 ) + "gagnant J1 -" + cursor.getString( 15 ));
                    matches.add( match );
                }while (cursor.moveToPrevious());
            }
        }
        finally{
            cursor.close();
        }

        // definition d'un curseur + lecture de la table + décalage du curseur
        /*
        Cursor cursor = this.getReadableDatabase().query( "T_match",
                new String[] { "idMatch", "joueur1", "joueur2", "formatSet", "formatMatch", "scoreJ1Set1", "scoreJ1Set2", "scoreJ1Set3", "scoreJ2Set1", "scoreJ2Set2", "scoreJ2Set3"},
                null, null, null, null, "idMatch", "10" );
        cursor.moveToFirst();

        // si le curseur n'a pas lu tout les matches
        while( ! cursor.isAfterLast() ) {
            // creation d'un objet match
            Match match = new Match( cursor.getInt( 0 ), cursor.getString( 1 ), cursor.getString( 2 ),  cursor.getString( 3 ), cursor.getString( 4 ),
                                    cursor.getInt( 5 ),cursor.getInt( 6),cursor.getInt( 7 ), cursor.getInt( 8 ), cursor.getInt( 9 ),cursor.getInt( 10 ));
           // ajout du match dans l'arraylist
            matches.add( match );
            cursor.moveToNext();
        }
        cursor.close();

         */

        Log.d("InReadMatch", matches.toString());
        // retourne arraylist de matches
        return matches;

    }

}
