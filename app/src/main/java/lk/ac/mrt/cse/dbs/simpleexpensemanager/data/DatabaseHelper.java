package lk.ac.mrt.cse.dbs.simpleexpensemanager.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "180420L";
    private static final int DATABASE_VERSION = 7;
    //table names
    public static final String ACCOUNTS_TABLE = "accounts";
    public static final String TRANSACTIONS_TABLE = "transactions";

    //column names
    public static final String ACCOUNT_NO = "accountNo";
    public static final String BANK_NAME = "bankName";
    public static final String ACCOUNT_HOLDER_NAME = "accountHolderName";
    public static final String BALANCE = "balance";
    private static final String TRANSACTION_ID = "id";
    public static final String EXPENSE_TYPE = "expenseType";
    public static final String AMOUNT = "amount";
    public static final String DATE = "date";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    }


    //create account table and transaction table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ACCOUNTS_TABLE + "("
                + ACCOUNT_NO + " TEXT PRIMARY KEY," + BANK_NAME + " TEXT,"
                + ACCOUNT_HOLDER_NAME + " TEXT," + BALANCE + " REAL" + ")");
        sqLiteDatabase.execSQL("CREATE TABLE " + TRANSACTIONS_TABLE + "("
                + TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DATE + " TEXT," + ACCOUNT_NO + " TEXT,"
                + EXPENSE_TYPE + " TEXT," + AMOUNT + " REAL," + "FOREIGN KEY(" + ACCOUNT_NO +
                ") REFERENCES "+ ACCOUNTS_TABLE +"(" + ACCOUNT_NO + ") )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop tables if exist
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + ACCOUNTS_TABLE + "'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TRANSACTIONS_TABLE + "'");

        // re create the tables
        onCreate(sqLiteDatabase);
    }
}
