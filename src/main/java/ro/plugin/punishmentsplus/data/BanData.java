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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for create the file bandata.sqlite, used for save the list of the banned's players.
 */
public class BanData {

    public Connection connection;

    public static final File file = new File(PunishmentsPlus.Instance.getDataFolder() + "/databases/bandata.db");

    public BanData() {
        if (file.exists()) return;

        try {
            file.createNewFile();

            Bukkit.getLogger().info("[PunishmentsPlus] bandata.sqlite file successfully created!");

        } catch (IOException e) {
            Bukkit.getLogger().warning("[PunishmentsPlus] Could not create the file bandata.sqlite!");
        }
    }

    public Connection getDatabaseConnection() {
        if (connection != null) return connection;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createBanTable() {
        try {
            Statement st = getDatabaseConnection().createStatement();
            st.execute(SQLite.CREATE_BAN_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
