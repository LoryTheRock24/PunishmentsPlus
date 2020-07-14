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

package ro.plugin.punishmentsplus.data;

import org.bukkit.Bukkit;
import ro.plugin.punishmentsplus.PunishmentsPlus;

import java.io.File;
import java.io.IOException;

/**
 * Class for create the plugin database.
 */
public class CreateDatabase {

    public static final File BanData = new File(PunishmentsPlus.Instance.getDataFolder() + "/data.sqlite");

    public CreateDatabase() {
        if (!BanData.exists()) {
            try {
                BanData.createNewFile();
                DataHandler.createBanTable();

                Bukkit.getLogger().info("[PunishmentsPlus] data.sqlite file creation successful!");
            } catch (IOException e) {
                Bukkit.getLogger().warning("[PunishmentsPlus] Creation of the data.sqlite file failed!");
            }
        }
    }
}
