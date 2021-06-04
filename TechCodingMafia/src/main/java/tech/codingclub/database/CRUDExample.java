package tech.codingclub.database;

import org.jooq.util.derby.sys.Sys;
import tech.codingclub.entity.Coders;

import java.util.Date;
import java.util.List;

public class CRUDExample {

    private static void readTableCoders() {
        List<Coders> coder_rows = (List<Coders>) GenericDB.getRows(tech.codingclub.tables.Coders.CODERS,Coders.class,null,null);
        for(Coders row : coder_rows)
        {
            System.out.println("Row : "+row.getName()+" , age : "+row.getAge());
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("CRUD running at :"+ new Date().toString());

        //Reading One row
        Coders coder = new GenericDB<Coders>().getRow(tech.codingclub.tables.Coders.CODERS,Coders.class,null);
        System.out.println("Row : "+coder.getName()+" , age : "+coder.getAge());
        System.out.println("##########################################");

        //Reading entire table/ all row
        readTableCoders();
        System.out.println("##########################################");

        //Update name to codingMafia where name is Subhojit
        new GenericDB<String>().updateColumn(tech.codingclub.tables.Coders.CODERS.NAME, "CodingMafia", tech.codingclub.tables.Coders.CODERS, tech.codingclub.tables.Coders.CODERS.NAME.eq("Subhojit"));
        readTableCoders();
        System.out.println("##########################################");

        //deleting a row

    }
}
