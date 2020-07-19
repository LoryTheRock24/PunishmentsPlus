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

package ro.plugin.punishmentsplus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import ro.plugin.punishmentsplus.events.ChatListener;
import ro.plugin.punishmentsplus.system.BanAction;
import ro.plugin.punishmentsplus.system.ConfigValues;

/**
 * The plugin listener for manage all the plugin's necessary events.
 */
@SuppressWarnings("ALL")
public class PluginListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player plr = e.getPlayer();

        if (BanAction.isPermanentlyBanned(plr.getName())) {
            plr.kickPlayer(ConfigValues.JOIN_PERMANENTLY_BANNED_MESSAGE(BanAction.getBanExecutor(plr.getName()),
                    BanAction.getBanMotivation(plr.getName())));
        }
    }

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        ChatListener.firstEvent(e);
    }

    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent e) {
        ChatListener.secondEvent(e);
    }
}
