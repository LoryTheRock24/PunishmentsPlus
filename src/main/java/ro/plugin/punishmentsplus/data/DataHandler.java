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

package ro.plugin.punishmentsplus.data;

import org.bukkit.Bukkit;

import java.sql.*;

/**
 * Class for manage the data.sqlite database.
 */
public class DataHandler {

    public static Connection connection;

    /**
     * Method for get the connection from the data.sqlite database.
     */
    public static void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + CreateDatabase.BanData.getAbsolutePath());
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Could not open the bandata.sqlite connection.");
        }
    }

    /**
     * Method for close the data.sqlite's connection
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Could not close the bandata.sqlite connection.");
        }
    }

    /**
     * Method for create a table into the data.sqlite database.
     */
    public static void createBanTable() {
        try {
            openConnection();
            Statement st = connection.createStatement();
            st.execute(SQLite.CREATE_BAN_TABLE);
            st.close();
            closeConnection();
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Creation of the bandata.sqlite database's data-table failed.");
        }
    }

    /**
     * Method for add a player into the bans table.
     */
    public static void addPlayer(String playerName, String banMotive, String banExecutor) {
        try {
            openConnection();
            PreparedStatement pst = connection.prepareStatement(SQLite.ADD_PLAYER_BANDATA);

            pst.setString(1, playerName);
            pst.setString(2, banMotive);
            pst.setString(3, banExecutor);
            pst.executeUpdate();

            closeConnection();
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Error while adding the player " + playerName + " to the plugin's database.");
        }
    }

    /**
     * Method for remove a player from the bans table.
     */
    public static void removePlayer(String playerName) {
        try {
            openConnection();
            PreparedStatement pst = connection.prepareStatement(SQLite.REMOVE_BANNED_PLAYER(playerName));

            pst.executeUpdate();

            closeConnection();
        } catch (SQLException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Error while removing the player " + playerName + " from the plugin's database.");
        }
    }
}
