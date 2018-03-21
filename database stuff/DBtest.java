
/**
 * Created by I72600K on 3/20/2018.
 */

import android.database.SQLException;
import java.io.IOException;
public class DBtest {
    private void main() {
        DataBaseHelper myDbHelper = new DataBaseHelper();
        myDbHelper = new DataBaseHelper(this);

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }
    }
}
