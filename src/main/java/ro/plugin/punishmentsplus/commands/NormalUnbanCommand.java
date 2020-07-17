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

package ro.plugin.punishmentsplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ro.plugin.punishmentsplus.system.BanAction;
import ro.plugin.punishmentsplus.system.ConfigValues;

public class NormalUnbanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (sender.hasPermission("ban.execute")) {
                if (BanAction.isPermanentlyBanned(args[0]) || BanAction.isTemporarilyBanned(args[0])) {

                    sender.sendMessage(ConfigValues.PLAYER_UNBANNED(args[0]));
                    BanAction.un_ban(args[0], getExecutor(sender));
                    return true;
                }

                sender.sendMessage(ConfigValues.NOT_BANNED);
                return true;
            }

            sender.sendMessage(ConfigValues.NO_PERMISSION);
            return true;
        }

        sender.sendMessage(ConfigValues.SYNTAX_ERROR);
        return true;
    }

    public String getExecutor(CommandSender sender) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            return p.getName();
        }
        return "SERVER";
    }
}
