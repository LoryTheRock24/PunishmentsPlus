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

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ro.plugin.punishmentsplus.data.LoadDataSystem;

public final class PunishmentsPlus extends JavaPlugin {

    public static PunishmentsPlus Instance;

    @Override
    public void onEnable() {
        Instance = this;
        LoadDataSystem.load();
        this.saveDefaultConfig();

        Bukkit.getLogger().info("[PunishmentsPlus] Plugin Enabled.");
        Bukkit.getPluginManager().registerEvents(new PluginListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[PunishmentsPlus] Plugin Disabled.");
    }
}
