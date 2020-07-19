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

package ro.plugin.punishmentsplus.events;

import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ro.plugin.punishmentsplus.system.ConfigValues;
import ro.plugin.punishmentsplus.system.MuteAction;

@SuppressWarnings("ALL")
public class ChatListener {
    public static void firstEvent(PlayerChatEvent e) {
        if (!MuteAction.isMuted(e.getPlayer().getName())) return;

        e.setCancelled(true);
        e.getPlayer().sendMessage(ConfigValues.MUTED_PLAYER_MESSAGE);
    }

    public static void secondEvent(PlayerCommandPreprocessEvent e) {
        String command = e.getMessage().split("\\s")[0];

        if (!MuteAction.isProhibitedCommand(command)) return;

        e.setCancelled(true);
        e.getPlayer().sendMessage(ConfigValues.MUTED_PLAYER_MESSAGE);
    }
}
