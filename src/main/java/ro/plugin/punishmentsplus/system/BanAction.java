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

package ro.plugin.punishmentsplus.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ro.plugin.punishmentsplus.data.DataHandler;
import ro.plugin.punishmentsplus.data.SQLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class for execute a ban / kick to a player. In this class, the ban is only permanent.
 */
public class BanAction {

    /**
     * Method for ban a player; The first string's the player name and the another is the ban's motive. If
     * the sender doesn't want to send the ban's reason, the parameter "motive" is not important.
     */
    public static void ban(String player, String motive, String banExecutor) {
        Player plr = Bukkit.getPlayerExact(player);

        DataHandler.addPlayer(player, motive, banExecutor); // Add a player to the ban's list into the data.sqlite.

        if (ConfigValues.isPublicBanMessageEnabled) {
            Bukkit.getServer().broadcastMessage(ConfigValues.PUBLIC_BAN_MESSAGE(player, motive, banExecutor, "PERMANENT"));
        }

        if (plr != null) {
            plr.kickPlayer(ConfigValues.JOIN_PERMANENTLY_BANNED_MESSAGE(banExecutor, motive));
        }
    }

    /**
     * Method for un_ban a player into the server. The method doesn't check if a player is banned. For check it, you
     * need to use a system using the method "isBanned()".
     */
    public static void un_ban(String player, String unbanExecutor) {
        DataHandler.removePlayer(player); // Remove a player to the database's bans table.

        if (ConfigValues.isPublicUnbanMessageEnabled) {
            Bukkit.getServer().broadcastMessage(ConfigValues.PUBLIC_UNBAN_MESSAGE(player, unbanExecutor));
        }
    }

    /**
     * Method for kick a player from the server. The kick's used for remove a player from the server. When the player
     * is kicked, it can rejoin into the server.
     */
    public static void kick(String player, String reason) {
        Player plr = Bukkit.getPlayerExact(player);

    }

    /**
     * Boolean method for check if a player is permanently banned.
     */
    public static boolean isPermanentlyBanned(String player) {
        List<String> data = new ArrayList<>();
        int count = 1;

        try {
            DataHandler.openConnection();

            Statement st = DataHandler.connection.createStatement();
            ResultSet rs;

            rs = st.executeQuery(SQLite.SELECT_BAN_PLAYER_LIST);

            while (rs.next()) {
                data.add(rs.getString("player"));
                count++;
            }

            st.close();

            DataHandler.closeConnection();

            if (data.contains(player)) return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Boolean method for check if a player is temporarily banned.
     */
    public static boolean isTemporarilyBanned(String player) {
        return false;
    }

    /**
     * Method for get the executor of a ban.
     */
    public static String getBanExecutor(String bannedPlayer) {
        String banExecutor = "";

        try {
            DataHandler.openConnection();

            Statement st = DataHandler.connection.createStatement();
            ResultSet rs;

            rs = st.executeQuery(SQLite.SELECT_BAN_EXECUTOR(bannedPlayer));
            banExecutor = rs.getString("executor");
            st.close();

            DataHandler.closeConnection();

            return banExecutor;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banExecutor;
    }

    /**
     * Method for get the motive of a ban.
     */
    public static String getBanMotivation(String bannedPlayer) {
        String banMotive = "";

        try {
            DataHandler.openConnection();

            Statement st = DataHandler.connection.createStatement();
            ResultSet rs;

            rs = st.executeQuery(SQLite.SELECT_BAN_MOTIVE(bannedPlayer));
            banMotive = rs.getString("motive");
            st.close();

            DataHandler.closeConnection();

            return banMotive;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return banMotive;
    }
}
