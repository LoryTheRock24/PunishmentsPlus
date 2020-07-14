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

/**
 * Class for manage the bandata.db database.
 */
public class BanDataHandler {

    public static BanDataHandler BanDataHandler = new BanDataHandler();

    public Connection connection;

    /**
     * Method for get the connection from the bandata.db database.
     */
    public static void openConnection() {
        try {
            BanDataHandler.connection = DriverManager.getConnection("jdbc:sqlite:" + CreateDatabases.BanData.getAbsolutePath());
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Could not open the bandata.sqlite connection.");
        }
    }

    public static void closeConnection() {
        try {
            BanDataHandler.connection.close();
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Could not close the bandata.sqlite connection.");
        }
    }

    /**
     * Method for create a table into the bandata.db database.
     */
    public static void createTable() {
        try {
            openConnection();
            Statement st = BanDataHandler.connection.createStatement();
            st.execute(SQLite.CREATE_BAN_TABLE);
            closeConnection();
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Creation of the bandata.db database's data-table failed.");
        }
    }


}
