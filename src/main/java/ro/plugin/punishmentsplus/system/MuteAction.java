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
 * Class for manage the mute system.
 */
public class MuteAction {

    /**
     * Method for mute a player from the server's chat.
     */
    public static void mute(String player, String motive, String executor) {
        Player plr = Bukkit.getPlayerExact(player);

        DataHandler.addMutedPlayer(player);

        if (plr != null)
            plr.sendMessage(ConfigValues.PRIVATE_MUTE_MESSAGE(executor, motive));

        if (ConfigValues.IS_PUBLIC_MUTE_MESSAGE_ENABLED)
            Bukkit.getServer().broadcastMessage(ConfigValues.PUBLIC_MUTE_MESSAGE(player, executor, motive));
    }

    /**
     * Method for unmute a player from the server's chat.
     */
    public static void un_mute(String player, String executor) {
        Player plr = Bukkit.getPlayerExact(player);

        DataHandler.removeMutedPlayer(player);

        if (plr != null)
            plr.sendMessage(ConfigValues.PRIVATE_UNMUTE_MESSAGE(executor));

        if (ConfigValues.IS_PUBLIC_UNMUTE_MESSAGE_ENABLED)
            Bukkit.getServer().broadcastMessage(ConfigValues.PUBLIC_UNMUTE_MESSAGE(player, executor));
    }

    /**
     * Method for get if a player is muted.
     */
    public static boolean isMuted(String player) {
        List<String> data = new ArrayList<>();

        try {
            DataHandler.openConnection();

            Statement st = DataHandler.connection.createStatement();
            ResultSet rs;

            rs = st.executeQuery(SQLite.SELECT_MUTED_PLAYER_LIST);

            while (rs.next()) {
                data.add(rs.getString("player"));
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
     * Method for check if a muted player is executing a prohibited command.
     */
    public static boolean isProhibitedCommand(String command) {
        return ConfigValues.prohibitedCommandsOnMute.contains(command);
    }
}
