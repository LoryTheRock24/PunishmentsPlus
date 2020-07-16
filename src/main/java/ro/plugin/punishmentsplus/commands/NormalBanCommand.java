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

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ro.plugin.punishmentsplus.system.BanAction;
import ro.plugin.punishmentsplus.system.ConfigValues;

@SuppressWarnings("ALL")
public class NormalBanCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 2) {
            Player player = Bukkit.getPlayerExact(args[0]);
            String motive = "";

            if (sender.hasPermission("ban.execute")) {
                if (!BanAction.isPermanentlyBanned(args[0]) && !BanAction.isTemporarilyBanned(args[0])) {
                    if (sender.hasPermission("ban.override")) {
                        sender.sendMessage(ConfigValues.banImpossible);
                        return true;
                    }

                    sender.sendMessage(ConfigValues.banSuccessful(args[0], getMotive(args)));
                    BanAction.ban(args[0], getMotive(args), getExecutor(sender));
                    return true;
                }
                sender.sendMessage(ConfigValues.alreadyBanned);
                return true;
            }
            sender.sendMessage(ConfigValues.noPermissionMessage);
            return true;
        }
        sender.sendMessage(ConfigValues.syntaxError);
        return true;
    }

    public String getMotive(String[] args) {
        String motive = "";

        for (int n = 1; n < args.length; n++) {
            if (n == args.length) {
                motive = motive + args[n];
                break;
            }
            motive = motive + args[0] + " ";
        }
        return motive;
    }

    public String getExecutor(CommandSender sender) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            return p.getName();
        }
        return "SERVER";
    }
}
