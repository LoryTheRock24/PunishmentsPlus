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

/**
 * This is the class for execute a ban / kick to a player. In this class, the ban is only permanent.
 */
public class BanAction {

    /**
     * Method for ban a player; The first string's the player name and the another is the ban's motive. If
     * the sender doesn't want to send the ban's reason, the parameter "motive" is not important.
     */
    public static void ban(String player, String motive) {
        Player plr = Bukkit.getPlayerExact(player);

        DataHandler.addPlayer(player, motive); // Add a player to the ban's list into the data.sqlite.
    }

    /**
     * Method for un_ban a player into the server. The method doesn't check if a player is banned. For check it, you
     * need to use a system using the method "isBanned()".
     */
    public static void un_ban(String player) {

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
        return false;
    }

    /**
     * Boolean method for check if a player is temporarily banned.
     */
    public static boolean isTemporarilyBanned(String player) {
        return false;
    }
}
