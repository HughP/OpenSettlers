/**
 * Open Settlers - an open implementation of the game Settlers of Catan
 * Copyright (C) 2003  Robert S. Thomas
 * Portions of this file Copyright (C) 2010 Jeremy D Monin <jeremy@nand.net>
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

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;


/**
 * This message lists all the chat channels on a server
 *
 * @author Robert S Thomas
 */
public class Channels extends Message
{
    private static final long serialVersionUID = -4840797936493586631L;
    /**
     * List of channels
     */
    private Vector channels;

    /**
     * Create a Channels Message.
     *
     * @param cl  list of channels
     */
    public Channels(Vector cl)
    {
        messageType = CHANNELS;
        channels = cl;
    }

    /**
     * @return the list of channels
     */
    public Vector getChannels()
    {
        return channels;
    }

    /**
     * CHANNELS sep channels
     *
     * @return the command String
     */
    public String toCmd()
    {
        return toCmd(channels);
    }

    /**
     * CHANNELS sep channels
     *
     * @param cl  the list of channels
     * @return    the command string
     */
    public static String toCmd(Vector cl)
    {
        String cmd = CHANNELS + sep;

        try
        {
            Enumeration clEnum = cl.elements();
            cmd += (String) clEnum.nextElement();

            while (clEnum.hasMoreElements())
            {
                cmd += (sep2 + (String) clEnum.nextElement());
            }
        }
        catch (Exception e) {}

        return cmd;
    }

    /**
     * Parse the command String into a Channels message
     *
     * @param s   the String to parse
     * @return    a Channels message, or null of the data is garbled
     */
    public static Channels parseDataStr(String s)
    {
        Vector cl = new Vector();
        StringTokenizer st = new StringTokenizer(s, sep2);

        try
        {
            while (st.hasMoreTokens())
            {
                cl.addElement(st.nextToken());
            }
        }
        catch (Exception e)
        {
            System.err.println("Channels parseDataStr ERROR - " + e);

            return null;
        }

        return new Channels((Vector) cl);
    }

    /**
     * @return a human readable form of the message
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer("Channels:channels=");
        if (channels != null)
            enumIntoStringBuf(channels.elements(), sb);
        return sb.toString();
    }
}
