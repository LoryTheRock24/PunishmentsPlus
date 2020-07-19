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
import ro.plugin.punishmentsplus.system.ConfigValues;
import ro.plugin.punishmentsplus.system.MuteAction;

@SuppressWarnings("ALL")
public class NormalMuteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 2) {
            if (sender.hasPermission("mute.execute")) {
                if (!MuteAction.isMuted(args[0])) {
                    if (!ConfigValues.overridePlayers.contains(args[0])) {

                        MuteAction.mute(args[0], getMotive(args), getExecutor(sender));
                        sender.sendMessage(ConfigValues.MUTE_SUCCESSFUL(args[0], getMotive(args)));
                        return true;
                    }

                    sender.sendMessage(ConfigValues.MUTE_IMPOSSIBLE);
                    return true;
                }

                sender.sendMessage(ConfigValues.ALREADY_MUTED);
                return true;
            }

            sender.sendMessage(ConfigValues.NO_PERMISSION);
            return true;
        }

        sender.sendMessage(ConfigValues.SYNTAX_ERROR);
        return true;
    }

    public String getMotive(String[] args) {
        String motive = "";

        for (int a = 0; a < args.length; a++) {
            if (a == 0) {
                motive = motive + "";
                continue;
            }
            motive = motive + args[a] + " ";
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
