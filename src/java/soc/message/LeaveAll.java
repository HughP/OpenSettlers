/**
 * Open Settlers - an open implementation of the game Settlers of Catan
 * Copyright (C) 2003  Robert S. Thomas
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. **/
package soc.message;


/**
 * This message means that someone is leaving all the channels
 *
 * @author Robert S Thomas
 */
public class LeaveAll extends Message
{
    private static final long serialVersionUID = 8000533716630858375L;

    /**
     * Create a LeaveAll message.
     *
     */
    public LeaveAll()
    {
        messageType = LEAVEALL;
    }

    /**
     * <LEAVEALL>
     *
     * @return the command String
     */
    public String toCmd()
    {
        return Integer.toString(LEAVEALL);
    }

    /**
     * Parse the command String into a LeaveAll message
     *
     * @param s   the String to parse
     * @return    a LeaveAll message
     */
    public static LeaveAll parseDataStr(String s)
    {
        return new LeaveAll();
    }

    /**
     * @return a human readable form of the message
     */
    public String toString()
    {
        return "LeaveAll:";
    }
}
