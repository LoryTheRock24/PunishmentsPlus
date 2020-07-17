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
import ro.plugin.punishmentsplus.system.ConfigValues;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender.hasPermission("pphelp.view")) {
                sender.sendMessage("§cPunishmentsPlus§f Help Page:\n" +
                        "§c/pphelp§f = View this page.\n" +
                        "§c/ban <player> <motive>§f = Permanently ban a player from the server.\n" +
                        "§c/unban <player>§f = Unban a player from the server.\n" +
                        "§c/kick <player> <motive>§f = Kick a player from the server");
                return true;
            }

            sender.sendMessage(ConfigValues.NO_PERMISSION);
            return true;
        }

        sender.sendMessage(ConfigValues.SYNTAX_ERROR);
        return true;
    }
}
