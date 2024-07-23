/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.*;

/**
 * Apstraktna klasa koja predstavlja opsti domen objekat u sistemu. Ova klasa
 * definise osnovne metode koje moraju biti implementirane u svim konkretnim
 * domen objektima.
 *
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public abstract class OpstiDomenskiObjekat {

    /**
     * Vraca tip WHERE uslova.
     *
     * @return tip WHERE uslova kao int
     */
    public abstract int getWhereType();

    /**
     * Postavlja tip WHERE uslova na unetu vrednost.
     *
     * @param whereType tip WHERE uslova kao int
     */
    public abstract void setWhereType(int whereType);

    /**
     * Vraca naziv klase.
     *
     * @return naziv klase kao String
     */
    public abstract String getClassName();

    /**
     * Vraca uslov za WHERE klauzulu.
     *
     * @return uslov za WHERE klauzulu kao String
     */
    public abstract String getWhereCondition();

    /**
     * Kreira novi zapis iz ResultSet-a.
     *
     * @param rs ResultSet iz baze podataka
     * @return novi objekat klase OpstiDomenskiObjekat
     * @throws SQLException ako dodje do greske pri radu sa bazom podataka
     */
    public abstract OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException;

    /**
     * Vraca vrednosti atributa kao string za unos u bazu.
     *
     * @return vrednosti atributa kao String
     */
    public abstract String getAtrValue();

    /**
     * Vraca nazive atributa za unos u bazu.
     *
     * @return nazive atributa kao String
     */
    public abstract String getInsertData();

    /**
     * Vraca prvi uslov za WHERE klauzulu.
     *
     * @return prvi uslov za WHERE klauzulu kao String
     */
    public abstract String getWhereCondition1();

    /**
     * Vraca drugi uslov za WHERE klauzulu.
     *
     * @return drugi uslov za WHERE klauzulu kao String
     */
    public abstract String getWhereCondition2();

    /**
     * Vraca vrednosti atributa za setovanje u bazi.
     *
     * @return vrednosti atributa kao String
     */
    public abstract String setAtrValue();

    /**
     * Vraca treci uslov za WHERE klauzulu.
     *
     * @return treci uslov za WHERE klauzulu kao String
     */
    public abstract String getWhereCondition3();

    /**
     * Vraca vrednosti atributa za setovanje u bazi (varijanta 1).
     *
     * @return vrednosti atributa kao String
     */
    public abstract String setAtrValue1();

    /**
     * Vraca vrednosti atributa za setovanje u bazi (varijanta 2).
     *
     * @return vrednosti atributa kao String
     */
    public abstract String setAtrValue2();

    /**
     * Vraca cetvrti uslov za WHERE klauzulu.
     *
     * @return cetvrti uslov za WHERE klauzulu kao String
     */
    public abstract String getWhereCondition4();
}
