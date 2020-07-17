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

/**
 * This class contains all the SQL strings which will then be used when we operate on a database
 */
public abstract class SQLite {

    /**
     * This is a SQL string for create a table into the database.
     */
    public static String CREATE_BAN_TABLE = "CREATE TABLE IF NOT EXISTS " +
                                                      "bans(" +
                                                 "player varchar, " +
                                                 "motive varchar," +
                                                "executor varchar" +
                                                        ")";

    /**
     * This is a SQL string for add a player to the ban's list.
     */
    public static String ADD_PLAYER_BANDATA = "INSERT INTO " +
                                                 "bans(" +
                                               "'player'," +
                                               "'motive'," +
                                              "'executor'" +
                                                   ")" +
                                              "VALUES (?,?,?)";

    /**
     * This is a SQL string for select the banned players' list.
     */
    public static String SELECT_BAN_PLAYER_LIST = "SELECT player " +
                                                  "FROM bans";

    /**
     * This is a SQL method for get the executor of a ban. This method need the
     * banned player for get his ban executor.
     */
    public static String SELECT_BAN_EXECUTOR(String player) {
        return "SELECT executor FROM bans WHERE player='" + player + "';";
    }

    /**
     * This is a SQL method for get the motive of a ban. This method need the
     * banned player for get his ban executor.
     */
    public static String SELECT_BAN_MOTIVE(String player) {
        return "SELECT motive FROM bans WHERE player='" + player + "';";
    }

    /**
     * This is a SQL method for remove a player from the bans' data.
     */
    public static String REMOVE_BANNED_PLAYER(String player) {
        return "DELETE FROM bans WHERE player='" + player +"';";
    }
}