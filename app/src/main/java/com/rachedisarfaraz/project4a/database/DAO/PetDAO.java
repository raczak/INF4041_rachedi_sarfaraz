package com.rachedisarfaraz.project4a.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.rachedisarfaraz.project4a.database.DAOBase;
import com.rachedisarfaraz.project4a.database.models.Pet;

import java.util.ArrayList;

/**
 * Created by zakariarachedi on 17/11/2016.
 */

public class PetDAO extends DAOBase {
    public static final String TABLE_NAME = "pets";
    public static final String KEY = "id";
    public static final String NAME = "name";
    public static final String BIRTH_DATE = "birth_date";
    public ArrayList<Pet> tabSelect = new ArrayList<Pet>();

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
                    BIRTH_DATE + " NUMERIC);";

    public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public PetDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param p le pet à ajouter
     */
    public void add(Pet p) {
        ContentValues value = new ContentValues();
        value.put(PetDAO.NAME, p.getName());
        value.put(PetDAO.BIRTH_DATE, p.getBirthDate());
        mDb.insert(PetDAO.TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du pet à supprimer
     */
    public void delete(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param p le pet à modifier
     */
    public void update(Pet p) {
        ContentValues value = new ContentValues();
        value.put(NAME, p.getName());
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(p.getId())});
    }

    /**
     * @param id l'identifiant du pet à récupérer
     */
    public ArrayList<Pet> select(long id) {
        //String whereArgs [] = {"ingenieur", "1000"};
        Cursor cursor = mDb.rawQuery("select " + KEY + " AS _id, " + NAME + ", " + BIRTH_DATE + " from " + TABLE_NAME, new String[]{"1"});
        while (cursor.moveToNext()) {
            long id_getted = cursor.getLong(0);
            String name = cursor.getString(1);
            String birth_date = cursor.getString(2);
            Pet pet = new Pet(id_getted, name, birth_date);
            tabSelect.add(pet);
        }
        cursor.close();
        return tabSelect;
    }
}
