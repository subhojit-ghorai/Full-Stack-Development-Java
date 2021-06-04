package tech.codingclub.database;

import tech.codingclub.entity.Coders;

public class TestCodersTable {

    public static void main(String[] args) {

        Coders subhojit = new Coders("Subhojit", 21L );
        Coders coder_spammer = new Coders("SPAMMER", 50L );

        //Insert this object into DB !

//           < ENTITY CLASS>
        new GenericDB<Coders>().addRow(tech.codingclub.tables.Coders.CODERS, subhojit);
        new GenericDB<Coders>().addRow(tech.codingclub.tables.Coders.CODERS, coder_spammer);


        //CRUD example
        //create read update delete
    }
}
