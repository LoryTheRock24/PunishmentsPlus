/*
 * Copyright © 2020 LoryTheRock24
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package ro.plugin.punishmentsplus.datahandlers;

import org.bukkit.Bukkit;
import ro.plugin.punishmentsplus.data.CreateDatabases;
import ro.plugin.punishmentsplus.data.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * Class for manage the bandata.db database.
 */
public class BanDataHandler {

    public static BanDataHandler BanDataHandler = new BanDataHandler();

    public Connection connection;

    /**
     * Method for get the connection from the bandata.db database.
     */
    public static Connection getDatabaseConnection() {
        if (BanDataHandler.connection != null) return BanDataHandler.connection;

        try {
            BanDataHandler.connection = DriverManager.getConnection("jdbc:sqlite:" + CreateDatabases.BanData.getAbsolutePath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method for create a table into the bandata.db database.
     */
    public static void createTable() {
        try {
            Statement st = Objects.requireNonNull(getDatabaseConnection()).createStatement();
            st.execute(SQLite.CREATE_BAN_TABLE);
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Creation of the bandata.db database's data-table failed.");
        }
    }


}
