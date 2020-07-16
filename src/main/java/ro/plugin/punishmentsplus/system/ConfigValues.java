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

public abstract class ConfigValues {

    private static FileConfiguration config = PunishmentsPlus.Instance.getConfig();

    private static final String enablePublicBanMessage = config.getString("Settings.enablePublicBanMessage");
    private static final String enablePublicUnbanMessage = config.getString("Settings.enablePublicUnbanMessage");

    public static final String noPermissionMessage = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.noPermission"));
    public static final String syntaxError = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.syntaxError"));
    public static final String alreadyBanned = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.alreadyBanned"));
    public static final String banImpossible = PrincipalMessaging.parseMessage(
            config.getString("Settings.Messages.banImpossible"));

    public static String banSuccessful(String player, String motive) {
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

    public static boolean isPublicBanMessageEnabled = Boolean.parseBoolean(enablePublicBanMessage);
    public static boolean isPublicUnbanMessageEnabled = Boolean.parseBoolean(enablePublicUnbanMessage);
}
