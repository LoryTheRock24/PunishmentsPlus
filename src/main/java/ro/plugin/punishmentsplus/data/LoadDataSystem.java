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

import ro.plugin.punishmentsplus.PunishmentsPlus;

import java.io.File;

public class LoadDataSystem {

    private static final LoadDataSystem LoadDataSystem = new LoadDataSystem();

    /**
     * Method for load all the plugin's data folders and sqlite files.
     */
    public static void load() {

        LoadDataSystem.loadDatabasesFolder();
        LoadDataSystem.loadDataFolder();

        new BanData();
    }

    /**
     * Method for create the databases' folder. Into this folder, will be inserted some sqlite databases;
     * For example, the bandata.sqlite and the mutedata.sqlite
     */
    public void loadDatabasesFolder() {
        File file = new File(PunishmentsPlus.Instance.getDataFolder() + File.separator + "databases");
        file.mkdir();
    }

    /**
     * Method for load the plugin's data folder.
     */
    public void loadDataFolder() {
        PunishmentsPlus.Instance.getDataFolder().mkdir();
    }
}
