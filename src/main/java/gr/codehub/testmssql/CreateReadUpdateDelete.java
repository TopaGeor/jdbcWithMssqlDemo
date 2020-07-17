package gr.codehub.testmssql;


import gr.codehub.testmssql.dao.*;

public class CreateReadUpdateDelete {

    public static void main(String[] args) throws Exception {

        CreateTablesExample.main(args);
        InsertExample.main(args);
        ResultSetExample.main(args);
        UpdateExample.main(args);
        DeleteExample.main(args);
        TransactionExample.main(args);
    }
}
