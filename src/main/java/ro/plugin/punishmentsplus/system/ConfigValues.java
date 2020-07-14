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

    public static String JOIN_PERMANENTLY_BANNED_MESSAGE(String banExecutor, String Motive) {
        return PrincipalMessaging.parseMessage(config.getString("Settings.Messages.joinBanPermanently"))
                .replace("%BAN-EXECUTOR%", banExecutor)
                .replace("%MOTIVATION%", Motive);
    }

}
