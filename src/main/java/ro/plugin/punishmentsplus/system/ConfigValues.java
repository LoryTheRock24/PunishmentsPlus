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

import org.bukkit.configuration.file.FileConfiguration;
import ro.plugin.punishmentsplus.PunishmentsPlus;

import java.util.List;

public abstract class ConfigValues {

    private static final FileConfiguration config = PunishmentsPlus.Instance.getConfig();

    public static final String NO_PERMISSION = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.noPermission"));
    public static final String SYNTAX_ERROR = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.syntaxError"));
    public static final String ALREADY_BANNED = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.alreadyBanned"));
    public static final String BAN_IMPOSSIBLE = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.banImpossible"));
    public static final String NOT_BANNED = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.notBanned"));
    public static final String KICK_IMPOSSIBLE = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.kickImpossible"));
    public static final String KICK_PLAYER_NOT_ONLINE = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.kickPlayerNotOnline"));

    public static final List<String> overridePlayers = config.getStringList("Settings.overridePlayers");

    public static String PUBLIC_KICK_MESSAGE(String kickedPlayer, String kickExecutor, String motive) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.publicKickMessage")
                .replace("%KICKED-PLAYER%", kickedPlayer).replace("%KICK-EXECUTOR%", kickExecutor)
                .replace("%MOTIVATION%", motive));
    }

    public static String KICK_MESSAGE(String kickExecutor, String motive) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.kickMessage")
                .replace("%KICK-EXECUTOR%", kickExecutor).replace("%MOTIVATION%", motive));
    }

    public static String KICK_SUCCESSFUL(String player, String motive) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.kickSuccessful")
                .replace("%KICKED-PLAYER%", player).replace("%MOTIVATION%", motive));
    }

    public static String PLAYER_UNBANNED(String player) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.playerUnbanned")
                .replace("%BANNED-PLAYER%", player));
    }

    public static String BAN_SUCCESSFUL(String player, String motive) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.banSuccessful")
                .replace("%BANNED-PLAYER%", player).replace("%MOTIVATION%", motive));
    }

    public static String JOIN_PERMANENTLY_BANNED_MESSAGE(String banExecutor, String Motive) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.joinBanPermanently"))
                .replace("%BAN-EXECUTOR%", banExecutor).replace("%MOTIVATION%", Motive);
    }

    public static String PUBLIC_BAN_MESSAGE(String bannedPlayer, String motive, String banExecutor, String duration) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.publicBanMessage")
                .replace("%BANNED-PLAYER%", bannedPlayer).replace("%BAN-EXECUTOR%", banExecutor)
                .replace("%MOTIVATION%", motive).replace("%DURATION%", duration));
    }

    public static String PUBLIC_UNBAN_MESSAGE(String bannedPlayer, String unbanExecutor) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.publicUnbanMessage")
                .replace("%BANNED-PLAYER%", bannedPlayer).replace("%UNBAN-EXECUTOR%", unbanExecutor));
    }

    public static boolean IS_PUBLIC_BAN_MESSAGE_ENABLED = Boolean.parseBoolean(
            config.getString("Settings.enablePublicBanMessage"));
    public static boolean IS_PUBLIC_UNBAN_MESSAGE_ENABLED = Boolean.parseBoolean(
            config.getString("Settings.enablePublicUnbanMessage"));
    public static boolean IS_PUBLIC_KICK_MESSAGE_ENABLED = Boolean.parseBoolean(
            config.getString("Settings.enablePublicKickMessage"));
}
